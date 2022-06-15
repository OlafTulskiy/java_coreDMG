package com.company.lesson5DZ;

public class DataObject {
    private Integer valueOne;
    private Integer valueTwo;
    private Integer valueThree;

    public DataObject(Integer valueOne, Integer valueTwo, Integer valueThree) {
        this.valueOne = valueOne;
        this.valueTwo = valueTwo;
        this.valueThree = valueThree;
    }

    public Integer getValueOne() {
        return valueOne;
    }

    public Integer getValueTwo() {
        return valueTwo;
    }

    public Integer getValueThree() {
        return valueThree;
    }
}
