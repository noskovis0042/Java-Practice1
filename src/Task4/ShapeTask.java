abstract class Shape {
    abstract double getArea();
    abstract double getPerimeter();
    abstract String getType();

    @Override
    public String toString() {
        return getType() +"\nПлощадь: " + getArea() + "\nПериметр: " + getPerimeter();
    }
}

class Circle extends Shape {
    private final double radius;

    public Circle(double radius) { this.radius = radius; }

    @Override double getArea() { return Math.PI * radius * radius; }
    @Override double getPerimeter() { return 2 * Math.PI * radius; }
    @Override String getType() { return "Круг"; }
}

class Rectangle extends Shape {
    protected double width;
    protected double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    @Override double getArea() { return width * length; }
    @Override double getPerimeter() { return 2 * (width + length); }
    @Override String getType() { return "Прямоугольник"; }
}

class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }

    @Override String getType() { return "Квадрат"; }
}

public class ShapeTask {
    public static void main(String[] args) {
        // Демонстрация вызова методов через родительскую ссылку (полиморфизм)
        Shape[] shapes = {
                new Circle(5.0),
                new Rectangle(4.0, 6.0),
                new Square(3.0)
        };

        for (Shape s : shapes) {
            System.out.println(s);
        }
    }
}