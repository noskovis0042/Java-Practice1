package Task1;

public class Pt3 {
    public static void main(String[] args) {
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
}
