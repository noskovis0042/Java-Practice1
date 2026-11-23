package Task1;

public class Pt6 {
    public static void main(String[] args) {
        System.out.println("Первые 10 чисел гармонического ряда:");

        // Цикл для расчета и форматированного вывода первых 10 элементов
        for (int i = 1; i <= 10; i++) {
            double value = 1.0 / i;
            // %-2d - число влево (минимум 2 символа), %.4f - число с 4 знаками после запятой
            System.out.printf("1/%-2d = %.4f%n", i, value);
        }
    }
}
