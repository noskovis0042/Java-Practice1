package Task1;

public class Pt7 {

    // Метод класса для вычисления факториала
    public static long myFactorial(int n) {
        long result = 1;
        // Главный цикл для расчета
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        // Если аргументы не переданы, используются тестовые
        if (args.length == 0) {
            args = new String[]{"5", "0", "12"};
        }

        // Цикл перебирает все переданные аргументы командной строки
        for (String arg : args) {
            int number = Integer.parseInt(arg);

            // Проверка на отрицательное число
            if (number < 0) {
                System.out.println("Факториал для отрицательного числа не существует.");
            } else {
                System.out.println("Факториал " + number + " = " + myFactorial(number));
            }
        }
    }
}
