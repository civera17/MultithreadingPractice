import java.util.Random;
import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) throws Exception {
        MyRunnable myRunnable = new MyRunnable();
        Chronometer.timed(myRunnable,10);
    }
}
