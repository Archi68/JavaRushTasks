package com.javarush.task.task13.task1318;

/* 
Чтение файла
*/


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        try (BufferedReader fileReader = new BufferedReader(
                new InputStreamReader(
                        fileInputStream)))
        {
            String line;
            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // log error
            System.out.println(e);
        }

        fileInputStream.close();
    }
}