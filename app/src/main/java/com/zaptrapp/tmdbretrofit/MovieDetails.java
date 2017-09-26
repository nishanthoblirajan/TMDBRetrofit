package com.zaptrapp.tmdbretrofit;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zaptrapp.tmdbretrofit.RetroFit.Movie;

public class MovieDetails extends AppCompatActivity {


    public static final String IMAGE_URL_BASE = "http://image.tmdb.org/t/p/w500/";
    public static final String IMAGE_URL_ORIGINAL_BASE = "http://image.tmdb.org/t/p/original/";
    private AppBarLayout appbar;
    private ImageView appBarImage;
    private Toolbar toolbar;
    private ImageView detailsPoster;
    private TextView detailsReleaseDate;
    private TextView detailsOverview;
    private TextView detailsAdult;

    private void initView() {
        appbar = (AppBarLayout) findViewById(R.id.appbar);
        appBarImage = (ImageView) findViewById(R.id.app_bar_image);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        detailsPoster = (ImageView) findViewById(R.id.detailsPoster);
        detailsReleaseDate = (TextView) findViewById(R.id.detailsReleaseDate);
        detailsOverview = (TextView) findViewById(R.id.detailsOverview);
        detailsAdult = (TextView) findViewById(R.id.detailsAdult);
        setSupportActionBar(toolbar);
//        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Details");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        initView();

        dataToView();
    }

    private void dataToView() {
        Movie receivedMovie = getIntent().getParcelableExtra("movieDetails");
        Log.d("dataToView", receivedMovie.toString());
        if (receivedMovie != null) {
            toolbar.setTitle(receivedMovie.getTitle());
            detailsReleaseDate.setText(String.valueOf(receivedMovie.getRelease_date()));
            detailsOverview.setText(receivedMovie.getOverview());
            detailsAdult.setText(receivedMovie.isAdult() ? "YES" : "NO");
            Glide.with(this).load(IMAGE_URL_ORIGINAL_BASE + receivedMovie.getPoster_path()).into(detailsPoster);
            Glide.with(this).load(IMAGE_URL_BASE + receivedMovie.getBackdrop_path()).into(appBarImage);
        }
    }
}
