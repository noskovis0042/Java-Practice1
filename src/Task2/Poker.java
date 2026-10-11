package Task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Poker {
    public static void main(String[] args) {
        System.out.println("=== Имитация раздачи Покера ===");
        Scanner scanner = new Scanner(System.in);

        String[] suits = {"Пики", "Черви", "Бубны", "Трефы"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Валет", "Дама", "Король", "Туз"};

        List<String> deck = new ArrayList<>();
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add("[" + rank + " " + suit + "]");
            }
        }

        Collections.shuffle(deck);

        System.out.print("Введите количество игроков (n): ");
        int n = scanner.nextInt();

        if (n <= 0 || n * 5 > deck.size()) {
            System.out.println("Невозможно раздать карты. Неверное число игроков.");
            return;
        }

        int cardIndex = 0;
        for (int i = 1; i <= n; i++) {
            System.out.println("Игрок " + i + ":");
            for (int card = 0; card < 5; card++) {
                System.out.println("  " + deck.get(cardIndex++));
            }
            System.out.println();
        }
        scanner.close();
    }
}
