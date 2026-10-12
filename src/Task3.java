import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Task3 {
    static class CurrencyConverter {
        // Условные базовые курсы валют относительно Рубля (RUB)
        private static final double USD_TO_RUB = 92.50;
        private static final double EUR_TO_RUB = 100.20;

        /**
         * Метод для конвертации суммы из одной валюты в другую
         */
        public double convert(double amount, String from, String to) {
            // Сначала переводим всё в базовую валюту (рубли)
            double amountInRub;
            switch (from.toUpperCase()) {
                case "RUB":
                    amountInRub = amount;
                    break;
                case "USD":
                    amountInRub = amount * USD_TO_RUB;
                    break;
                case "EUR":
                    amountInRub = amount * EUR_TO_RUB;
                    break;
                default:
                    System.out.println("Неизвестная исходная валюта. Расчет в RUB.");
                    amountInRub = amount;
            }

            // Переводим из рублей в целевую валюту
            switch (to.toUpperCase()) {
                case "RUB":
                    return amountInRub;
                case "USD":
                    return amountInRub / USD_TO_RUB;
                case "EUR":
                    return amountInRub / EUR_TO_RUB;
                default:
                    System.out.println("Неизвестная целевая валюта. Возвращен эквивалент в RUB.");
                    return amountInRub;
            }
        }

        /**
         * Метод для форматированного вывода денежной суммы с учетом локали
         */
        public void displayFormatted(double amount, String currencyCode) {
            NumberFormat formatter;
            switch (currencyCode.toUpperCase()) {
                case "USD":
                    formatter = NumberFormat.getCurrencyInstance(Locale.US);
                    break;
                case "EUR":
                    formatter = NumberFormat.getCurrencyInstance(Locale.FRANCE);
                    break;
                case "RUB":
                default:
                    formatter = NumberFormat.getCurrencyInstance(new Locale("ru", "RU"));
                    break;
            }
            System.out.print(formatter.format(amount));
        }
    }

    //    Ввод/вывод
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();

        System.out.println("Доступные валюты: RUB, USD, EUR");

        System.out.print("Введите исходную валюту: ");
        String fromCurrency = scanner.next().trim();

        System.out.print("Введите целевую валюту: ");
        String toCurrency = scanner.next().trim();

        System.out.print("Введите сумму для конвертации: ");
        if (scanner.hasNextDouble()) {
            double amount = scanner.nextDouble();

            // Выполняем конвертацию
            double convertedAmount = converter.convert(amount, fromCurrency, toCurrency);

            // Красивый форматированный вывод результата
            System.out.print("Результат: ");
            converter.displayFormatted(amount, fromCurrency);
            System.out.print("  ==>  ");
            converter.displayFormatted(convertedAmount, toCurrency);
            System.out.println();
        } else {
            System.out.println("Ошибка: Введено некорректное число.");
        }
    }
}
