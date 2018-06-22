package com.github.anhdat;

import com.github.anhdat.models.PrometheusResponse;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class PrometheusApiClientTest {
    private PrometheusApiClient client;
    Long now;
    Long tenMinEarlier;

    @Before
    public void initTest() {
        client = new PrometheusApiClient("http://localhost:9090/");
        now = System.currentTimeMillis() / 1000;
        tenMinEarlier = now - 10 * 60;
    }

    @Test
    public void testQuery() throws IOException {
        PrometheusResponse response = client.query("go_gc_duration_seconds");
        System.out.println("response = " + response);
    }

    @Test
    public void testQueryWithTime() throws IOException {
        PrometheusResponse response = client.query("go_gc_duration_seconds", "2018-06-01T20:10:51.781Z");
        System.out.println("response = " + response);
    }

    @Test
    public void testQueryWithTimeout() throws IOException {
        PrometheusResponse response = client.query("go_gc_duration_seconds", "", "1ms");
        System.out.println("response = " + response);
    }

    @Test
    public void testQueryRange() throws IOException {
        PrometheusResponse response = client.queryRange("go_gc_duration_seconds", tenMinEarlier.toString(), now.toString(), "5m", "");
        System.out.println("response = " + response);
    }
}