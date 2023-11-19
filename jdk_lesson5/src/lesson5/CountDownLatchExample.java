package lesson5;

import java.util.concurrent.CountDownLatch;

/**
 * В этом примере CountDownLatch используется для ожидания завершения нескольких задач.
 * Создается CountDownLatch с инициальным значение 3 (количество задач).
 * Каждая задача вызывает countDown(), чтобы уменьшить значение счетчика, и главный поток вызывает await(),
 * чтобы ожидать, пока все задачи не завершатся.
 */

public class CountDownLatchExample {
    private static CountDownLatch latch = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Task());
        Thread thread2 = new Thread(new Task());
        Thread thread3 = new Thread(new Task());

        thread1.start();
        thread2.start();
        thread3.start();

        latch.await();

        System.out.println("All tasks completed.");
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println("Task executed by " + Thread.currentThread().getName());
            latch.countDown();
        }
    }
}

/**
 * Task executed by Thread-2
 * Task executed by Thread-0
 * Task executed by Thread-1
 * All tasks completed.
 */

/**
 * CowntDownLatch — это счетчик значение которого уменьшается каждый раз, когда
 * поток использует счетчик (поток при этом блокируется). Когда значение счетчика
 * будет равно нулю, все заблокированные потоки будут одновременно запущены.
 * Представьте, что вы реализуете механизм старта начала автогонок — вам нужно
 * гарантировать, что все машины встали у старта прежде чем разрешить движение.
 * Для уменьшения числа в счетчике вызывается метод countDown(). После
 * вызова этого метода поток продолжает свое выполнение.
 * Метод await() используют для блокировки потока.
 */
