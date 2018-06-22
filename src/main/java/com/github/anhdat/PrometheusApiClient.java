package com.github.anhdat;

import com.github.anhdat.models.PrometheusResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class PrometheusApiClient {
    public String baseUrl;

    private Retrofit retrofit;
    private PrometheusRest service;

    public PrometheusApiClient(String baseUrl) {
        this.baseUrl = baseUrl;

        this.retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        service = retrofit.create(PrometheusRest.class);
    }

    public PrometheusResponse query(String query) throws IOException {
        return service.query(query).execute().body();
    }

}
