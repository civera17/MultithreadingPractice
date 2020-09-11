import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class T1{

    public T1() {
    }

    static class Counter {
        private long counter = 0;

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
        long totalIterations = 1_000_000_00;
        double correctness;
        long actual;
        Callable<Long> task;

        System.out.println("-----------------------------------------------");
        System.out.println("--T1 Running with " + threadCount +" threads---");
        System.out.println("-----------------------------------------------");

        task = () -> new T1().run(threadCount,totalIterations);
        actual = Chronometer.timed(task, totalIterations);

        correctness = ((double) actual / totalIterations) * 100.0;
        System.out.println("Correctness = " + correctness + "%");
    }

    public static void main(String[] args) {
        T1 t = new T1();
        T2 t2 = new T2();
        T3 t3 = new T3();
        T4 t4 = new T4();

        System.out.println("----------Increment without synchronization----------\n");
        t.run(1);
        t.run(2);
        t.run(4);
        t.run(8);
        t.run(100);
        System.out.println("\n\n");

        System.out.println("----------Increment with synchronization----------\n");
        t2.run(1);
        t2.run(2);
        t2.run(4);
        t2.run(8);
        t2.run(100);
        System.out.println("\n\n");

        System.out.println("----------Increment with volatile variable----------\n");
        t3.run(1);
        t3.run(2);
        t3.run(4);
        t3.run(8);
        t3.run(100);
        System.out.println("\n\n");

        System.out.println("----------Increment with AtomicLong----------\n");
        t4.run(1);
        t4.run(2);
        t4.run(4);
        t4.run(8);
        t4.run(100);
        System.out.println("\n\n");

    }
}
