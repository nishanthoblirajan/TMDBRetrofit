package com.zaptrapp.tmdbretrofit.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zaptrapp.tmdbretrofit.MovieDetails;
import com.zaptrapp.tmdbretrofit.R;
import com.zaptrapp.tmdbretrofit.RetroFit.Movie;

import java.util.List;

import static com.zaptrapp.tmdbretrofit.MovieDetails.IMAGE_URL_BASE;


/**
 * Created by nishanth on 26/09/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {


    private List<Movie> mMovies;
    private Context mContext;

    public MovieAdapter(List<Movie> movies) {
        mMovies = movies;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_movie_recycler,parent,false);
        return new MyViewHolder(view,this,mMovies);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        //bind items to view
        Glide.with(mContext).load(IMAGE_URL_BASE+mMovies.get(position).getPoster_path()).into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        MovieAdapter adapter;
        private List<Movie> mMovies;


        public MyViewHolder(View itemView, MovieAdapter movieAdapter, List<Movie> movies) {
            super(itemView);
            this.adapter = movieAdapter;
            imageView = itemView.findViewById(R.id.imageViewRecycler);
            itemView.setOnClickListener(this);
            mMovies = movies;
        }


        @Override
        public void onClick(View view) {
            //get the position of the item that was clicked
            int mPosition = getLayoutPosition();
            Movie movieClicked = mMovies.get(mPosition);
            Intent intent = new Intent(view.getContext(), MovieDetails.class);
            intent.putExtra("movieDetails",movieClicked);
            view.getContext().startActivity(intent);
        }
    }


}
