import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        TestAuthor();
        ShopManager();
        Poker();
    }

    public static void TestAuthor() {
        // Создаем объект автора по нашей схеме
        Author author = new Author("Лев Толстой", "tolstoy@lit.ru", 'М');
        System.out.println("Имя автора: " + author.getName());
        System.out.println("Email автора: " + author.getEmail());
        System.out.println("Пол: " + author.getGender());
        // Меняем почту
        author.setEmail("new_tolstoy@lit.ru");
        System.out.println("Строковое представление: " + author);
    }

    public static class Author {
        private String name;
        private String email;
        private char gender;

        public Author(String name, String email, char gender) {
            this.name = name;
            this.email = email;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public char getGender() {
            return gender;
        }

        @Override
        public String toString() {
            return "Author[name=" + name + ", email=" + email + ", gender=" + gender + "]";
        }
    }

    static class Computer {
        private String brand;
        private double price;

        public Computer(String brand, double price) {
            this.brand = brand;
            this.price = price;
        }

        public String getBrand() {
            return brand;
        }

        @Override
        public String toString() {
            return "Компьютер: " + brand + " (Цена: " + price + " руб.)";
        }
    }

    static class Shop {
        private List<Computer> computers = new ArrayList<>();

        public void addComputer(Computer computer) {
            computers.add(computer);
            System.out.println("Компьютер успешно добавлен!");
        }

        public void removeComputer(String brand) {
            boolean removed = computers.removeIf(c -> c.getBrand().equalsIgnoreCase(brand));
            if (removed) {
                System.out.println("Компьютер " + brand + " удален.");
            } else {
                System.out.println("Компьютер с таким брендом не найден.");
            }
        }

        public void searchComputer(String brand) {
            boolean found = false;
            for (Computer c : computers) {
                if (c.getBrand().equalsIgnoreCase(brand)) {
                    System.out.println("Найден: " + c);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Компьютер " + brand + " не найден в магазине.");
            }
        }

        public void printAll() {
            if (computers.isEmpty()) {
                System.out.println("Магазин пуст.");
            } else {
                System.out.println("Список товаров в магазине:");
                for (Computer c : computers) System.out.println(c);
            }
        }
    }

    public static void ShopManager() {
        Scanner scanner = new Scanner(System.in);
        Shop shop = new Shop();

        System.out.println("Панель управления магазином");
        while (true) {
            System.out.println("Выберите действие:\n1. Добавить компьютер\n2. Удалить компьютер\n3. Найти компьютер\n4. Показать все\n5. Завершить работу с магазином");
            System.out.print("Ввод: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            if (choice == 5) break;

            switch (choice) {
                case 1:
                    System.out.print("Введите бренд/модель: ");
                    String brand = scanner.nextLine();
                    System.out.print("Введите стоимость: ");
                    double price = scanner.nextDouble();
                    shop.addComputer(new Computer(brand, price));
                    break;
                case 2:
                    System.out.print("Введите бренд для удаления: ");
                    String toRemove = scanner.nextLine();
                    shop.removeComputer(toRemove);
                    break;
                case 3:
                    System.out.print("Какой бренд ищем?: ");
                    String toSearch = scanner.nextLine();
                    shop.searchComputer(toSearch);
                    break;
                case 4:
                    shop.printAll();
                    break;
                default:
                    System.out.println("Неверный пункт меню.");
            }
        }
    }

    public static void Poker() {
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
            System.out.println("Невозможно раздать карты. Неверное число игроков (максимум 10).");
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
    }
}