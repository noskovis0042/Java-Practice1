import java.util.ArrayList;
import java.util.List;

// Абстрактный класс Транспортное средство
abstract class Vehicle {
    private String name;
    private double speed; // км/ч
    private double passengerCostPerKm; // стоимость за 1 пасс/км
    private double cargoCostPerTonKm;  // стоимость за 1 тонну/км

    public Vehicle(String name, double speed, double passengerCostPerKm, double cargoCostPerTonKm) {
        this.name = name;
        this.speed = speed;
        this.passengerCostPerKm = passengerCostPerKm;
        this.cargoCostPerTonKm = cargoCostPerTonKm;
    }

    public String getName() {
        return name;
    }

    // Метод для подсчета времени
    public double calculateTime(double distance) {
        if (speed <= 0) return Double.POSITIVE_INFINITY;
        return distance / speed;
    }

    // Метод для подсчета стоимости перевозки пассажиров и грузов
    public double calculateCost(double distance, int passengers, double cargoWeightTons) {
        double passengerTotal = distance * passengers * passengerCostPerKm;
        double cargoTotal = distance * cargoWeightTons * cargoCostPerTonKm;
        return passengerTotal + cargoTotal;
    }
}

// Подкласс Автомобиль
class Car extends Vehicle {
    public Car() {
        super("Автомобиль", 80.0, 5.0, 15.0);
    }
}

// Подкласс Самолет
class Airplane extends Vehicle {
    public Airplane() {
        super("Самолет", 800.0, 15.0, 50.0);
    }
}

// Подкласс Поезд
class Train extends Vehicle {
    public Train() {
        super("Поезд", 100.0, 3.0, 8.0);
    }
}

// Подкласс Корабль
class Ship extends Vehicle {
    public Ship() {
        super("Корабль", 40.0, 4.0, 5.0);
    }
}

// Главный класс для демонстрации работы программы
public class TransportTask {
    public static void main(String[] args) {
        // Входные данные
        double distance = 500.0;       // Расстояние в км
        int passengers = 2;            // Количество пассажиров
        double cargoWeight = 1.5;      // Вес груза в тоннах

        // Список транспортных средств
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car());
        vehicles.add(new Airplane());
        vehicles.add(new Train());
        vehicles.add(new Ship());

        System.out.printf("Расчет для перевозки на %.1f км (%d пасс., %.1f т груза):%n%n",
                distance, passengers, cargoWeight);

        for (Vehicle vehicle : vehicles) {
            double time = vehicle.calculateTime(distance);
            double cost = vehicle.calculateCost(distance, passengers, cargoWeight);

            System.out.println("--- " + vehicle.getName() + " ---");
            System.out.printf("Время в пути: %.2f ч.%n", time);
            System.out.printf("Стоимость перевозки: %.2f руб.%n%n", cost);
        }
    }
}
