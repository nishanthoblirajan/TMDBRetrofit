package com.zaptrapp.tmdbretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.zaptrapp.tmdbretrofit.Adapter.MovieAdapter;
import com.zaptrapp.tmdbretrofit.RetroFit.ApiClient;
import com.zaptrapp.tmdbretrofit.RetroFit.ApiInterface;
import com.zaptrapp.tmdbretrofit.RetroFit.Movie;
import com.zaptrapp.tmdbretrofit.RetroFit.MovieResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    MovieAdapter mMovieAdapter;
    RecyclerView mRecyclerView;


    private static final String API_KEY = "50b35f247a284a75b2d7f54c71519a3e";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiInterface =
                ApiClient.getClient().create(ApiInterface.class);

        Call<MovieResponse> call = apiInterface.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {

                List<Movie> movies = response.body().getResults();
                mMovieAdapter = new MovieAdapter(movies);
                mRecyclerView.setAdapter(mMovieAdapter);

                Log.d(TAG, "onResponse: "+movies.get(1).getTitle());
                Log.d("Raw Data",response.raw().toString());
                Toast.makeText(MainActivity.this, "received", Toast.LENGTH_SHORT).show();
                Log.d("Top rated movies size ",movies.size()+" ");
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();

            }
        });




//        Call<Movie> number550 = apiInterface.getMovieDetails(550,API_KEY);
//        number550.enqueue(new Callback<Movie>() {
//            @Override
//            public void onResponse(Call<Movie> call, Response<Movie> response) {
//                Log.d("ID - 550 ",response.raw().toString());
//                Log.d("ID - 550 ",response.body().getTitle());
//
//            }
//
//            @Override
//            public void onFailure(Call<Movie> call, Throwable t) {
//
//            }
//        });

    }
}
