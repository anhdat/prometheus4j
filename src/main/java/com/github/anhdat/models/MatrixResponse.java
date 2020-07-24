package com.github.anhdat.models;

import java.util.List;
import java.util.Map;

public class MatrixResponse {
    String status;
    MatrixData data;

    static class MatrixData {
        String resultType;
        List<MatrixResult> result;
    }

    static class MatrixResult {
        Map<String, String> metric;
        List<List<Float>> values;

        @Override
        public String toString() {
            return String.format(
                "metric: %s\nvalues: %s",
                metric.toString(),
                values == null ? "" : values.toString()
            );
        }
    }
}
