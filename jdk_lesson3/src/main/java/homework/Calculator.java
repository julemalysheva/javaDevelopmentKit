package homework;

/**
 * Класс, представляющий калькулятор.
 */
public class Calculator {
    /**
     * Обобщенный метод для сложения двух чисел.
     *
     * @param a   первое число
     * @param b   второе число
     * @param <T> тип чисел
     * @return результат сложения
     */
    public static <T extends Number> double sum(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }

    /**
     * Обобщенный метод для умножения двух чисел.
     *
     * @param a   первое число
     * @param b   второе число
     * @param <T> тип чисел
     * @return результат умножения
     */
    public static <T extends Number> double multiply(T a, T b) {
        return a.doubleValue() * b.doubleValue();
    }

    /**
     * Обобщенный метод для деления двух чисел.
     *
     * @param a   делимое
     * @param b   делитель
     * @param <T> тип чисел
     * @return результат деления
     */
    public static <T extends Number> double divide(T a, T b) {
        return a.doubleValue() / b.doubleValue();
    }

    /**
     * Обобщенный метод для вычитания двух чисел.
     *
     * @param a   уменьшаемое
     * @param b   вычитаемое
     * @param <T> тип чисел
     * @return результат вычитания
     */
    public static <T extends Number> double subtract(T a, T b) {
        return a.doubleValue() - b.doubleValue();
    }

    /**
     * Обобщенный метод для сравнения двух массивов.
     *
     * @param array1 первый массив
     * @param array2 второй массив
     * @param <T>    тип элементов массивов
     * @return true, если массивы одинаковые, и false в противном случае
     */
    public static <T> boolean compareArrays(T[] array1, T[] array2) {
        if (array1.length != array2.length) {
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].equals(array2[i])) {
                return false;
            }
        }
        return true;
    }

}

