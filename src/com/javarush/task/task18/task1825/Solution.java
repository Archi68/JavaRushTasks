package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputFileName;
        ArrayList<String> fileParts = new ArrayList<>();
        int partNo = 0;
        while (!(inputFileName = bufferedReader.readLine()).equals("end")) {
            fileParts.add(inputFileName);
        }
        Collections.sort(fileParts);

        String[] fName = fileParts.get(0).split(".part");
        //String fName = fileParts.get(0).substring(0, fileParts.get(0).lastIndexOf("."));

        FileOutputStream fos = null;
        for (int i = 0; i < fileParts.size(); i++) {
            if (i == 0) {
                if (fos != null) fos.close();
                fos = new FileOutputStream(fName[0]);
            } else {
                if (fos != null) fos.close();
                fos = new FileOutputStream(fName[0], true);
            }
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(fileParts.get(i));
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                fos.write(buffer);
            } catch (FileNotFoundException e) {
                System.out.println(inputFileName);
                break;
            }
            try {
                if (fis!=null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (fos!=null) fos.close();
    }
}
