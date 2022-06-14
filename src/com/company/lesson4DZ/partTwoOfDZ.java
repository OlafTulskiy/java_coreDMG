package com.company.lesson4DZ;

public class partTwoOfDZ {

    public static void main(String[] args) {

        telBook testBook = new telBook();
        testBook.add(111111, "Ivanov");
        testBook.add(222222, "Petrov");
        testBook.add(333333, "Sidorov");
        testBook.add(444444, "Gusev");
        testBook.add(555555, "Ivanov");
        testBook.add(666666, "Kozlov");
        testBook.add(777777, "Ivanov");
        testBook.add(888888, "Petrov");


        for (oneNote tmp : testBook.get("Ivanov")) {//проверяем то, что наделали
            System.out.println("Last name - " + tmp.getLastname() +
                    " has number - " + tmp.getNumber());
        }


    }
}
