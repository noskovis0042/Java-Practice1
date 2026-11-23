package Task7;

/**
 * Практическая работа 7, задание 1.
 * Реализация по UML-диаграмме (см. movable.drawio):
 * интерфейс Movable (вверх, вниз, влево, вправо) и класс MovableRectangle, его реализующий.
 */
public class Task1 {

    interface Movable {
        void moveUp();
        void moveDown();
        void moveLeft();
        void moveRight();
    }

    static class MovableRectangle implements Movable {
        private int x, y;          // верхний левый угол
        private final int width, height;
        private final int speed;

        MovableRectangle(int x, int y, int width, int height, int speed) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.speed = speed;
        }

        @Override public void moveUp()    { y -= speed; }
        @Override public void moveDown()  { y += speed; }
        @Override public void moveLeft()  { x -= speed; }
        @Override public void moveRight() { x += speed; }

        @Override
        public String toString() {
            return "MovableRectangle [x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + "]";
        }
    }

    public static void main(String[] args) {
        Movable rect = new MovableRectangle(0, 0, 4, 3, 1);
        System.out.println("Начало:  " + rect);
        rect.moveRight();
        rect.moveRight();
        rect.moveDown();
        System.out.println("2 вправо, 1 вниз: " + rect);
        rect.moveLeft();
        rect.moveUp();
        System.out.println("1 влево, 1 вверх:    " + rect);
    }
}
