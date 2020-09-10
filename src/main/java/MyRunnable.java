import java.util.ArrayList;
import java.util.Random;

public class MyRunnable implements Runnable{
    public int count = 0;

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                count++;
            }
            System.out.println("Current correctness: " + count + "%");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
