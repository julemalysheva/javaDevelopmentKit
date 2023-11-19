package lesson5;
//Остановка потока
public class ExampleStop03 {
    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                Thread.currentThread().sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(task);
        thread.start();
        System.out.println("you here");
    }
}

/**
 * Также любой поток может остановиться сам — для этого необходимо вызвать static
 * метод Thread.sleep() (самый простой способ взаимодействия с другими потоками). В
 * операционной системе, с установленной JVM, имеется свой планировщик потоков,
 * называемый Thread Scheduler. Данный планировщик принимает решение, какой
 * поток и когда необходимо запускать. Метод Thread.sleep() может принимать в
 * качестве параметра количество миллисекунд — время на которое поток попытается
 * заснуть, возобновлением выполнения — обратите внимание, что абсолютная
 * точность не гарантирована.
 */