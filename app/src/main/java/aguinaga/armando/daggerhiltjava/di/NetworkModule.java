package aguinaga.armando.daggerhiltjava.di;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import aguinaga.armando.daggerhiltjava.ui.MovieServiceApi;
import aguinaga.armando.daggerhiltjava.utils.Constantes;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class NetworkModule {
    public static final String BASE = "https://api.themoviedb.org/3/movie/";
    public static final String BASE_IMAGES = "https://image.tmdb.org/t/p/w500/";
    private final Long SECONDS_TO_TIME_OUT = 600L;

    @Singleton
    @Provides
    HttpLoggingInterceptor genericHttpLoggingInterceptor()  {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }
    @Singleton
    @Provides
    OkHttpClient genericSafeOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient.Builder()
                .connectTimeout(SECONDS_TO_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(SECONDS_TO_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(SECONDS_TO_TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(chain -> {
                    Request newRequest = chain.request().newBuilder()
                            .addHeader("Authorization","Bearer "+ Constantes.myBearerToken)
                            .build();
                    return chain.proceed(newRequest);
                })
            .build();
    }

    @Singleton
    @Provides
    MovieServiceApi getRetrofit( OkHttpClient genericOkHttpClient)  {
        return new Retrofit.Builder()
                .baseUrl(BASE)
                .client(genericOkHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MovieServiceApi.class);
    }
}
