# How To Run
You can run this test via the command line:

$ mvn clean install

$ java -jar target/benchmarks.jar -wi 10 -i 10 -f 4

(we requested 10 warmup/measurement iterations, 4 forks)

# Results

| Benchmark                            | Mode | Cnt |  Score | Error | Units|
|--------------------------------------|------|-----|--------|-------|------|
| Integer.valueOf(intValue).toString() | avgt |  40 | 37,488 |±0,596 | ns/op|
| Integer.toString(intValue)           | avgt |  40 | 34,380 |±0,786 | ns/op|
| "" + intValue                        | avgt |  40 | 28,788 |±0,782 | ns/op|
