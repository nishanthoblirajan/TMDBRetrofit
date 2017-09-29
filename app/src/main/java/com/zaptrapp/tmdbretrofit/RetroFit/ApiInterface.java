package com.zaptrapp.tmdbretrofit.RetroFit;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by nishanth on 26/09/17.
 */

public interface ApiInterface {

    @GET("movie/{id}")
    Call<Movie> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
//
//    @GET("movie/top_rated")
//    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("discover/movie?sort_by=popularity.desc")
    Observable<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);
}
