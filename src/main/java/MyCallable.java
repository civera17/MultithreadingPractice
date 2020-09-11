import java.util.concurrent.Callable;

public class MyCallable implements Callable<Long> {
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Long call(){
        return new T4().run(4, 1000000);
    }
}
