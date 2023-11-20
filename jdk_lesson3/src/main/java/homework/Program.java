package homework;

public class Program {
    public static void main(String[] args) {
        // Пример использования методов класса Calculator

        // Сложение двух чисел
        double sumResult = Calculator.sum(5, 3);
        System.out.println("Результат сложения: " + sumResult);

        // Умножение двух чисел
        double multiplyResult = Calculator.multiply(5.2, 2);
        System.out.println("Результат умножения: " + multiplyResult);

        // Деление двух чисел
        double divideResult = Calculator.divide(10, 3);
        System.out.println("Результат деления: " + divideResult);

        // Вычитание двух чисел
        float subtractResult = (float) Calculator.subtract(8.5f, 3.2f);
        System.out.println("Результат вычитания: " + subtractResult);

        // Пример использования метода compareArrays
        Integer[] array1 = {1, 2, 3};
        Integer[] array2 = {1, 2, 3};
        boolean areEqual = Calculator.compareArrays(array1, array2);
        System.out.println("Массивы равны: " + areEqual);

        // Пример использования класса Pair
        Pair<String, Integer> pair = new Pair<>("Ivan", 25);
        String name = pair.getFirst();
        int age = pair.getSecond();
        System.out.println("Имя: " + name);
        System.out.println("Возраст: " + age);
        System.out.println(pair);
    }
}

