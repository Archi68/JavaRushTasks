package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        //вводим два имени файла с консоли
        //заполняем allLines и forRemoveLines
        //File file4seek = new File("/Users/moisej/Downloads/первый.txt");
        //File file4del = new File("/Users/moisej/Downloads/второй.txt");
        Scanner scanner = new Scanner(System.in);
        FileReader read = new FileReader(scanner.nextLine());
        FileReader del = new FileReader(scanner.nextLine());
        BufferedReader firstFile = new BufferedReader(read);
        BufferedReader secondFile = new BufferedReader(del);
        try {
            //File file4seek = new File(scanner.nextLine());
            //File file4del = new File(scanner.nextLine());
            ///Users/moisej/Downloads/первый.txt
            String line;
            while ((line = firstFile.readLine()) != null) {
                    allLines.add(line);
            }
            ///Users/moisej/Downloads/второй.txt
            while ((line = secondFile.readLine()) != null) {
                forRemoveLines.add(line);
            }
            Solution solution = new Solution();
            solution.joinData();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            firstFile.close();
            secondFile.close();
        }


    }

    public void joinData() throws CorruptedDataException {
        //удалить в списке allLines все строки из списка forRemoveLines,
        //for (String line : forRemoveLines) {
        //    if (allLines.contains(line)) {
        //        allLines.remove(line);
        //    }
       // }
        if (allLines.containsAll(forRemoveLines)) {
            //если в allLines содержаться все строки из списка forRemoveLines
            allLines.removeAll(forRemoveLines);
        } else {
            //если в allLines не содержаться все строки из списка forRemoveLines.
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}

