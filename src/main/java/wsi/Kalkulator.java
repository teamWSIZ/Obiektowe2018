package wsi;

public class Kalkulator {

    int add(int a, int b) {
        return a+b;
    }

    int divide(int a, int b) {
        return a/b;
    }

    double divide(double a, double b) {
        return a / b;
    }

    double multiply(double a, double b) {
        return a*b;
    }


    public static void main(String[] args) {
        Kalkulator k = new Kalkulator();
        System.out.println(k.add(3, 5));
        System.out.println(k.add(3, -5));
    }
}
