package com.example.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.Model.Post;
import com.example.Model.User;
import com.example.api.GithubService;
import com.example.api.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private ArrayList<User> userArrayList = new ArrayList<>();
    public MutableLiveData<List<User>> mutableLiveData = new MutableLiveData<>();
    private ArrayList<Post> PostArrayList = new ArrayList<>();
    public MutableLiveData<List<Post>> mutableLiveDataPost = new MutableLiveData<>();
    GithubService apiInterface;
    private Application application;
    public UserRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Post>> getPost() {
        apiInterface = RestClient.getClient().create(GithubService.class);
        Call<List<Post>> call = apiInterface.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.body() != null) {
                    PostArrayList = (ArrayList<Post>) response.body();
                    mutableLiveDataPost.setValue(PostArrayList);

                }
            }
            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
            }
        });
        return mutableLiveDataPost;
    }



    public MutableLiveData<List<User>> getUsers() {
        apiInterface = RestClient.getClient().create(GithubService.class);
        Call<List<User>> call = apiInterface.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.body() != null) {
                    userArrayList = (ArrayList<User>) response.body();

                    mutableLiveData.setValue(userArrayList);

                }
            }
            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
            }
        });
        return mutableLiveData;
    }

}
