import java.util.concurrent.Callable;

public interface Chronoface {
    public <R> R timed(Callable<R> task);

    public void timed(Runnable task);

    public void timed(Runnable task, long declaredIterations);

    public <R> R timed(Callable<R> task, long declaredIterations);
}
