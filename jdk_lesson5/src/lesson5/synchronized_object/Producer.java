package lesson5.synchronized_object;

public class Producer implements Runnable {
    private MessageStorage storage;
    private String message;

    public Producer(MessageStorage storage, String message) {
        this.storage = storage;
        this.message = message;
    }

    @Override
    public void run() {
        while (true) {
            storage.setMessage(message);
        }
    }
}