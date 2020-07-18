package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputFileName;
        while (!(inputFileName = bufferedReader.readLine()).equals("exit")) {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(inputFileName);
            } catch (FileNotFoundException e) {
                System.out.println(inputFileName);
                //System.out.println(e);
                break;
            } finally {
                try {
                    if (fis != null)
                        fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
