package lesson5.volatile_example;

public class IncrementRunnable implements Runnable {
    private Counter counter;

    public IncrementRunnable(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}
