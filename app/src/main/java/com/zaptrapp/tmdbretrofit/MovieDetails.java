package com.zaptrapp.tmdbretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zaptrapp.tmdbretrofit.RetroFit.Movie;

public class MovieDetails extends AppCompatActivity {

    private TextView detailsTitle;
    private TextView detailsHomepage;
    private TextView detailsBudget;
    private TextView detailsTagline;
    private TextView detailsVote;
    private ImageView detailsPoster;

    private String IMAGE_URL_BASE = "http://image.tmdb.org/t/p/w185/";
    private void initView() {
        detailsTitle = (TextView) findViewById(R.id.detailsTitle);
        detailsHomepage = (TextView) findViewById(R.id.detailsHomepage);
        detailsBudget = (TextView) findViewById(R.id.detailsBudget);
        detailsTagline = (TextView) findViewById(R.id.detailsTagline);
        detailsVote = (TextView) findViewById(R.id.detailsVote);
        detailsPoster = (ImageView) findViewById(R.id.detailsPoster);
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
            detailsTitle.setText(receivedMovie.getTitle());
            detailsHomepage.setText(String.valueOf(receivedMovie.getPopularity()));
            detailsBudget.setText(receivedMovie.getOverview());
            detailsTagline.setText(receivedMovie.getOriginal_language());
            detailsVote.setText(String.valueOf(receivedMovie.getId()));
            Glide.with(this).load(IMAGE_URL_BASE+receivedMovie.getPoster_path()).into(detailsPoster);
        }
    }
}
