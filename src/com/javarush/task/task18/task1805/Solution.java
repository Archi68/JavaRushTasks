package com.javarush.task.task18.task1805;

/* 
Сортировка байт
*/

import java.io.FileInputStream;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        FileInputStream inputStream = new FileInputStream(scanner.nextLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        while (inputStream.available() > 0) //пока есть еще непрочитанные байты
        {
            arrayList.add(inputStream.read()); // прочитать очередной байт в переменную data
        }
        for (Integer num : arrayList) {
            set.add(num);
        }
        List<Integer> list = new ArrayList<Integer>(set);
        Collections.sort(list, (i1, i2) -> {
            return i1 - i2;
        });
        for (Integer num : list) {
            System.out.print(num + " ");
        }

        //System.out.println(map.);
        inputStream.close();
    }
}
