package com.company.lesson3DZ;

import java.util.ArrayList;

public class Box <T extends  Fruit> {
    private ArrayList<T> boxer;

    public Box(ArrayList<T> boxer) {
        this.boxer = boxer;
    }

    public double getWeight() { //"добываем" вес коробки
        double tmp = 0;
        for (T oneFruit: boxer ) {
            tmp += oneFruit.getWeigth();
        }
        return  tmp;
    }

    public boolean compareBox(Box<? extends Fruit> tmpBox){ //сравниваем вес коробки с эталонной
        return (this.getWeight() == tmpBox.getWeight());
    }

    public void addFruit (T fruitOne) {//добавляем фрукт в коробку
        boxer.add(fruitOne);
    }

    public void toBoxArray (Box<T> tmpBox) {//пересыпаем из одной коробки в другую
        for (T t: tmpBox.getBoxer()) {
            this.getBoxer().add(t);
        }
        tmpBox.getBoxer().clear();
    }

    public ArrayList<T> getBoxer() {
        return boxer;
    }
}
