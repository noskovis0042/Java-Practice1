import java.util.Scanner;

// Интерфейс для работы со строками
interface StringProcessor {
    // a) Подсчет символов в строке
    int countChars(String s);

    // б) Строка из символов на нечетных позициях (1, 3, 5, ...)
    String oddChars(String s);

    // в) Инвертирование строки
    String reverse(String s);
}

// Класс ProcessStrings, реализующий интерфейс
class ProcessStrings implements StringProcessor {

    @Override
    public int countChars(String s) {
        return s.length();
    }

    @Override
    public String oddChars(String s) {
        StringBuilder sb = new StringBuilder();
        // В Java индексация с 0, но "нечетные позиции" в задании — это 1, 3, 5...
        // Значит, индексы 0, 2, 4... (через один)
        for (int i = 0; i < s.length(); i += 2) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    @Override
    public String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}


public class Task7_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку для обработки: ");
        String testString = scanner.nextLine();


        StringProcessor processor = new ProcessStrings();
        System.out.println("Исходная строка: " + testString);
        System.out.println("Количество символов: " + processor.countChars(testString));
        System.out.println("Символы на нечетных позициях: " + processor.oddChars(testString));
        System.out.println("Инвертированная строка: " + processor.reverse(testString));
    }
}
