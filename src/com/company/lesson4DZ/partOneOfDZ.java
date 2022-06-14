package com.company.lesson4DZ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class partOneOfDZ {

    public static void main(String[] args) {
        ArrayList<String> manyWords = new ArrayList<>();
        manyWords.add("Cat");
        manyWords.add("Dog");
        manyWords.add("Forest");
        manyWords.add("Five");
        manyWords.add("Ninja");
        manyWords.add("Cat");
        manyWords.add("Five");
        manyWords.add("Man");
        manyWords.add("Hive");
        manyWords.add("Car");

        HashSet<String> uniqWords = new HashSet<>();

        for (String oneWord: manyWords) {//ищем уникальные слова
            uniqWords.add(oneWord);

        }

        for (String oneWord: uniqWords) {//и выводим
            System.out.println(oneWord);

        }

        HashMap<String,Integer> hashMapWords = new HashMap<String, Integer>();

        for (String oneWord: manyWords) {//ищем слова и повторения считаем
            Integer counter = 1;
            for (String anotherWord: hashMapWords.keySet()) {
                if(oneWord == anotherWord)
                    counter++;
            }
            hashMapWords.put(oneWord, counter);
        }

        for(Map.Entry<String,Integer> tmp : hashMapWords.entrySet()) {
            System.out.println("Word - " + tmp.getKey() + " : repeat - " + tmp.getValue());
        }

    }
}
