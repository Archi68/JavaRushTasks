package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        ArrayList<Integer> arrayList = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (inputStream.available() > 0) //пока есть еще непрочитанные байты
        {
            arrayList.add(inputStream.read()); // прочитать очередной байт в переменную data
        }
        for (Integer num : arrayList) {
            map.compute(num, (k, v) -> (v == null) ? 1 : v+1 );
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            System.out.print( (char) entry.getKey().byteValue() + " " + entry.getValue() + "\n");
        }
        inputStream.close();
    }
}
