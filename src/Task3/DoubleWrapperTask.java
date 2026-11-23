public class DoubleWrapperTask {
    public static void main(String[] args) {

        System.out.println("=== 1. Создание объектов класса Double через valueOf() ===");
        // Создаем объекты Double с помощью метода valueOf()
        // (это рекомендуемый способ, так как он использует кэширование)
        Double doubleObj1 = Double.valueOf(3.14159);
        Double doubleObj2 = Double.valueOf("2.71828"); // также принимает строку
        System.out.println("Создан объект 1: " + doubleObj1);
        System.out.println("Создан объект 2: " + doubleObj2);
        System.out.println();

        System.out.println("=== 2. Преобразование String в double с помощью parseDouble() ===");
        String stringValue = "42.195";
        // Метод parseDouble() возвращает примитив double (а не объект)
        double primitiveFromString = Double.parseDouble(stringValue);
        System.out.println("Строка: \"" + stringValue + "\" -> примитив double: " + primitiveFromString);
        System.out.println();

        System.out.println("=== 3. Преобразование объекта Double ко всем примитивным типам ===");
        Double myDoubleObj = 123.456;
        System.out.println("Исходный объект Double: " + myDoubleObj);

        // Явное преобразование (сужение) к другим примитивным типам
        byte b = myDoubleObj.byteValue();
        short s = myDoubleObj.shortValue();
        int i = myDoubleObj.intValue();
        long l = myDoubleObj.longValue();
        float f = myDoubleObj.floatValue();
        double d = myDoubleObj.doubleValue(); // к самому себе

        System.out.println("-> byte:   " + b);
        System.out.println("-> short:  " + s);
        System.out.println("-> int:    " + i + " (дробная часть отбрасывается)");
        System.out.println("-> long:   " + l);
        System.out.println("-> float:  " + f);
        System.out.println("-> double: " + d);
        System.out.println();

        System.out.println("=== 4. Вывод значения объекта Double на консоль ===");
        Double printObj = 99.99;
        // System.out.println автоматически вызывает метод toString() у объекта
        System.out.println("Значение объекта: " + printObj);
        System.out.println();

        System.out.println("=== 5. Преобразование литерала double к строке через Double.toString() ===");
        // Строго по заданию:
        String strD = Double.toString(3.14);
        System.out.println("Литерал 3.14 -> Строка: \"" + strD + "\"");
    }
}