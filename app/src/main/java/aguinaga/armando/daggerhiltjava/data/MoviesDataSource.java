package aguinaga.armando.daggerhiltjava.data;

import aguinaga.armando.daggerhiltjava.data.model.ResponseMovies;
import io.reactivex.rxjava3.core.Observable;

public interface MoviesDataSource {

    Observable<ResponseMovies> getMoviesFromBackend(int page);

}
