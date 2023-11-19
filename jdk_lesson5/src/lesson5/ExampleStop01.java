package lesson5;
//Остановка потока

public class ExampleStop01 {
    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        };
        Thread thread = new Thread(task);
        thread.start();
        thread.interrupt();
    }
}

/**
 * Если поток ожидает выполнения прерываемого метода блокирования
 * (Thread.sleep(), Thread.join() или Object.wait()), то процесс ожидание
 * прерывается и выбрасывает InterruptedException — после этого флаг
 * interrupted устанавливается в значение false.
 */
