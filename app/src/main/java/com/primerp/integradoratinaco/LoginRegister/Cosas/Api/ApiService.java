package com.primerp.integradoratinaco.LoginRegister.Cosas.Api;

import com.primerp.integradoratinaco.LoginRegister.Cosas.Responst.RegisterRequest;
import com.primerp.integradoratinaco.LoginRegister.Cosas.Responst.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("register")
    Call<RegisterResponse> registerUser(@Body RegisterRequest registerRequest);
}
