package org.sample;

import org.openjdk.jmh.annotations.*;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/*
 * ============================== HOW TO RUN THIS TEST: ====================================
 *
 * You can run this test via the command line:
 *    $ mvn clean install
 *    $ java -jar target/benchmarks.jar -wi 10 -i 10 -f 4
 *    (we requested 5 warmup/measurement iterations, single fork)
 */
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Thread)
public class
IntegerToStringBenchmark {

	int intValue;
	
	@Setup(Level.Iteration)
	public void prepare() {
		intValue = ThreadLocalRandom.current().nextInt();
	}
	
    @Benchmark
    public String testStringConcat() {
        return "" + intValue;
    }
    
    @Benchmark
    public String testIntegerToString() {
		return Integer.toString(intValue);
    }

    @Benchmark
    public String testIntWrapperToString() {
        return Integer.valueOf(intValue).toString();
    }

}
