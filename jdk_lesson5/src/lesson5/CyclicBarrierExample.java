package lesson5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * В этом примере CyclicBarrier используется для согласования множества потоков на паузе до тех пор,
 * пока не будут достигнуты все точки барьера. Когда каждый поток достигает точки барьера, он вызывает await(),
 * и только когда все потоки достигают барьера, выполняется действие BarrierAction, которое задает,
 * что должно произойти после достижения барьера.
 */

public class CyclicBarrierExample {
    private static final int NUM_THREADS = 3;
    private static CyclicBarrier barrier = new CyclicBarrier(NUM_THREADS, new BarrierAction());

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task());
        Thread thread2 = new Thread(new Task());
        Thread thread3 = new Thread(new Task());

        thread1.start();
        thread2.start();
        thread3.start();
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " starts.");
                Thread.sleep(2000); // Выполняем задачу
                barrier.await();
                System.out.println("Thread " + Thread.currentThread().getName() + " continues execution.");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    static class BarrierAction implements Runnable {
        @Override
        public void run() {
            System.out.println("Barrier reached. Executed by " + Thread.currentThread().getName());
        }
    }
}

/**
 * Thread Thread-2 starts.
 * Thread Thread-1 starts.
 * Thread Thread-0 starts.
 * Barrier reached. Executed by Thread-0
 * Thread Thread-0 continues execution.
 * Thread Thread-2 continues execution.
 * Thread Thread-1 continues execution.
 */

/**
 * CyclicBarrier работает аналогично CountDownLatch, но есть несколько отличий:
 * вместо методов countDown() и await() используется один метод await(), после
 * вызова которого поток блокируется (если число не равно нулю);
 * класс CyclicBarrier можно использовать повторно. Как только значение
 * счетчика становится равным нулю, оно восстанавливается, и объект класса
 * можно использовать заново;
 * как только значение счетчика стало равным нулю, у вас есть возможность
 * выполнить дополнительный метод имплементирующий интерфейс runnable,
 * который может быть передан в конструктор CyclicBarrier.
 * В качестве примера можно привести приложение для паромной переправы — пока
 * паром не будет заполнен машины на 100% он не должен начинать движение.
 */
