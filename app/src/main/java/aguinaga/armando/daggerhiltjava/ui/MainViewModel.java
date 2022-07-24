package aguinaga.armando.daggerhiltjava.ui;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import aguinaga.armando.daggerhiltjava.data.model.Movie;
import aguinaga.armando.daggerhiltjava.domain.GetMoviesUseCase;
//import aguinaga.armando.daggerhiltjava.utils.CoroutineJava;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends ViewModel {

    private GetMoviesUseCase getMoviesUseCase;
    @Inject
    MainViewModel(
            GetMoviesUseCase getMoviesUseCase
    ){
        this.getMoviesUseCase = getMoviesUseCase;
    }

    private MutableLiveData<List<Movie>> _receiveMovies;

    public LiveData<List<Movie>> getMovies(){
        return _receiveMovies;
    }

    public void getObserverMovies(boolean value, int page) {
        //getMoviesUseCase.invoke(value, page);
        //_receiveMovies.setValue();
/*        CoroutineJava coroutineJava = new CoroutineJava();
        coroutineJava.launch(() -> {
            getMoviesUseCase.invoke(value, page);
            String aaa = "";
            return null;
        });*/
    }


    private String myText = "Hola";

    public String getMyText(){
        return myText;
    }

    public void modifyMyText(String value){
        myText = myText + value;
    }
}
