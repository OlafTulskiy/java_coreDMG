package com.company.lesson3DZ;

import java.util.ArrayList;

public class MainClass3 {

    //метод смены двух элементов местами
    public static void shuffleArrEl(Object[] arr, int position, boolean prev) {
        //position - переменная которая будет меняться
        // переменная prev для направления смены элемента, если
        // true - то меняемся с пред элементом иначе с последующим
        if(position <= 0 || position >= arr.length) return;//проверим что position входит в размерность масссива
        if (prev) {
            Object tmp = arr[position - 1 ];
            arr[position - 1 ] = arr[position];
            arr[position] = tmp;
        }else{
            Object tmp = arr[position + 1];
            arr[position + 1] = arr[position];
            arr[position] = tmp;
        }

    }

    public static void main(String[] args) {

        Object []arr = {1, 2, 3 , 4, 5};
        shuffleArrEl(arr, 2, true);//проверяем
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " - ");
        }

        Fruit aa = new Apple();
        Fruit bb = new Orange();
        Fruit cc = new Apple();
        Fruit dd = new Orange();
        Fruit ee = new Apple();
        ArrayList<Fruit> tmp = new ArrayList<>();
        tmp.add(aa);
        tmp.add(cc);
        tmp.add(ee);
        Box tmpBox = new Box<>(tmp);
        System.out.println(tmpBox.getWeight());







    }


}
