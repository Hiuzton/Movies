package com.example.movies.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movies.R;
import com.example.movies.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private Context context;
    private ArrayList<Movie> movies;

    public MovieAdapter(Context context, ArrayList<Movie> movies){
        this.context=context;
        this.movies=movies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.movie_item,parent, false );

        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie currentMovie=movies.get(position);

        String title= currentMovie.getTitle();
        String year= currentMovie.getYear();
        String posterUrl= currentMovie.getPosterUrl();

        holder.titleTextView.setText(title);
        holder.yearTextView.setText(year);
        Picasso.get().load(posterUrl).centerInside().fit().into(holder.posterView);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{
        ImageView posterView;
        TextView titleTextView;
        TextView yearTextView;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            posterView=itemView.findViewById(R.id.posterImageView);
            titleTextView=itemView.findViewById(R.id.titleTextView);
            yearTextView=itemView.findViewById(R.id.yearTextView);

        }
    }


}
