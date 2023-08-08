package entities;

public class Triangle {
    public double a;
    public double b;
    public double c;

    public double calcularArea(){
        double perimetro = (a + b + c)/2;

        return Math.sqrt(perimetro * (perimetro - a) * (perimetro - b) * (perimetro - c));
    }
}
