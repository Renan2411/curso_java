package entities;

public class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary){
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void increaseSalary(double percent){
        this.salary *= (1 + (percent/100));
    }

    public String toString(){
        return this.id +
                ", " +
                this.name +
                ", " +
                String.format("%.2f", this.salary);
    }


    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getId(){
        return this.id;
    }

    public double getSalary(){
        return this.salary;
    }
}
