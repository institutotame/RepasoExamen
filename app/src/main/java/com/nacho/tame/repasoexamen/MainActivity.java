package com.nacho.tame.repasoexamen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Controller.ServerResponse {

    MoviesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Movies> movies = Movies.getMovies();
        RecyclerView recycler = findViewById(R.id.recyclerView);

        adapter = new MoviesAdapter(this, movies);
        recycler.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recycler.setLayoutManager(manager);

        Controller controller = new Controller(this);
        controller.start();
    }

    @Override
    public void onResponse(List<Movies> movies) {
        Toast.makeText(this, movies.get(0).getName(), Toast.LENGTH_LONG).show();
        adapter.setData(movies);
    }
}
