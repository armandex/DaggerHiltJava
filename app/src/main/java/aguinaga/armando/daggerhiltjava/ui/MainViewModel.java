package aguinaga.armando.daggerhiltjava.ui;

import android.util.Log;

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
import aguinaga.armando.daggerhiltjava.data.model.ResponseMovies;
import aguinaga.armando.daggerhiltjava.domain.GetMoviesUseCase;
//import aguinaga.armando.daggerhiltjava.utils.CoroutineJava;
import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

@HiltViewModel
public class MainViewModel extends ViewModel {

    private GetMoviesUseCase getMoviesUseCase;
    @Inject
    MainViewModel(
            GetMoviesUseCase getMoviesUseCase
    ){
        this.getMoviesUseCase = getMoviesUseCase;
    }

    private MutableLiveData<List<Movie>> _receiveMovies = new MutableLiveData<>();

    public LiveData<List<Movie>> getMovies(){
        return _receiveMovies;
    }

    public void getObserverMovies(boolean value, int page) {
         getMoviesUseCase.invoke(value,page)
                .subscribeOn(Schedulers.io())
                .map(responseMovies -> {
                    List<Movie> lista = responseMovies.getResults();
                    for (Movie movie: lista){

                    }
                    return lista;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        result -> _receiveMovies.setValue(result),
                        error -> Log.e("getObserverMovies: ", error.getMessage())
                        );
    }


    private String myText = "Hola";

    public String getMyText(){
        return myText;
    }

    public void modifyMyText(String value){
        myText = myText + value;
    }
}
