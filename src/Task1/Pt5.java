package Task1;

public class Pt5 {
    public static void main(String[] args) {
        // Если аргументы не переданы, используются тестовые
        if (args.length == 0) {
            args = new String[]{"Аргумент1", "Тест", "Java_IDEA"};
        }

        System.out.println("Аргументы командной строки:");
        // Цикл for для перебора и вывода аргументов
        for (int i = 0; i < args.length; i++) {
            System.out.println("Аргумент [" + i + "]: " + args[i]);
        }
    }
}
