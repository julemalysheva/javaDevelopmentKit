package lesson5;

/**
 * Очередность выполнения потоков
 * Теперь давайте представим, что в рамках решения задачи нам необходимо
 * гарантировать, что поток не начнет свое выполнения пока не будет завершен
 * другой поток. Для этого используется метод join() экземпляра класса Thread — он
 * объединяет начало выполнения одного потока с завершением выполнения другого.
 * Если метод join() вызывается на одном из потоков, то текущий Thread
 * выполняющийся в этот момент блокируется до момента времени, пока поток, для
 * которого вызван метод join не закончит свое выполнение.
 * Метод join() может (не обязательно) принимать в качестве параметра количество
 * миллисекунд — количество времени ожидания. Если в качестве значения времени
 * ожидания указать 0, то такой поток будет «ждать вечно»
 */
public class ExampleJoin {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            try {
                Thread.sleep(10000);
                System.out.println("work done");
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        };
        Thread thread = new Thread(task);
        thread.start();
        thread.join();
        System.out.println("Finished");
    }
}
