import java.util.ArrayList;
import java.util.Random;

public class MyRunnable implements Runnable{


    @Override
    public void run() {
        int count = 0;
        try {
            for (int i = 0; i < 1000000; i++) {
                count++;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
