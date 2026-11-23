package Task2;

import java.util.Scanner;

public class HowMany {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите слова (в одной строке):");
        String line = sc.nextLine().trim();

        if (line.isEmpty()) {
            System.out.println("Вы ввели 0 слов.");
            return;
        }

        // \\s+ — один или несколько пробельных символов
        String[] words = line.split("\\s+");

        System.out.println("Вы ввели " + words.length + " слов(а).");
    }
}