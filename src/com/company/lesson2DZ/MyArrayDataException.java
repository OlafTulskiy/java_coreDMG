package com.company.lesson2DZ;

public class MyArrayDataException extends Exception{

    public MyArrayDataException (String error, int rows, int column){
        super(error + "Wrong data in - "+ rows + " row and "+ column + " column");
    }
}
