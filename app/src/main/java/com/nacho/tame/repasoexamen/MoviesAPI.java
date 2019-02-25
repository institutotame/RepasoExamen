package com.nacho.tame.repasoexamen;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesAPI {

    @GET("movies")
    Call<List<Movies>> loadMovies();


}
