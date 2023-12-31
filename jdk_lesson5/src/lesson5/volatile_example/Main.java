package lesson5.volatile_example;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread thread1 = new Thread(new IncrementRunnable(counter));
        Thread thread2 = new Thread(new IncrementRunnable(counter));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count: " + counter.getCount());
        //вывод где-то 2000, где-то 1974, 1945 и пр.
    }
}

/**
 * В этом примере класс Counter содержит переменную count, которая помечена ключевым словом volatile.
 * Класс IncrementRunnable реализует интерфейс Runnable и инкрементирует значение count в объекте Counter в цикле.
 * В методе main() создаются два потока, которые запускаются и инкрементируют count в объекте Counter.
 * Затем главный поток (метод main()) вызывает join() для ожидания завершения двух потоков.
 * После завершения потоков выводится значение count из объекта Counter.
 * Благодаря использованию ключевого слова volatile, все потоки будут работать с актуальным значением count и
 * сделанные инкременты будут отражены в финальном результате.
 * Применение ключевого слова volatile в данном случае обеспечивает видимость последних изменений переменной
 * count между потоками без использования блокировок или синхронизации. Это позволяет безопасно обновлять
 * общую переменную из нескольких потоков.
 */
/**
 * Применение ключевого слова volatile особенно полезно в многопоточной среде, когда необходимо обеспечить
 * видимость последних изменений переменной между потоками без использования блокировок. Важно отметить,
 * что volatile не обеспечивает атомарность операций чтения и записи, поэтому, если важно обеспечить атомарность,
 * следует рассмотреть использование блокировок или атомарных классов из пакета java.util.concurrent.atomic.
 */
