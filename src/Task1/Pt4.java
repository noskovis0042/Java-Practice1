package Task1;

import java.util.Scanner;

public class Pt4 {
    public static void main(String[] args) {
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
}
