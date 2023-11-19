package homework;

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
     * Блокирует вилку перед ее использованием.
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
