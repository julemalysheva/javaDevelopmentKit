package homework;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Класс Fork реализует объект вилки, а блокировка осуществляется с помощью ReentrantLock.
 */
public class Fork {
    /**
     * Объект типа Lock (здесь ReentrantLock) для реализации блокировок.
     */
    private final Lock lock = new ReentrantLock();

    /**
     * Попытка взять вилку.
     * Если вилку удалось захватить, метод возвращает true.
     * Если вилку не удалось захватить в течение указанного времени, метод возвращает false.
     * @return true, если вилку удалось захватить; false, если вилку не удалось захватить.
     * @throws InterruptedException если поток был прерван во время ожидания захвата вилки.
     */
    public boolean tryPickUp() throws InterruptedException {
        return lock.tryLock(100, TimeUnit.MILLISECONDS);
    }

    /**
     * Блокирует вилку перед ее использованием. (Не используется сейчас)
     * @throws InterruptedException если поток был прерван при ожидании блокировки.
     */
    public void pickUp() throws InterruptedException {
        lock.lock();
    }

    /**
     * Разблокирует вилку после завершения.
     */
    public void putDown() {
        lock.unlock();
    }
}
