package com.github.anhdat;

import com.github.anhdat.models.KeyValResponse;
import com.github.anhdat.models.MatrixResponse;
import com.github.anhdat.models.PrometheusResponse;
import com.github.anhdat.models.VectorResponse;
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

    public VectorResponse query(String query) throws IOException {
        return service.query(query, null, null).execute().body();
    }

    public VectorResponse query(String query, String time) throws IOException {
        return service.query(query, time, null).execute().body();
    }

    public VectorResponse query(String query, String time, String timeout) throws IOException {
        return service.query(query, time, timeout).execute().body();
    }

    public MatrixResponse queryRange(String query, String start, String end, String step, String timeout) throws IOException {
        return service.queryRange(query, start, end, step, timeout).execute().body();
    }

    public KeyValResponse findSeries(String match, String start, String end) throws IOException {
        return service.findSeries(match, start, end).execute().body();
    }

}
