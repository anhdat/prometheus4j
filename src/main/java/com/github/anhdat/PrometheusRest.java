package com.github.anhdat;

import com.github.anhdat.models.PrometheusResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PrometheusRest {
    @GET("api/v1/query")
    Call<PrometheusResponse> query(
        @Query("query") String query,
        @Query("time") String time,
        @Query("timeout") String timeout
    );
}
