package com.javarush.task.task18.task1804;

/* 
Самые редкие байты
*/

import java.io.FileInputStream;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        FileInputStream inputStream = new FileInputStream(scanner.nextLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        while (inputStream.available() > 0) //пока есть еще непрочитанные байты
        {
            arrayList.add(inputStream.read()); // прочитать очередной байт в переменную data
        }
        for (Integer num : arrayList) {
            //if (!map.containsKey(num))
                map.compute(num, (k, v) -> (v == null) ? 1 : v+1 );
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue()==1) {
                System.out.print(entry.getKey() + " ");
            }
        }
        //System.out.println(map.);
        inputStream.close();
    }
}
