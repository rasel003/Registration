package com.rasel.registration;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("getusers")
    Call<AllUserResponse> getUserList();

}