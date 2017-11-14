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


    @Param({"0.0", "0.01", "0.5", "0.99"})
    double nullProbability;

    int intValue;
    Integer intValueWrapped;
    Integer intValueWrappedNotNull;

    @Setup(Level.Invocation)
    public void prepare() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        intValue = random.nextInt();
        if (random.nextDouble() < nullProbability) {
            intValueWrapped = null;
        } else {
            intValueWrapped = intValue;
        }
        intValueWrappedNotNull=intValue;
    }

    @Benchmark
    public String testStringConcat() {
        return "" + intValue;
    }

    @Benchmark
    public String testStringConcatWrapped() {
        return "" + intValueWrapped;
    }
    @Benchmark
    public String testStringConcatWrappedNotNull() {
        return "" + intValueWrappedNotNull;
    }

    /*@Benchmark
    public String testIntegerToString() {
        return Integer.toString(intValue);
    }

    @Benchmark
    public String testIntWrapperToString() {
        return Integer.valueOf(intValue).toString();
    }*/

    @Benchmark
    public String stringValueOfPrimitive() {
        return String.valueOf(intValue);
    }

    @Benchmark
    public String stringValueOfWrapped() {
        return String.valueOf(intValueWrapped);
    }

    @Benchmark
    public String stringValueOfWrappedNotNull() {
        return String.valueOf(intValueWrappedNotNull);
    }


}
