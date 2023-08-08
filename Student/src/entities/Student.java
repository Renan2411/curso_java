package entities;

public class Student {
   public  String name;
    public double firstGrade, secondGrade, thirdGrade;

    public double finalGrade(){
        return firstGrade + secondGrade + thirdGrade;
    }

    public String toSring(){
        String msg = "FINAL GRADE = " + finalGrade() + "\n";

        msg += finalGrade() < 60
                ? "FAILED \nMISSING " + String.format("%.2f", 60 - finalGrade()) + " POINTS"
                : "PASS";

        return msg;
    }
}
