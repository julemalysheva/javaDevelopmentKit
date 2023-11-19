package homework;

/**
 * Класс Philosopher представляет философа, который может размышлять и есть при помощи вилок.
 * Каждый философ представлен в виде отдельного потока.
 * У философа есть идентификатор, левая и правая вилки, а также определенное количество приемов пищи.
 */

public class Philosopher implements Runnable {
    private final int id;
    private final Fork leftFork;
    private final Fork rightFork;
    private final int numEats;

    /**
     * Конструктор класса Philosopher
     *
     * @param id          Идентификатор философа
     * @param leftFork    Левая вилка
     * @param rightFork   Правая вилка
     * @param numEats     Количество приемов пищи философом
     */
    public Philosopher(int id, Fork leftFork, Fork rightFork, int numEats) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.numEats = numEats;
    }

    /**
     * Метод представляет действие философа в процессе размышления
     *
     * @throws InterruptedException если поток был прерван во время размышления
     */
    private void think() throws InterruptedException {
        System.out.println("Философ " + id + " размышляет");
        Thread.sleep(1000); // имитация размышлений
    }

    /**
     * Метод представляет действие философа в процессе приема пищи
     *
     * @throws InterruptedException если поток был прерван во время приема пищи
     */
    private void eat() throws InterruptedException {
        System.out.println("Философ " + id + " обедает");
        Thread.sleep(1000); // имитация приема пищи
    }

    /**
     * Попытка взять обе вилки.
     * Если вилки удалось захватить, философ продолжает выполнение.
     * Если философ не может взять обе вилки одновременно, он освобождает предыдущую захваченную вилку
     * и повторяет попытку позже.
     *
     * @throws InterruptedException если поток был прерван во время ожидания захвата обеих вилок.
     */
    private void pickUpForks() throws InterruptedException {
        while (true) {
            if (leftFork.tryPickUp()) {
                System.out.println("Философ " + id + " берет левую вилку");
                if (rightFork.tryPickUp()) {
                    System.out.println("Философ " + id + " берет правую вилку");
                    return; // Философ взял обе вилки
                } else {
                    leftFork.putDown();
                    System.out.println("Философ " + id + " кладет левую вилку, т.к. правая занята");
                }
            }
            Thread.sleep(100); // Пауза перед повторной попыткой
        }
    }

    /**
     * Метод представляет действие философа в процессе отпускания вилок
     */
    private void putDownForks() {
        leftFork.putDown();
        System.out.println("Философ " + id + " кладет левую вилку");
        rightFork.putDown();
        System.out.println("Философ " + id + " кладет правую вилку");
    }

    /**
     * Запускает выполнение потока философа
     */
    @Override
    public void run() {
        try {
            for (int i = 0; i < numEats; i++) {
                think();
                pickUpForks();
                eat();
                putDownForks();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
