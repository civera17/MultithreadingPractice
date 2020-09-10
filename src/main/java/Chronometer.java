import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.concurrent.*;

public class Chronometer {


    public static <R> R timed(Callable<R> task) throws Exception {
        for (int i = 0; i < 10; i++) {
            task.call();
            System.out.println(task.call());
        }
        return null;
    }


    public static void timed(Runnable task) {
        double start = System.currentTimeMillis();
        int it = 0;
        Thread[] t = new Thread[40000];
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(task);
            t[i].start();
            it++;
            try {
                t[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        for (int i = 0; i < 1000; i++) {
//            Thread myThread = new Thread(task);
//            System.out.println("Thread " + myThread.getId() + " starting...");
//            myThread.start();
//            it++;
//            try {
//                myThread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        double end = System.currentTimeMillis();
        double eRate =  it / (end - start);
        double timeElapsed = (end - start) / 1000.0;
        System.out.println("Time = " + timeElapsed + "s");
        System.out.println("Iterations = " + it);
        System.out.println("Execution rate = " + eRate + " t/s");
    }


    public static void timed(Runnable task, long declaredIterations) {
        double start = System.currentTimeMillis();
        int it = 0;
        int correctness;
        Thread[] t = new Thread[(int) declaredIterations];
        for (int i = 0; i < declaredIterations; i++) {
            t[i] = new Thread(task);
            t[i].start();
            it++;
            try {
                t[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        double end = System.currentTimeMillis();
        double eRate =  it / (end - start);
        double timeElapsed = (end - start) / 1000.0;
        System.out.println("Time = " + timeElapsed + "s");
        System.out.println("Iterations = " + it);
        System.out.println("Execution rate = " + eRate + " t/s");
    }

    public static <R> R timed(Callable<R> task, long declaredIterations) throws Exception {
        for (int i = 0; i < declaredIterations; i++) {
            task.call();
            System.out.println(task.call());
        }
        return null;
    }
}
