package Task7;

/**
 * Практическая работа 7, задание 2.
 * Прямоугольник как две движущиеся точки MovablePoint (topLeft и bottomRight).
 * MovablePoint и MovableRectangle реализуют интерфейс Movable.
 */
public class Task2 {

    interface Movable {
        void moveUp();
        void moveDown();
        void moveLeft();
        void moveRight();
    }

    static class MovablePoint implements Movable {
        int x, y;
        int xSpeed, ySpeed;

        MovablePoint(int x, int y, int xSpeed, int ySpeed) {
            this.x = x;
            this.y = y;
            this.xSpeed = xSpeed;
            this.ySpeed = ySpeed;
        }

        @Override public void moveUp()    { y -= ySpeed; }
        @Override public void moveDown()  { y += ySpeed; }
        @Override public void moveLeft()  { x -= xSpeed; }
        @Override public void moveRight() { x += xSpeed; }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    static class MovableRectangle implements Movable {
        private final MovablePoint topLeft;
        private final MovablePoint bottomRight;

        MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
            topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
            bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
        }

        // обе точки двигаются вместе, чтобы прямоугольник не менял размер
        @Override public void moveUp()    { topLeft.moveUp();    bottomRight.moveUp(); }
        @Override public void moveDown()  { topLeft.moveDown();  bottomRight.moveDown(); }
        @Override public void moveLeft()  { topLeft.moveLeft();  bottomRight.moveLeft(); }
        @Override public void moveRight() { topLeft.moveRight(); bottomRight.moveRight(); }

        @Override
        public String toString() {
            return "MovableRectangle[topLeft=" + topLeft + ", bottomRight=" + bottomRight + "]";
        }
    }

    public static void main(String[] args) {
        MovableRectangle rect = new MovableRectangle(0, 0, 4, 3, 1, 1);
        System.out.println("Начало:  " + rect);
        rect.moveRight();
        rect.moveRight();
        rect.moveDown();
        System.out.println("Вправо 2, вниз: " + rect);
        rect.moveLeft();
        rect.moveUp();
        System.out.println("Влево, вверх:    " + rect);
    }
}
