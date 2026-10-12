// 1. Интерфейс движения
interface Movable {
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
}

// 2. Класс Точка
class MovablePoint implements Movable {
    int x;
    int y;
    int xSpeed;
    int ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public void moveUp() { y -= ySpeed; }

    @Override
    public void moveDown() { y += ySpeed; }

    @Override
    public void moveLeft() { x -= xSpeed; }

    @Override
    public void moveRight() { x += xSpeed; }

    @Override
    public String toString() {
        return String.format("MovablePoint(x=%d, y=%d, xSpeed=%d, ySpeed=%d)", x, y, xSpeed, ySpeed);
    }
}

// 3. Класс Круг
class MovableCircle implements Movable {
    private int radius;
    private MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        this.center = new MovablePoint(x, y, xSpeed, ySpeed);
        this.radius = radius;
    }

    @Override
    public void moveUp() { center.moveUp(); }

    @Override
    public void moveDown() { center.moveDown(); }

    @Override
    public void moveLeft() { center.moveLeft(); }

    @Override
    public void moveRight() { center.moveRight(); }

    @Override
    public String toString() {
        return "MovableCircle(radius=" + radius + ", center=" + center + ")";
    }
}


// 5. Главный класс приложения для запуска и тестирования
public class Task6_1 {
    public static void main(String[] args) {
        System.out.println("=== 1. Тестирование MovablePoint ===");
        MovablePoint p = new MovablePoint(0, 0, 2, 3);
        System.out.println("До: " + p);
        p.moveRight();
        System.out.println("Движение Вправо и Вниз");
        p.moveDown();
        System.out.println("После: " + p);

        System.out.println("\n=== 2. Тестирование MovableCircle ===");
        MovableCircle c = new MovableCircle(5, 5, 1, 1, 10);
        System.out.println("До: " + c);
        c.moveLeft();
        System.out.println("Движение Влево и Вверх");
        c.moveUp();
        System.out.println("После: " + c);
    }
}
