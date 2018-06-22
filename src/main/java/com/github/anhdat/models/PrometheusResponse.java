package com.github.anhdat.models;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author dat.truonganh
 */
public class PrometheusResponse {
    String status;
    Data data;

    @Override
    public String toString() {
        return "status: " + status + "\ndata: " + data;
    }

    class ResultItem {
        Map<String, String> metric;
        List<Float> value;
        List<List<Float>> values;

        @Override
        public String toString() {
            return String.format(
                "metric: %s\nvalue: %s\nvalues: %s",
                metric.toString(),
                value == null ? "" : value.toString(),
                values == null ? "" : values.toString()
            );
        }
    }

    class Data {
        String resultType;
        List<ResultItem> result;

        @Override
        public String toString() {
            String resultString = result.stream().map(ResultItem::toString).collect(Collectors.joining("\n"));
            return String.format("type: %s, has %d items: \n%s", resultType, result.size(), resultString);
        }
    }
}

