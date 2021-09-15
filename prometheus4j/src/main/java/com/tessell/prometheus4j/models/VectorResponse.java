package com.tessell.prometheus4j.models;

import java.util.List;
import java.util.Map;

public class VectorResponse {
    private String status;
    private VectorData data;

    public static class VectorResult {
        private Map<String, String> metric;
        private List<Float> value;

        public Map<String, String> getMetric() {
            return metric;
        }

        public void setMetric(Map<String, String> metric) {
            this.metric = metric;
        }

        public List<Float> getValue() {
            return value;
        }

        public void setValue(List<Float> value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format(
                "metric: %s\nvalue: %s",
                metric.toString(),
                value == null ? "" : value.toString()
            );
        }
    }

    public static class VectorData {
        private String resultType;
        private List<VectorResult> result;

        public String getResultType() {
            return resultType;
        }

        public void setResultType(String resultType) {
            this.resultType = resultType;
        }

        public List<VectorResult> getResult() {
            return result;
        }

        public void setResult(List<VectorResult> result) {
            this.result = result;
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public VectorData getData() {
        return data;
    }

    public void setData(VectorData data) {
        this.data = data;
    }
}
