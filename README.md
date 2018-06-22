# Prometheu4j

Prometheus4j is the Prometheus API Client for Java.
It's based on Prometheus API documented [here](https://prometheus.io/docs/prometheus/latest/querying/api/)

## Usage

```java
// query
PrometheusApiClient client = new PrometheusApiClient("http://localhost:9090/");
VectorResponse response = client.query("go_gc_duration_seconds");
System.out.println("response = " + response);

// range query
// use empty string or null to ommit optional parameters
MatrixResponse response = client.queryRange("go_gc_duration_seconds", tenMinEarlier.toString(), now.toString(), "5m", "");

// find series
KeyValResponse response = client.findSeries("up", tenMinEarlier.toString(), now.toString());

```

## Testing

Run a Prometheus instance on Docker with:
```jshelllanguage
docker run -p 9090:9090 --rm prom/prometheus:v2.3.1
```

Let it run for 10 min. Then start the tests in `PrometheusApiClientTest.java` file.

## License

This software is distributed under the MIT License.

