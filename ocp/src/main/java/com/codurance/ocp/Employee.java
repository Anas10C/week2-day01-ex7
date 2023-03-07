package com.codurance.ocp;

public class Employee {

    private int salary;
    private int bonus;

    private boolean hasBonus;
    private EmployeeType type;

    Employee(int salary, int bonus, EmployeeType type, boolean hasBonus) {
        this.salary = salary;
        this.bonus = bonus;
        this.type = type;
        this.hasBonus = hasBonus;
    }

    public int payAmount() {
        int amount = this.salary;
        if(this.hasBonus)
            amount += this.bonus;
        return amount;
    }

}