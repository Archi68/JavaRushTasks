package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        // напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(scanner.nextLine())));
        ArrayList<Integer> numAL = new ArrayList<>();

        try {
            String strNum = bufferedReader.readLine();
            while (strNum != null) {
                numAL.add(Integer.parseInt(strNum));
                strNum = bufferedReader.readLine();
            }
            bufferedReader.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(numAL);
        for (Integer num : numAL) {
            if ((num % 2) == 0){
                System.out.println(num);
            }
        }


    }
}
