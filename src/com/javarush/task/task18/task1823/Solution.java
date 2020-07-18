package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
        //создаем список имен файлов fileNamesArray
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputFileName;
        ArrayList<String> fileNamesArray = new ArrayList<>();
        while (!(inputFileName = bufferedReader.readLine()).equals("exit")) {
            fileNamesArray.add(inputFileName);
        }
        for (String fileName : fileNamesArray) {
            ReadThread thread = new ReadThread(fileName);
            thread.start();
            thread.join();
        }
        System.out.println();
        for (Map.Entry<String, Integer> pair: resultMap.entrySet()) {
            System.out.println(pair);
        }


    }

    public static class ReadThread extends Thread {
        //FileInputStream inputSR;
        String fileName;

        public ReadThread(String fileName) throws FileNotFoundException {
            //implement constructor body
            this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        public void run() {
            FileInputStream inputSR = null;
            try {
                inputSR = new FileInputStream(fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ArrayList<Integer> arrayList = new ArrayList<>();
            HashMap<Integer, Integer> map = new LinkedHashMap<>();
            while (true) //пока есть еще непрочитанные байты
            {
                try {
                    if (!(inputSR.available() > 0)) break;
                    arrayList.add(inputSR.read()); // прочитать очередной байт
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // считаем количество вхождений байтов, сохраняем в map
            for (Integer num : arrayList) {
                map.compute(num, (k, v) -> (v == null) ? 1 : v+1 );
            }
            // максимально встречающийся байт в файле
            Integer maxFileIntegerValue = Collections.max(map.values());
            Integer byteMax;
            for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
                if (pair.getValue() == maxFileIntegerValue) {
                    // если максимальных несколько, выводим всех
                    System.out.print(pair.getKey() + " " + pair.getValue() + " ");
                    byteMax = pair.getKey();
                    synchronized (resultMap) {
                        Solution.resultMap.put(fileName, byteMax);
                    }
                }
            }
            try {
                inputSR.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
