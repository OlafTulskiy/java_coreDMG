package com.company.lesson2DZ;

public class TestClass {

    public int summElemOfArr (String [][]arr) throws MyArraySizeException, MyArrayDataException{
        int summ = 0;
        if (arr.length != 4 || arr[0].length != 4 )
            throw new MyArraySizeException("Size of array did not 4 x 4!");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                String tmp = arr[i][j];
                if(!isNumber(tmp))
                    throw new MyArrayDataException("This not a number", i+1, j+1);
                summ += Integer.parseInt(arr[i][j]);
            }
        }

        return summ;
    }

    public boolean isNumber(String str) {
        if(str == null || str.isEmpty()) return false;
        for(int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) return false;
        }
        return  true;
    }


}
