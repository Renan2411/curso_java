package entites;

import enuns.Color;

public abstract class Shape {
    protected Color color;

    public Shape(){}

    public Shape(Color color){
        this.color = color;
    }

    public abstract double area();

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
