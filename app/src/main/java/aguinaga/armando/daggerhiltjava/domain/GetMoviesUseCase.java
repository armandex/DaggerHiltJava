package aguinaga.armando.daggerhiltjava.domain;

import java.util.List;

import javax.inject.Inject;

import aguinaga.armando.daggerhiltjava.data.model.Movie;
import aguinaga.armando.daggerhiltjava.data.model.ResponseMovies;
import aguinaga.armando.daggerhiltjava.data.sources.repositories.MoviesRepository;
import io.reactivex.rxjava3.core.Observable;

public class GetMoviesUseCase {

    private MoviesRepository moviesRepository;

    @Inject
    GetMoviesUseCase(
            MoviesRepository moviesRepository
    ){
        this.moviesRepository = moviesRepository;
    }

    public Observable<ResponseMovies> invoke(
            boolean forzarActualizacion,
            int page){
        moviesRepository.forzarActualizacion = forzarActualizacion;

        return moviesRepository.getMoviesFromBackend(page);
    }
}
