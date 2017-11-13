#How To Run
You can run this test via the command line:

$ mvn clean install

$ java -jar target/benchmarks.jar -wi 5 -i 5 -f 1

(we requested 5 warmup/measurement iterations, single fork)

#Results
`Benchmark                                        Mode  Cnt   Score    Error  Units`

`IntegerToStringBenchmark.testIntWrapperToString  avgt    5  58.987 ± 12.844  ns/op`

`IntegerToStringBenchmark.testIntegerToString     avgt    5  54.676 ±  4.329  ns/op`

`IntegerToStringBenchmark.testStringConcat        avgt    5  49.782 ±  8.725  ns/op`
