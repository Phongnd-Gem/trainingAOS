package com.example.mycore.modules.net;

import com.example.mycore.models.UserProfile;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubAPI {
    @GET("users/{name}")
    Call<UserProfile> getInfo(@Path("name") String name);
}
