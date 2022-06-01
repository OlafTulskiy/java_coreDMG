package com.company.lesson1DZ;

public class Man {
    private String name;
    private int age;
    private int powerOfMan;//некая величина для полосы препятствий
    private boolean isCourseDone = true;

    public Man(String _name, int _age) {
        this.name = _name;
        this.age = _age;
        if (_age > 10 && _age < 15) {
            this.powerOfMan = 15;
        }
        if (_age >= 15 && _age <= 25) {
            this.powerOfMan = 35;
        }
        if (_age > 25 && _age <= 35) {
            this.powerOfMan = 25;
        }
        if (_age > 35 && _age < 50) {
            this.powerOfMan = 15;
        }//все весьма условно)))
    }

    String getName() {
        return this.name;
    }
    int getAge() {
        return this.age;
    }
    int getPowerOfMan() {
        return this.powerOfMan;
    }
    boolean getIsCourseDone() {
        return this.isCourseDone;
    }

    public void setCourseDone(boolean courseDone) {
        isCourseDone = courseDone;
    }
}
