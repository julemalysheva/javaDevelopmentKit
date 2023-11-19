package lesson5.synchronized_object;

public class Consumer implements Runnable {
    private MessageStorage storage;

    public Consumer(MessageStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        while (true) {
            String message = storage.getMessage();
            // Обработка сообщения
        }
    }
}
