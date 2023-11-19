package lesson5;

import java.util.concurrent.locks.ReentrantLock;

/**
 * В этом примере ReentrantLock используется для захвата и освобождения блокировки.
 * Когда поток вызывает lock(), он захватывает блокировку, выполняет задачу и затем вызывает unlock(),
 * чтобы освободить блокировку.
 */

public class ReentrantLockExample {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task());
        Thread thread2 = new Thread(new Task());

        thread1.start();
        thread2.start();
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " acquired the lock.");
                Thread.sleep(2000); // Выполняем задачу
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("Thread " + Thread.currentThread().getName() + " released the lock.");
            }
        }
    }
}

/**
 * Thread Thread-1 acquired the lock.
 * Thread Thread-0 acquired the lock.
 * Thread Thread-1 released the lock.
 * Thread Thread-0 released the lock.
 */

/**
 *  Давайте рассмотрим базовый интерфейс
 * Lock:
 * void lock() — захват блокировки (если доступна). Если блокировка занята
 * другим потоком, текущий поток, который выполняет этот код, переходит в
 * статус BLOCKED;
 * void lockInterruptibly() — аналог lock(), но позволяет прервать блокированный
 * поток и восстановить выполнение через InterruptedException;
 * boolean tryLock() — неблокирующий вариант метода lock(). Если удалось
 * получить блокировку, то метод возвращает true;
 * boolean tryLock(long timeout, TimeUnit timeUnit) — то же, что tryLock(), за
 * исключением того, что метод ждет определенное время, перед тем
 * остановить попытку получения блокировки;
 * void unlock() — отпускает блокировку.
 * Сегодня мы рассмотрим одну из реализаций интерфейса Lock — ReentrantLock. Он
 * позволяет одному и тому же потоку вызывать метод lock, даже если он его вызывал
 * ранее, без освобождения блокировки.
 * У класса ReentrantLock, кроме методов интерфейса Lock, есть фабричный метод
 * newCondition(). Этот метод возвращает объект Condition, который позволяет
 * добавить текущий поток в wait set данного объекта Condition. Это дает возможность
 * организовывать разные условия ожидания по одной и той же блокировке, чего не
 * позволяют ключевое слово synchronized и связки методов wait()/notify(). Для того
 * чтоб объект попал в wait set для данного Condition объекта, нужно вызвать метод
 * await(). Чтобы разбудить поток или потоки, которые есть в wait set, необходимо
 * вызвать методы signal() или signalAll(). Эти методы аналогичны методам wait(),
 * notify() и notifyAll() у объекта Object (методы wait(), notify() и notifyAll() в объекте
 * Object — final, методам для объекта Condition придумали другие наименования).
 */