import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    public int count = 0;
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 10; i++) {
            count++;
        }
        return count;
    }
}
