package aguinaga.armando.daggerhiltjava.ui;


import aguinaga.armando.daggerhiltjava.data.model.ResponseMovies;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieServiceApi {

    @GET("upcoming?")
    Observable<ResponseMovies> getMoviesFromBackend(
            @Query("page")int value
    );
}
