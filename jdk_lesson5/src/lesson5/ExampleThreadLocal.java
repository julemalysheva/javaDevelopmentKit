package lesson5;

/**
 * Если в рамках реализации задачи, необходимо гарантировать, что каждый поток
 * будет работать со своей уникальной переменной — воспользуйтесь классом
 * ThreadLocal.
 * Класс ThreadLocal представляет хранилище тред-локальных переменных. По
 * способу использования он похож на обычную обертку над значением, с методами
 * get(), set() и remove() для доступа к нему, и дополнительным фабричным методом
 * ThreadLocal.withInitial(), устанавливающим значение по-умолчанию.
 * Отличие такой переменной от обычной в том, что ThreadLocal хранит отдельную
 * независимую копию значения для каждого ее использующего потока —
 * соответственно работа с такой переменной потокобезопасна.
 * Таким образом объект класса ThreadLocal хранит внутри не одно конкретное
 * значение, а хэш-таблицу (поток и соответствующее значение), и при использовании
 * обращается к значению для текущего потока.
 */
public class ExampleThreadLocal {
    private static Integer counter = 0;

    public static void main(String[] args) {
        new Thread(new ThreadTask()).start();
        new Thread(new ThreadTask()).start();

    }

    public static class ThreadTask implements Runnable {
        ThreadLocal<Integer> threadCounter = new ThreadLocal<>();

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                counter++;
                if (threadCounter.get() != null) {
                    threadCounter.set(threadCounter.get() + 1);
                } else {
                    threadCounter.set(0);
                }
            }
            System.out.println("Counter: " + counter);
            System.out.println("threadLocalCounter: " + threadCounter.get());
        }
    }
}
