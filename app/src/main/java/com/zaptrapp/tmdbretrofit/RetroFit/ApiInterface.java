package com.zaptrapp.tmdbretrofit.RetroFit;

import io.reactivex.Observable;
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
    @GET("movie/top_rated")
    Observable<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("discover/movie?sort_by=popularity.desc")
    Observable<MovieResponse> getMostPopularMovies(@Query("api_key") String apiKey);

    @GET("discover/movie/?certification_country=US&certification=R&sort_by=vote_average.desc")
    Observable<MovieResponse> getRRatedMovies(@Query("api_key") String apiKey);

    @GET("discover/movie?primary_release_year=2017&sort_by=vote_average.desc")
    Observable<MovieResponse> getBestOf2017Movies(@Query("api_key") String apiKey);


}
