package Task3;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class CurrencyConverter {

    // Перечисление для валют делает код надежнее, чем использование строк
    public enum Currency {
        RUB, USD, EUR
    }

    // Условные базовые курсы валют относительно Рубля (RUB)
    private static final double USD_TO_RUB = 92.50;
    private static final double EUR_TO_RUB = 100.20;

    /**
     * Метод для конвертации суммы из одной валюты в другую
     */
    public double convert(double amount, Currency from, Currency to) {
        // 1. Переводим исходную сумму в базовую валюту (рубли)
        double amountInRub;
        switch (from) {
            case USD:
                amountInRub = amount * USD_TO_RUB;
                break;
            case EUR:
                amountInRub = amount * EUR_TO_RUB;
                break;
            case RUB:
            default:
                amountInRub = amount;
                break;
        }

        // 2. Переводим из рублей в целевую валюту
        switch (to) {
            case USD:
                return amountInRub / USD_TO_RUB;
            case EUR:
                return amountInRub / EUR_TO_RUB;
            case RUB:
            default:
                return amountInRub;
        }
    }

    /**
     * Метод для форматированного вывода денежной суммы с учетом локали
     */
    public String format(double amount, Currency currency) {
        NumberFormat formatter;
        switch (currency) {
            case USD:
                formatter = NumberFormat.getCurrencyInstance(Locale.US);
                break;
            case EUR:
                formatter = NumberFormat.getCurrencyInstance(Locale.FRANCE);
                break;
            case RUB:
            default:
                formatter = NumberFormat.getCurrencyInstance(new Locale("ru", "RU"));
                break;
        }
        return formatter.format(amount);
    }

    // Точка входа для демонстрации работы класса
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();

        System.out.println("=== Конвертер валют ===");
        System.out.println("Доступные валюты: RUB, USD, EUR");

        try {
            System.out.print("Введите исходную валюту: ");
            Currency from = Currency.valueOf(scanner.next().trim().toUpperCase());

            System.out.print("Введите целевую валюту: ");
            Currency to = Currency.valueOf(scanner.next().trim().toUpperCase());

            System.out.print("Введите сумму для конвертации: ");
            double amount = scanner.nextDouble();

            // Выполняем конвертацию
            double convertedAmount = converter.convert(amount, from, to);

            // Красивый форматированный вывод результата
            System.out.println("\nРезультат конвертации:");
            System.out.println(converter.format(amount, from) + "  ==>  " + converter.format(convertedAmount, to));

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: Введена неподдерживаемая валюта (доступны RUB, USD, EUR).");
        } catch (Exception e) {
            System.out.println("Ошибка: Некорректный ввод данных.");
        }

        scanner.close();
    }
}