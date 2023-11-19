package lesson5.synchronized_object;

public class Main {
    public static void main(String[] args) {
        MessageStorage storage = new MessageStorage();

        Thread producerThread = new Thread(new Producer(storage, "Hello, World!"));
        Thread consumerThread = new Thread(new Consumer(storage));

        producerThread.start();
        consumerThread.start();
    }
}
