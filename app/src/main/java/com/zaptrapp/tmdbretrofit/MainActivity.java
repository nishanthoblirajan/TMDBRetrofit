package com.zaptrapp.tmdbretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.zaptrapp.tmdbretrofit.Adapter.MovieAdapter;
import com.zaptrapp.tmdbretrofit.RetroFit.ApiClient;
import com.zaptrapp.tmdbretrofit.RetroFit.ApiInterface;
import com.zaptrapp.tmdbretrofit.RetroFit.Movie;
import com.zaptrapp.tmdbretrofit.RetroFit.MovieResponse;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    MovieAdapter mMovieAdapter;
    RecyclerView mRecyclerView;

    //RxJava 2
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();


    private static final String API_KEY = "50b35f247a284a75b2d7f54c71519a3e";


    @Override
    protected void onDestroy() {
        mCompositeDisposable.clear();
        super.onDestroy();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));

        ApiInterface apiInterface =
                ApiClient.getClient().create(ApiInterface.class);

        Observable<MovieResponse> movieResponseObservable = apiInterface.getTopRatedMovies(API_KEY);
        movieResponseObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<MovieResponse>() {
                    @Override
                    public void onNext(@NonNull MovieResponse movieResponse) {
                        List<Movie> movies = movieResponse.getResults();
                        mMovieAdapter = new MovieAdapter(movies);
                        mRecyclerView.setAdapter(mMovieAdapter);

                        Log.d(TAG, "onResponse: "+movies.get(1).getTitle());
                        Log.d("Raw Data",movieResponse.toString());
                        Log.d("Top rated movies size ",movies.size()+" ");

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("rxjava2 retrofit2","Error Occured");

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
