package lesson5;

/**
 * Deadlock или взаимная блокировка
 * — это ошибка, которая происходит когда threads
 * имеют циклическую зависимость от пары
 * синхронизированных объектов.
 *
 *  Пусть
 * один thread входит в монитор объекта A, а другой — объекта B. Если thread в
 * объекте A пытается вызвать любой синхронизированный метод объекта B, а объект
 * B в то же самое время пытается вызвать любой синхронизированный метод объекта
 * A, то потоки будут заблокированы в процессе ожидания “навечно”.
 */
public class ExampleDeadlock {
    public static void main(String[] args) {
        ObjectToLock objectToLockOne = new ObjectToLock();
        ObjectToLock objectToLockTwo = new ObjectToLock();
        getThread(objectToLockTwo, objectToLockOne);
        getThread(objectToLockOne, objectToLockTwo);
    }

    private static void getThread(ObjectToLock objectToLockOne, ObjectToLock objectToLockTwo) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e)  {
                    e.printStackTrace();
                }
                objectToLockTwo.stepOne(objectToLockOne);
            }
        }).start();
    }

    static class ObjectToLock {
        public synchronized void stepOne(ObjectToLock object) {
            System.out.println("stepOne: " + Thread.currentThread().getName());
            object.stepTwo(this);
        }

        public synchronized void stepTwo(ObjectToLock object) {
            System.out.println("stepTwo: " + Thread.currentThread().getName());
            object.toString();
        }
    }

}

/**
 * run: Thread-1
 * run: Thread-0
 * stepOne: Thread-1
 * stepTwo: Thread-1
 * stepOne: Thread-0
 * stepTwo: Thread-0
 *
 * но иногда блокируются
 * run: Thread-1
 * run: Thread-0
 * stepOne: Thread-1
 * stepOne: Thread-0
 */
