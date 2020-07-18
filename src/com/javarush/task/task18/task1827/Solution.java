package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length != 0 && args[0].equals("-c")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fName = reader.readLine();
            FileInputStream fis = new FileInputStream(fName);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            ArrayList<String> data = new ArrayList<>();
            ArrayList<Integer> dataId = new ArrayList<>();
            Integer intID = 0;
            while (true) {
                String sData;
                if ((sData = br.readLine()) == null) {
                    break; // конец файла
                } else {
                    dataId.add(Integer.valueOf(sData.substring(0, 8).trim()));
                    data.add(sData);
                }
            }
            br.close();
            fis.close();

            String Id;
            if (data.size() != 0) {
                intID = Collections.max(dataId) + 1; // следующий айди
                Id = (Integer.toString(intID) + "       ").substring(0, 8);
            } else {
                Id = "1       ";
            }

            FileOutputStream fos = new FileOutputStream(fName, true);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            for (int i = args[1].length(); i < 30; i++) { args[1] += " "; }
            for (int i = args[2].length(); i < 8; i++) { args[2] += " "; }
            for (int i = args[3].length(); i < 4; i++) { args[3] += " "; }
            String ws = (data.size() != 0) ? "\n" : ""; // если файл пустой, то символ новой строки не нужен
            bw.write( ws + Id + args[1] + args[2] + args[3]);
            bw.close();
        } else {
            System.out.println("Something wrong with program parameters!!!");
        }
    }
}
