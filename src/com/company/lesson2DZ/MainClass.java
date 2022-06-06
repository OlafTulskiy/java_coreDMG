package com.company.lesson2DZ;

import com.company.lesson1DZ.Course;
import com.company.lesson1DZ.Man;
import com.company.lesson1DZ.Obstacle;
import com.company.lesson1DZ.Team;

public class MainClass {

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {

        String[][] doubleArray = {
                {"34","33","56", "234"},
                {"1", "22", "2", "9"},
                {"10", "56", "33", "5"},
                {"12","7","7","33"}
        };

        TestClass tryOne = new TestClass();
        try {
            System.out.println(tryOne.summElemOfArr(doubleArray));
        }catch(MyArrayDataException e) {
            e.printStackTrace();
        }catch(MyArraySizeException e) {
            e.printStackTrace();
        }
        //System.out.println(tryOne.summElemOfArr(doubleArray));

    }
}
