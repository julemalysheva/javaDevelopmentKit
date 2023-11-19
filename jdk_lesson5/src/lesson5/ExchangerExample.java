package lesson5;

import java.util.concurrent.Exchanger;

/**
 * В этом примере Exchanger используется для обмена сообщениями между двумя потоками.
 * Первый поток отправляет сообщение в Exchange с помощью метода exchange() и блокируется
 * ожиданием второго потока. Когда второй поток вызывает exchange(), сообщения обоих потоков обмениваются.
 */

public class ExchangerExample {
    private static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task("Hello"));
        Thread thread2 = new Thread(new Task("World"));

        thread1.start();
        thread2.start();
    }

    static class Task implements Runnable {
        private String message;

        public Task(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " sent message: " + message);
                message = exchanger.exchange(message);
                System.out.println("Thread " + Thread.currentThread().getName() + " received message: " + message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * Thread Thread-0 sent message: Hello
 * Thread Thread-1 sent message: World
 * Thread Thread-1 received message: Hello
 * Thread Thread-0 received message: World
 */

/**
 * Exchanger — точка синхронизации, позволяющая двум потокам обмениваться
 * значениями. Представьте, что вы реализуете логистическое приложение — в рамках
 * него двум автомобилям нужно пересечься в одной точке для обмена грузами —
 * пока обмен не будет произведен, транспорт не может двинуться дальше по
 * маршруту.
 * При создании экземпляра Exchanger указывается тип объекта, которым будут
 * обмениваться потоки. Когда поток вызывает метод exchange(), а другой поток не
 * готов к обмену значениями, текущий поток переходит в состояние WAITING.
 * Отметим, что этот класс стоит использовать для обмена значениями между двумя
 * потоками. Не стоит использовать Exchanger для одного потока (также для ситуации
 * когда потоков больше чем 2) — такой поток будет в состоянии WAITING бесконечно
 * долго. Когда поток X подготовил значение, и метод exchange выполняет поток Y, то
 * поток Y после выполнения метода не блокируется. Также у класса есть
 * перегруженный метод exchange, который принимает время, которое поток будет
 * находится в состоянии WAITING — в этом случае если процесс обмена не
 * завершился, то генерируется проверяемое исключение TimeOutException.
 */