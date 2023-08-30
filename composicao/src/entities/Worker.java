package entities;

import enuns.WorkerLevel;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Worker {
    private String name;
    private WorkerLevel level;
    private double baseSalary;
    private Departament departament;
    List<HourContract> contracts = new ArrayList<>();

    public Worker(){}

    public Worker(String name, WorkerLevel level, double baseSalary, Departament departament) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.departament = departament;
    }

    public void addContract(HourContract contract){
        this.contracts.add(contract);
    }

    public void removeContract(HourContract contract){
        this.contracts.remove(contract);
    }

    public double income(int year, int month){

        List<HourContract> incomeContracts = this.contracts.stream().filter(contract ->(contract.getDate().getMonth() == month && contract.getDate().getYear() == year)).collect(Collectors.toList());

        double income = this.baseSalary;

        for(HourContract contract : incomeContracts){
            income += contract.totalValue();
        }

       return income;
    }

    public String toString(){
        return "Name: " + this.name + "\nDepartament: " + this.departament.getName() + "\n";
    }
}
