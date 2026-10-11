package Task2;

public class Author {
    private String name;
    private String email;
    private char gender;

    // Конструктор: убран 'void', имя совпадает с именем класса
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
        return "Task2.Author[name=" + name + ", email=" + email + ", gender=" + gender + "]";
    }

    // Точка входа для запуска тестирования автора
    public static void main(String[] args) {
        System.out.println("=== Тестирование класса Task2.Author ===");
        // Теперь объект создается корректно
        Author author = new Author("Лев Толстой", "tolstoy@lit.ru", 'М');
        System.out.println("Имя автора: " + author.getName());
        System.out.println("Email автора: " + author.getEmail());
        System.out.println("Пол: " + author.getGender());

        author.setEmail("new_tolstoy@lit.ru");
        System.out.println("Строковое представление: " + author);
    }
}
