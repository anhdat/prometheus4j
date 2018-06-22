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

    @GET("api/v1/query_range")
    Call<PrometheusResponse> queryRange(
        @Query("query") String query,
        @Query("start") String start,
        @Query("end") String end,
        @Query("step") String step,
        @Query("timeout") String timeout
    );
}
