package aguinaga.armando.daggerhiltjava.data.sources.remote;

import java.util.List;

import javax.inject.Inject;

import aguinaga.armando.daggerhiltjava.data.MoviesDataSource;
import aguinaga.armando.daggerhiltjava.data.model.Movie;
import aguinaga.armando.daggerhiltjava.ui.MovieServiceApi;
import aguinaga.armando.daggerhiltjava.data.model.ResponseMovies;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesRemoteDataSource implements MoviesDataSource {

    private final MovieServiceApi movieServiceApi;
    private ResponseMovies responseMovies = null;
    @Inject
    MoviesRemoteDataSource(
            MovieServiceApi movieServiceApi
    ){
        this.movieServiceApi = movieServiceApi;
    }

    @Override
    public ResponseMovies getMoviesFromBackend(int page) {
        Call<ResponseMovies> call = movieServiceApi.getMovies(page);
        call.enqueue(new Callback<ResponseMovies>() {
            @Override
            public void onResponse(Call<ResponseMovies> call, Response<ResponseMovies> response) {
                responseMovies = response.body();
            }

            @Override
            public void onFailure(Call<ResponseMovies> call, Throwable t) {

            }
        });
        return responseMovies;
    }

    @Override
    public List<Movie> getMovies(int page) {
        return null;
    }
}
