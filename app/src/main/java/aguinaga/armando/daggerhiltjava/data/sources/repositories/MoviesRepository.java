package aguinaga.armando.daggerhiltjava.data.sources.repositories;

import java.util.List;

import javax.inject.Inject;

import aguinaga.armando.daggerhiltjava.data.MoviesDataSource;
import aguinaga.armando.daggerhiltjava.data.model.Movie;
import aguinaga.armando.daggerhiltjava.data.model.ResponseMovies;
import aguinaga.armando.daggerhiltjava.data.sources.remote.MoviesRemoteDataSource;

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
    public ResponseMovies getMoviesFromBackend(int page) {
        return obtenerPeliculasEnCarteleraRemoto(page);
    }

    @Override
    public List<Movie> getMovies(int page) {
        ResponseMovies moviesList = moviesRemoteDataSource.getMoviesFromBackend(page);
        if (moviesList == null){
            return null;
        } else {
            return moviesRemoteDataSource.getMoviesFromBackend(page).getResults();
        }
    }

    private ResponseMovies obtenerPeliculasEnCarteleraRemoto(int page){
        return moviesRemoteDataSource.getMoviesFromBackend(page);
    }
}
