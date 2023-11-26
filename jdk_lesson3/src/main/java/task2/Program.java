package task2;

import java.util.Arrays;

/**
 * Описать собственную коллекцию – список на основе массива.
 * Коллекция должна иметь возможность хранить любые типы данных,
 * иметь методы добавления и удаления элементов.
 */
public class Program<T> {
    private Object[] array;
    private int size;

    public Program(int length) {
        this.array = new Object[length];
    }

    public void addToArray(T el) {
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size++] = el;
    }

    public void delToArray(T el) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(el)) {
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                break;
            }
        }
    }
}
