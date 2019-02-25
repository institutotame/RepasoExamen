package com.nacho.tame.repasoexamen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {

    List<Movies> movies;
    LayoutInflater inflater;
    Context context;

    public MoviesAdapter(Context context, List<Movies> movies){
        this.movies = movies;
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MoviesViewHolder(inflater.inflate(R.layout.movies_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder vh, int i) {
        Movies movie = movies.get(i);
        vh.txtName.setText(movie.getName());
        GlideApp.with(context)
                .load(movie.getThumbnail())
                .into(vh.imgThumbnail);
    }

    @Override
    public int getItemCount() {
        if(movies==null){
            return 0;
        }
        return movies.size();
    }

    public class MoviesViewHolder extends RecyclerView.ViewHolder {

        TextView txtName;
        ImageView imgThumbnail;

        public MoviesViewHolder(View view){
            super(view);
            txtName = view.findViewById(R.id.txtName);
            imgThumbnail = view.findViewById(R.id.imgThumbnail);

            txtName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Movies movie = movies.get(getAdapterPosition());
                    Toast.makeText(
                            context,
                            movie.getName(),
                            Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    public void setData(List<Movies> newList){
        movies = newList;
        notifyDataSetChanged();
    }

}
