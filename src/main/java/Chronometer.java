import java.util.concurrent.Callable;

public class Chronometer{


    public static  <R> R timed(Callable<R> task) {
        return null;
    }


    public static void timed(Runnable task) {
        Thread myThread = new Thread(task);
        System.currentTimeMillis();
        myThread.start();
        try {
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.currentTimeMillis();
    }


    public static void timed(Runnable task, long declaredIterations) {

    }

    public static <R> R timed(Callable<R> task, long declaredIterations) {
        return null;
    }
}
