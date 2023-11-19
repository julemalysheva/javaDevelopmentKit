package lesson5;

import java.util.concurrent.Semaphore;

/**
 * В этом примере Semaphore используется для ограничения количества потоков,
 * которые могут одновременно выполнять определенную задачу. В данном случае,
 * создается Semaphore с 3 разрешениями, и каждый поток вызывает acquire() для получения
 * разрешения перед выполнением задачи и release() для освобождения разрешения после завершения.
 */

public class SemaphoreExample {
    private static Semaphore semaphore = new Semaphore(3);

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
                semaphore.acquire();
                System.out.println("Thread " + Thread.currentThread().getName() + " acquired a permit.");
                Thread.sleep(2000); // Выполняем задачу
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println("Thread " + Thread.currentThread().getName() + " released a permit.");
            }
        }
    }
}

/**
 * Thread Thread-2 acquired a permit.
 * Thread Thread-1 acquired a permit.
 * Thread Thread-0 acquired a permit.
 * Thread Thread-0 released a permit.
 * Thread Thread-2 released a permit.
 * Thread Thread-1 released a permit.
 */

/**
 * Semaphore один из примитивов синхронизации, позволяющий определить N
 * потоков, которым позволено исполнять критическую секцию кода. Когда создается
 * Semaphore, в конструктор передается количество разрешенных потоков (пропуск).
 * Представьте, что вам нужно реализовать приложение для контроля количества
 * свободных мест на парковке - если места на парковке закончились, то остальные
 * машины должны ждать пока место не освободится.
 * Когда один из потоков попадает в Semaphore - количество допустимых пропусков
 * уменьшается (при освобождении наоборот увеличивается). Вы можете в методе
 * захвата семафора (acquire()) указать, какое количество пропусков возьмет поток, а
 * в методе освобождения (release()) сколько будет возвращено (это количество не
 * может быть больше, чем захваченное количество пропусков).
 * Если передать в конструктор вторым параметром true, потоки, которые ожидают
 * получение пропуска (хотят войти в критическую секцию), выстраиваются в очередь
 * (вместо blocking set используется очередь по типу FIFO)
 */
