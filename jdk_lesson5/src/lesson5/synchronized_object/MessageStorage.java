package lesson5.synchronized_object;

public class MessageStorage {
    private String message;

    public synchronized void setMessage(String message) {
        while (this.message != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.message = message;
        System.out.println("Message stored: " + message);
        notifyAll();
    }

    public synchronized String getMessage() {
        while (message == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String temp = message;
        message = null;
        System.out.println("Message retrieved: " + temp);
        notifyAll();
        return temp;
    }
}
