package com.github.anhdat.models;

import java.util.List;
import java.util.Map;

public class VectorResponse {
    String status;
    VectorData data;

    static class VectorResult {
        Map<String, String> metric;
        List<Float> value;

        @Override
        public String toString() {
            return String.format(
                "metric: %s\nvalue: %s",
                metric.toString(),
                value == null ? "" : value.toString()
            );
        }
    }

    static class VectorData {
        String resultType;
        List<VectorResult> result;
    }
}
