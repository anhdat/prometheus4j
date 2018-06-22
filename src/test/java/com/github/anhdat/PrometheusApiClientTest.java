package com.github.anhdat;

import com.github.anhdat.models.PrometheusResponse;
import org.junit.Test;

import java.io.IOException;

public class PrometheusApiClientTest {
    @Test
    public void testQuery() throws IOException {
        PrometheusApiClient client = new PrometheusApiClient("http://localhost:9090/");
        PrometheusResponse response = client.query("go_gc_duration_seconds");
        System.out.println("response = " + response);
    }
}