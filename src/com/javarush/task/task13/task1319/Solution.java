package com.javarush.task.task13.task1319;

/* 
Писатель в файл с консоли
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
         try {
             Scanner scanner = new Scanner(System.in);
             BufferedWriter bufWriter = new BufferedWriter(
                     new FileWriter(
                             new File(scanner.nextLine())));
             String line = scanner.nextLine();
             while (true) {
                 if (line.equals("exit")) {
                     bufWriter.write(line + "\n");
                     break;
                 }
                 bufWriter.write(line + "\n");
                 line = scanner.nextLine();
             }
             bufWriter.flush();
             bufWriter.close();
         } catch (FileNotFoundException e) {
            e.printStackTrace();
         } catch (IOException e) {
            e.printStackTrace();
         }
    }
}
