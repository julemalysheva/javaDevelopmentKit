package lesson5;

public class Example02 {

    /**
     * Использовать подкласс Thread. Класс Thread сам имплементирует интерфейс
     * Runnable: обратите внимание его метод run не выполняет никакой работы
     * (необходимо переопределить поведение метода в наследнике). Можно
     * объявить подкласс Thread, предоставляя собственную реализацию метода
     * run. Данный способ больше подходит для “простых” приложений.
     */

    public static void main(String[] args) {
        //Мы всегда можем получить текущий поток выполнения
        System.out.println(Thread.currentThread().getName());
        ExampleThread exampleThread = new ExampleThread();
        exampleThread.start();
    }

    public static class ExampleThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Make some work!");
        }
    }
}

/**
 * Обратите внимание, что новый поток создается только если вызвать метод start,
 * который в свою очередь вызывает метод run - при попытке вызвать метод run
 * напрямую, код выполняется в том же потоке. Так же при запуске JVM, создается
 * главный поток с именем main и еще несколько служебных потоков
 */
