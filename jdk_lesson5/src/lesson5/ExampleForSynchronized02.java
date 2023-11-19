package lesson5;
//Во вторых, можно синхронизировать другой объект в целевом классе:
public class ExampleForSynchronized02 {
    public static void main(String[] args) throws InterruptedException {
        Object objectToLock = new Object();

        Runnable task = () -> {
            synchronized (objectToLock) {
                System.out.println(Thread.currentThread().getName());
            }
        };

        Thread thread = new Thread(task);
        thread.start();
        //Если необходимо, что task выолнился раньше используем метод
        // join()
        //thread.join();
        synchronized (objectToLock) {
            for (int i = 0; i < 10; i++) {
                Thread.currentThread().sleep(1000);
                System.out.println("step" + i);
            }
            System.out.println(Thread.currentThread().getName());
        }
    }

}

/**
 * step0
 * step1
 * step2
 * step3
 * step4
 * step5
 * step6
 * step7
 * step8
 * step9
 * main
 * Thread-0
 */

/** когда thread.join();
 * Thread-0
 * step0
 * step1
 * step2
 * step3
 * step4
 * step5
 * step6
 * step7
 * step8
 * step9
 * main
 */