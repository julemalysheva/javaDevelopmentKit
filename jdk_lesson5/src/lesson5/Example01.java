package lesson5;

//Создание и запуск потока
//Создать класс и имплементировать интерфейс Runnable
public class Example01 {

    /**
     * Нам необходимо
     * реализовать единственный метод run при имплиминтации интерфейса
     * Runnable, который должен содержать код, выполняющийся в потоке. Объект
     * Runnable передается конструктору класса Thread. Этот способ считается
     * наиболее гибким и применяется для высокоуровневых API управления
     * потоками.
     */

    public static void main(String[] args) {
        //Мы всегда можем получить текущий поток выполнения
        System.out.println(Thread.currentThread().getName());
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println("Make some work!");
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }
}
