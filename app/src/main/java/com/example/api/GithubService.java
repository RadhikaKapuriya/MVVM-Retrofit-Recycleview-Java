package com.example.api;


import com.example.Model.Post;
import com.example.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface GithubService {


    @GET("users")
    Call<List<User>> getUsers();

    @GET("posts")
    Call<List<Post>> getPosts();



}
