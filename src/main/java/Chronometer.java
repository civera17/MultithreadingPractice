import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.concurrent.*;

public class Chronometer {

    Chronometer() {
    }

    public static <R> R timed(Callable<R> task){
        R result;
        long start = System.currentTimeMillis();
        try {
            result = task.call();
        } catch (Exception e) {
            result = null;
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        printCalculations(start,end,1);
        return result;
    }

    public static void timed(Runnable task) {
        long start = System.currentTimeMillis();
        task.run();
        long end = System.currentTimeMillis();
        printCalculations(start,end,1);
    }


    public static void timed(Runnable task, long declaredIterations) {
        long start = System.currentTimeMillis();
        task.run();
        long end = System.currentTimeMillis();
        printCalculations(start,end,declaredIterations);
    }

    public static <R> R timed(Callable<R> task, long declaredIterations){
        R result;
        long start = System.currentTimeMillis();
        try {
            result = task.call();
        } catch (Exception e) {
            result = null;
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        printCalculations(start,end,declaredIterations);
        return result;
    }

    public static void printCalculations(long start, long end, long iterations){
        double timeElapsed = (end - start) / 1000.0;
        double eRate = iterations / timeElapsed;
        System.out.println("Time = " + timeElapsed + "s");
        System.out.println("Iterations = " + iterations);
        System.out.println("Execution rate = " + String.format(" %,1.2f t/s", eRate));
    }

}
