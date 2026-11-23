package Task4;

// Интерфейсы
interface MenClothing {
    void dressMan();
}

interface WomenClothing {
    void dressWomen();
}

// Перечисление размеров одежды
enum Size {
    XXS(32) {
        @Override
        public String getDescription() {
            return "Детский размер";
        }
    },
    XS(34),
    S(36),
    M(38),
    L(40);

    private final int euroSize;

    // Конструктор, принимающий euroSize
    Size(int euroSize) {
        this.euroSize = euroSize;
    }

    public int getEuroSize() {
        return euroSize;
    }

    // Метод по умолчанию для всех размеров
    public String getDescription() {
        return "Взрослый размер";
    }
}

// Абстрактный класс Одежда
abstract class Clothes {
    protected Size size;      // размер одежды
    protected double cost;    // стоимость
    protected String color;   // цвет

    public Clothes(Size size, double cost, String color) {
        this.size = size;
        this.cost = cost;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("[Размер: %s (EU: %d, %s), Цвет: %s, Цена: %.2f руб.]",
                size.name(), size.getEuroSize(), size.getDescription(), color, cost);
    }
}

// Классы-наследники
class TShirt extends Clothes implements MenClothing, WomenClothing {
    public TShirt(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Мужчина надел футболку " + this);
    }

    @Override
    public void dressWomen() {
        System.out.println("Женщина надела футболку " + this);
    }
}

class Pants extends Clothes implements MenClothing, WomenClothing {
    public Pants(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Мужчина надел штаны " + this);
    }

    @Override
    public void dressWomen() {
        System.out.println("Женщина надела штаны " + this);
    }
}

class Skirt extends Clothes implements WomenClothing {
    public Skirt(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressWomen() {
        System.out.println("Женщина надела юбку " + this);
    }
}

class Tie extends Clothes implements MenClothing {
    public Tie(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Мужчина надел галстук " + this);
    }
}

// Класс Ателье
class Atelier {
    
    // Переопределенный метод для вывода всей информации о женской одежде
    public void dressWomen(Clothes[] clothes) {
        System.out.println("\n--- Женская одежда в ателье ---");
        for (Clothes item : clothes) {
            // Проверяем, реализует ли объект интерфейс WomenClothing
            if (item instanceof WomenClothing) {
                // Приводим тип и вызываем метод одевания
                ((WomenClothing) item).dressWomen();
            }
        }
    }

    // Переопределенный метод для вывода всей информации о мужской одежде
    public void dressMan(Clothes[] clothes) {
        System.out.println("\n--- Мужская одежда в ателье ---");
        for (Clothes item : clothes) {
            // Проверяем, реализует ли объект интерфейс MenClothing
            if (item instanceof MenClothing) {
                // Приводим тип и вызываем метод одевания
                ((MenClothing) item).dressMan();
            }
        }
    }
}

// Главный класс для запуска
public class AtelierTask {
    public static void main(String[] args) {
        // 4) Создать массив, содержащий все типы одежды.
        // Тип массива - общий родительский класс Clothes.
        Clothes[] wardrobe = new Clothes[] {
            new TShirt(Size.S, 1500.0, "Белый"),
            new TShirt(Size.XXS, 900.0, "Розовый"),
            new Pants(Size.M, 3500.0, "Черный"),
            new Skirt(Size.XS, 2200.0, "Синий"),
            new Tie(Size.L, 800.0, "Бордовый")
        };

        Atelier atelier = new Atelier();

        // Вызываем методы ателье
        atelier.dressWomen(wardrobe);
        atelier.dressMan(wardrobe);
        
        System.out.println("\n--- Демонстрация работы enum Size ---");
        System.out.println("Размер XXS: " + Size.XXS.getDescription() + ", Euro: " + Size.XXS.getEuroSize());
        System.out.println("Размер M:   " + Size.M.getDescription() + ", Euro: " + Size.M.getEuroSize());
    }
}