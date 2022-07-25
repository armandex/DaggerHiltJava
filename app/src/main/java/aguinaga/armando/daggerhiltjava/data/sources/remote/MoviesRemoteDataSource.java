package aguinaga.armando.daggerhiltjava.data.sources.remote;

import javax.inject.Inject;

import aguinaga.armando.daggerhiltjava.data.MoviesDataSource;
import aguinaga.armando.daggerhiltjava.ui.MovieServiceApi;
import aguinaga.armando.daggerhiltjava.data.model.ResponseMovies;
import io.reactivex.rxjava3.core.Observable;

public class MoviesRemoteDataSource implements MoviesDataSource {

    private final MovieServiceApi movieServiceApi;
    @Inject
    MoviesRemoteDataSource(
            MovieServiceApi movieServiceApi
    ){
        this.movieServiceApi = movieServiceApi;
    }

    @Override
    public Observable<ResponseMovies> getMoviesFromBackend(int page) {
        return movieServiceApi.getMoviesFromBackend(page);
    }

}
