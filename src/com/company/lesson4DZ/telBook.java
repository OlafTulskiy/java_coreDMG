package com.company.lesson4DZ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class telBook {

    ArrayList<oneNote> tlbook = new ArrayList<>();

    telBook() {
    }

    telBook(Integer number, String lastname) {
        tlbook.add(new oneNote(lastname,number));
    }

    public void add (Integer number, String lastname) {
        tlbook.add(new oneNote(lastname,number));
    }

    public void add(oneNote _onenote) {
        tlbook.add(_onenote);
    }

    public ArrayList<oneNote> get (String lastname) {
        ArrayList<oneNote> tmp = new ArrayList<>();
        for (oneNote aa : tlbook) {   
            if (lastname == aa.getLastname())
                tmp.add(aa);
        }

        return tmp;
    }

}
