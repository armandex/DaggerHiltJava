package aguinaga.armando.daggerhiltjava.data.sources.repositories;

import java.util.List;

import javax.inject.Inject;

import aguinaga.armando.daggerhiltjava.data.MoviesDataSource;
import aguinaga.armando.daggerhiltjava.data.model.Movie;
import aguinaga.armando.daggerhiltjava.data.model.ResponseMovies;
import aguinaga.armando.daggerhiltjava.data.sources.remote.MoviesRemoteDataSource;
import io.reactivex.rxjava3.core.Observable;

public class MoviesRepository implements MoviesDataSource {

    private final MoviesRemoteDataSource moviesRemoteDataSource;
    public boolean forzarActualizacion = false;

    @Inject
    MoviesRepository(
            MoviesRemoteDataSource moviesRemoteDataSource
    ){
        this.moviesRemoteDataSource = moviesRemoteDataSource;
    }

    @Override
    public Observable<ResponseMovies> getMoviesFromBackend(int page) {
        return obtenerPeliculasEnCarteleraRemoto(page);
    }


    private Observable<ResponseMovies> obtenerPeliculasEnCarteleraRemoto(int page){
        return moviesRemoteDataSource.getMoviesFromBackend(page);
    }
}
