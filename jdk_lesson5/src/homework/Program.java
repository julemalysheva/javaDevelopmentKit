package homework;

/**
 * Класс Program представляет ситуацию, в которой несколько философов сидят вокруг стола
 * и обмениваются вилками для того, чтобы есть. Каждый философ представлен в виде отдельного потока.
 * В классе реализовано создание философов, вилок и их взаимодействие для
 * обеспечения безопасного употребления пищи.
 */

public class Program {
    private static final int NUM_PHILOSOPHERS = 5;// число философов, константа

    /**
     * Точка входа. Создает и запускает потоки для философов, создает вилки.
     */
    public static void main(String[] args) {
        Fork[] forks = new Fork[NUM_PHILOSOPHERS];
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            forks[i] = new Fork();
        }

        Philosopher[] philosophers = new Philosopher[NUM_PHILOSOPHERS];
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            int leftForkIndex = i;
            int rightForkIndex = (i + 1) % NUM_PHILOSOPHERS; //круговой порядок забора вилок
            philosophers[i] = new Philosopher(
                    i, forks[leftForkIndex], forks[rightForkIndex], Constants.NUM_EATS);
        }

        for (Philosopher philosopher : philosophers) {
            Thread thread = new Thread(philosopher);
            thread.start();
        }
    }
}
