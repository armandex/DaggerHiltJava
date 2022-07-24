package aguinaga.armando.daggerhiltjava.ui;

import aguinaga.armando.daggerhiltjava.data.model.ResponseMovies;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieServiceApi {

    @GET("upcoming?")
    Call<ResponseMovies> getMovies(
            @Query("page")int value
    );
}
