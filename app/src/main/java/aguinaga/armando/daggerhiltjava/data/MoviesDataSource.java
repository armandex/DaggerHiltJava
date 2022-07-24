package aguinaga.armando.daggerhiltjava.data;

import java.util.List;

import aguinaga.armando.daggerhiltjava.data.model.Movie;
import aguinaga.armando.daggerhiltjava.data.model.ResponseMovies;

public interface MoviesDataSource {

    ResponseMovies getMoviesFromBackend(int page);

    List<Movie> getMovies(int page);
}
