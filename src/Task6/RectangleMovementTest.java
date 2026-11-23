package Task6;

// Интерфейс Movable и класс MovablePoint берутся из CircleMovementTest.java
// (тот же пакет Task6), поэтому здесь они не дублируются.

// Класс Движущийся прямоугольник: две движущиеся точки (агрегация, см. рис. 6.4)
class MovableRectangle implements Movable {
    private MovablePoint topLeft;      // верхняя левая точка
    private MovablePoint bottomRight;  // нижняя правая точка

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        this.topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
        this.bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
    }

    // Метод, проверяющий, что у двух точек одна и та же скорость
    public boolean hasSameSpeed() {
        return topLeft.xSpeed == bottomRight.xSpeed
                && topLeft.ySpeed == bottomRight.ySpeed;
    }

    // Обе точки двигаются одновременно, поэтому размер прямоугольника не меняется
    @Override
    public void moveUp() {
        topLeft.moveUp();
        bottomRight.moveUp();
    }

    @Override
    public void moveDown() {
        topLeft.moveDown();
        bottomRight.moveDown();
    }

    @Override
    public void moveLeft() {
        topLeft.moveLeft();
        bottomRight.moveLeft();
    }

    @Override
    public void moveRight() {
        topLeft.moveRight();
        bottomRight.moveRight();
    }

    @Override
    public String toString() {
        return "MovableRectangle(topLeft=" + topLeft + ", bottomRight=" + bottomRight + ")";
    }
}

// Главный класс для запуска и тестирования
public class RectangleMovementTest {
    public static void main(String[] args) {
        System.out.println("=== Тестирование MovableRectangle ===");
        MovableRectangle r = new MovableRectangle(0, 0, 4, 3, 2, 1);
        System.out.println("До: " + r);
        System.out.println("Скорости точек одинаковы: " + r.hasSameSpeed());

        r.moveRight();
        r.moveDown();
        System.out.println("Движение Вправо и Вниз");
        System.out.println("После: " + r);

        r.moveLeft();
        r.moveUp();
        System.out.println("Движение Влево и Вверх");
        System.out.println("После: " + r);
    }
}
