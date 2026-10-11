import java.util.Scanner;

class Task1 {
    public static void main(String[] args) {
        Pt3();
        Pt4();
        String[] testArgs = {"Аргумент1", "Тест", "Java_IDEA"};
        Pt5(testArgs);
        Pt6();
        String[] testArgs2 = {"5", "0", "12"};
        Pt7(testArgs2);
    }


    public static void Pt3() {
        // Инициализация массива
        int[] numbers = {5, 12, 9, 23, 7, 14, 1, 18, 4, 11};

        int sum = 0;

        // Цикл for для подсчета суммы
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        // Среднее арифметическое
        double average = (double) sum / numbers.length;

        System.out.println("Сумма элементов: " + sum);
        System.out.println("Среднее арифметическое: " + average);
    }

    public static void Pt4() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // 1. Подсчет суммы с помощью цикла while
        int sumWhile = 0;
        int i = 0;
        while (i < arr.length) {
            sumWhile += arr[i];
            i++;
        }

        // 2. Подсчет суммы с помощью цикла do-while
        int sumDoWhile = 0;
        int j = 0;
        if (arr.length > 0) {
            do {
                sumDoWhile += arr[j];
                j++;
            } while (j < arr.length);
        }

        // 3. Поиск минимального и максимального элементов
        int max = arr[0];
        int min = arr[0];
        for (int k = 1; k < arr.length; k++) {
            if (arr[k] > max) {
                max = arr[k];
            }
            if (arr[k] < min) {
                min = arr[k];
            }
        }

        System.out.println("Результаты:");
        System.out.println("Сумма (через while): " + sumWhile);
        System.out.println("Сумма (через do-while): " + sumDoWhile);
        System.out.println("Максимальный элемент: " + max);
        System.out.println("Минимальный элемент: " + min);
    }


    public static void Pt5(String[] args) {
        // Проверяем, переданы ли аргументы
        if (args.length == 0) {
            System.out.println("Аргументы командной строки не переданы.");
            return;
        }

        System.out.println("Аргументы командной строки:");
        // Цикл for для перебора и вывода аргументов
        for (int i = 0; i < args.length; i++) {
            System.out.println("Аргумент [" + i + "]: " + args[i]);
        }
    }

    public static void Pt6() {
        System.out.println("Первые 10 чисел гармонического ряда:");

        // Цикл для расчета и форматированного вывода первых 10 элементов
        for (int i = 1; i <= 10; i++) {
            double value = 1.0 / i;
            // %-2s - строка влево (минимум 2 символа), %.4f - число с 4 знаками после запятой
            System.out.printf("1/%-2d = %.4f%n", i, value);
        }
    }


    // Метод класса для вычисления факториала
    public static long myFactorial(int n) {

        long result = 1;
        // Главный цикл для расчета
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void Pt7(String[] args) {
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