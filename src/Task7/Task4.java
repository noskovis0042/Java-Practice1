package Task7;// Практическая работа 7, задание 4.

// Интерфейс с объявлениями математических функций и числом PI
interface MathCalculable {
    double PI = 3.14159265358979; // поля интерфейса неявно public static final

    // Возведение в степень
    double pow(double base, int exponent);

    // Модуль комплексного числа re + i*im
    double complexModule(double re, double im);
}

class MathFunc implements MathCalculable {

    @Override
    public double pow(double base, int exponent) {
        double result = 1;
        int n = Math.abs(exponent);
        for (int i = 0; i < n; i++) {
            result *= base;
        }
        return exponent >= 0 ? result : 1 / result;
    }

    @Override
    public double complexModule(double re, double im) {
        return Math.sqrt(pow(re, 2) + pow(im, 2));
    }

    // Длина окружности, использует число PI из интерфейса
    public double circleLength(double radius) {
        return 2 * PI * radius;
    }
}

public class Task4 {
    public static void main(String[] args) {
        MathCalculable mc1 = new MathFunc(); // правильно

        System.out.println("2^10 = " + mc1.pow(2, 10));
        System.out.println("2^(-2) = " + mc1.pow(2, -2));
        System.out.println("|3 + 4i| = " + mc1.complexModule(3, 4));
        System.out.println("PI = " + MathCalculable.PI);

        MathFunc mf = new MathFunc();
        System.out.println("Длина окружности при r = 5: " + mf.circleLength(5));
    }
}
