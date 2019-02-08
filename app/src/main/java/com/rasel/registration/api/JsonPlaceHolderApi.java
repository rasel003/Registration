package com.rasel.registration.api;

import com.rasel.registration.model.AllUserResponse;
import com.rasel.registration.model.ApiProfileRequest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {

    @GET("getusers")
    Call<AllUserResponse> getUserList();

    @POST("GetUserBy")
    Call<ResponseBody> getProfileInformation(@Body ApiProfileRequest body);



}