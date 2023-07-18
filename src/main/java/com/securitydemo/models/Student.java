package com.securitydemo.models;

public class Student {
    private String name;
    private int roll;
    private int standard;

    public Student() {
    }

    public Student(String name, int roll, int standard) {
        this.name = name;
        this.roll = roll;
        this.standard = standard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public int getStandard() {
        return standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }
}
