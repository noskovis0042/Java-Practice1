package Task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Computer {
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

public class Shop {
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

    // Точка входа для запуска магазина
    public static void main(String[] args) {
        System.out.println("=== Панель управления магазином ===");
        Scanner scanner = new Scanner(System.in);
        Shop shop = new Shop();

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
        scanner.close();
    }
}
