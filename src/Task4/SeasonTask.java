enum Season {
    WINTER("Зима", -20, "Холодное время года"),
    SPRING("Весна", +10, "Холодное время года"),
    SUMMER("Лето", +30, "Теплое время года") {
        // Переопределяем метод для константы Лето
        @Override
        public String getDescription() {
            return "Единственное теплое время года(";
        }
    },
    AUTUMN("Осень", -0, "Холодное время года");

    private final String name;
    private final int averageTemperature;
    private final String description;

    // Конструктор
    Season(String name, int averageTemperature, String description) {
        this.name = name;
        this.averageTemperature = averageTemperature;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getAverageTemperature() {
        return averageTemperature;
    }

    // Метод, который будет переопределен для Лета
    public String getDescription() {
        return description;
    }

    // Метод для вывода информации (пункт 2)
    public static void printSeasonInfo(Season season) {
        switch (season) {
            case SUMMER:
                System.out.println("Я люблю лето!");
                break;
            case WINTER:
                System.out.println("Я люблю зиму!");
                break;
            case SPRING:
                System.out.println("Я люблю весну!");
                break;
            case AUTUMN:
                System.out.println("Я люблю осень!");
                break;
        }
    }
}

public class SeasonTask {
    public static void main(String[] args) {
        // 1. Создать переменную с любимым временем года
        Season myFavorite = Season.SUMMER;
        System.out.println("Мое любимое время года: " + myFavorite.getName());
        Season.printSeasonInfo(myFavorite);

        System.out.println("--- Информация о всех временах года ---");
        // 6. Цикл по всем временам года
        for (Season season : Season.values()) {
            System.out.printf("%s: Средняя температура = %d°C, Описание: %s%n",
                    season.getName(), season.getAverageTemperature(), season.getDescription());
        }
    }
}