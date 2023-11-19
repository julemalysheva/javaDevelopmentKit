package lesson5;
//Остановка потока
public class ExampleStop02 {
    public static void main(String[] args) {
        Runnable task = () -> {
            while (!Thread.currentThread().isInterrupted()) {

            }
            System.out.println("Finished");
        };
        Thread thread = new Thread(task);
        thread.start();
        thread.interrupt();
    }
}

/**
 * Если поток не ожидает выполнения прерываемого метода блокирования,
 * флаг interrupted устанавливается в значение true — теперь код потока должен
 * обработать переменную в реализации метода run
 */
