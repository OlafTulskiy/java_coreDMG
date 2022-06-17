package com.company.lesson5DZ;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StartClass {
    public static ArrayList<DataObject> dataList = new ArrayList<>();
    public static String pathFile = "C:\\Users\\m.dvoryankin\\IdeaProjects\\Java Core DMG\\src\\com\\company\\lesson5DZ\\tmp.csv";
    public static String title = "value1" + ";" + "value2" + ";" +
            "value3" + ";" + System.getProperty("line.separator");



    public static void main(String[] args) throws IOException {
        createObjectForFile();
        writeToFile();
        AppData apData = readFromFile();

        for ( int i = 0; i < apData.getHeader().length; i++) {
            System.out.print(apData.getHeader()[i] + " ");
        }

        System.out.println(" ");

        for ( int i = 0; i < apData.getData().length; i++) {
            for ( int j = 0; j < apData.getData()[i].length; j++) {
                System.out.print(apData.getData()[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    private static AppData readFromFile() throws IOException{
        AppData appData = new AppData();
        List<List<String>> rc = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
            String line = br.readLine();
            appData.setHeader(line.split(";"));
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                rc.add(Arrays.asList(values));
            }
        };

        int[][] resultArr = new int [rc.size()][3];

        for (int i = 0; i < rc.size(); i++) {
            for (int j = 0; j < rc.get(i).size(); j++) {
                resultArr[i][j] = Integer.valueOf(rc.get(i).get(j));
            }
        }

        appData.setData(resultArr);

        return appData;
    }

    private static void writeToFile() throws IOException{
        try (FileOutputStream flOutputStr = new FileOutputStream(pathFile)){
            for(byte aa: title.getBytes(StandardCharsets.UTF_8)) {
                flOutputStr.write(aa);
            }
            for(DataObject dataObject: dataList) {
                String raw = dataObject.getValueOne() + ";" + dataObject.getValueTwo() +
                        ";" + dataObject.getValueThree() + ";" +
                        System.getProperty("line.separator");
                for(byte bb :raw.getBytes(StandardCharsets.UTF_8)) {
                    flOutputStr.write(bb);
                }
            }
        }
    }

    private static void createObjectForFile() {
        Random rnd = new Random();

        for (int i = 0; i < 100; i++ ) {
            dataList.add(new DataObject(i, rnd.nextInt(100), rnd.nextInt(100)));
        }
    }
}
