import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class T3 {

    public T3() {
    }

    static class Counter {
        private volatile long counter = 0;

        public void increment() {
            counter++;
        }
        public long getCounter() {
            return counter;
        }
    }

    static class MyThread extends Thread {
        private final Counter counter;
        private final long iterations;

        MyThread(Counter counter, long iterations) {
            this.counter = counter;
            this.iterations = iterations;
        }

        @Override
        public void run() {
            for (int i = 0; i < iterations; i++) {
                counter.increment();
            }
        }
    }

    public long run(int threads, long TotalIterations) {
        List<Thread> threadList = new ArrayList<>();
        Counter sharedCounter = new Counter();
        long iterations = TotalIterations / threads;

        for (int i = 0; i < threads; i++) {
            threadList.add(new MyThread(sharedCounter,iterations));
        }

        for (Thread t: threadList) {
            t.start();
        }

        for (Thread t: threadList) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        System.out.println("Result = " + sharedCounter.getCounter());
//        System.out.println("Expected = " + iterations * threads);
        return sharedCounter.getCounter();
    }

    public void run(int threadCount) {
        long totalIterations = 1_000_000;
        double correctness;
        long actual;
        Callable<Long> task;

        System.out.println("-----------------------------------------------");
        System.out.println("--T3 Running with " + threadCount +" threads---");
        System.out.println("-----------------------------------------------");

        task = () -> new T3().run(threadCount,totalIterations);
        actual = Chronometer.timed(task, totalIterations);

        correctness = ((double) actual / totalIterations) * 100.0;
        System.out.println("Correctness = " + correctness + "%");
    }
}
