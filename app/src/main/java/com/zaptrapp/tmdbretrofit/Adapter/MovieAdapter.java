package com.zaptrapp.tmdbretrofit.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.zaptrapp.tmdbretrofit.MovieDetails;
import com.zaptrapp.tmdbretrofit.R;
import com.zaptrapp.tmdbretrofit.RetroFit.Movie;

import java.util.List;


/**
 * Created by nishanth on 26/09/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {


    private List<Movie> mMovies;

    public MovieAdapter(List<Movie> movies) {
        mMovies = movies;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_movie_recycler,parent,false);
        return new MyViewHolder(view,this,mMovies);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        //bind items to view
        holder.title.setText(mMovies.get(position).getTitle());
        holder.description.setText(mMovies.get(position).getOverview());
        holder.budget.setText(mMovies.get(position).getOriginal_language());
    }


    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title;
        TextView description;
        TextView budget;
        MovieAdapter adapter;
        private List<Movie> mMovies;


        public MyViewHolder(View itemView, MovieAdapter movieAdapter, List<Movie> movies) {
            super(itemView);
            title = itemView.findViewById(R.id.titleView);
            description = itemView.findViewById(R.id.descriptionView);
            budget = itemView.findViewById(R.id.budgetView);
            this.adapter = movieAdapter;
            itemView.setOnClickListener(this);
            mMovies = movies;
        }


        @Override
        public void onClick(View view) {
            //get the position of the item that was clicked
            int mPosition = getLayoutPosition();
            Movie movieClicked = mMovies.get(mPosition);
            Toast.makeText(view.getContext(), movieClicked.getTitle(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(view.getContext(), MovieDetails.class);
            intent.putExtra("movieDetails",movieClicked);
            view.getContext().startActivity(intent);
        }
    }


}
