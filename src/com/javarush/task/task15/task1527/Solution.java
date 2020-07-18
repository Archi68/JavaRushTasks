package com.javarush.task.task15.task1527;

/* 
Парсер реквестов
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //считываем с клавы строку
        URL myURL = new URL(reader.readLine()); // делаем из нее URL
        //URL myURL = new URL("http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo"); // делаем из нее URL

        String[] params = myURL.getQuery().split("&"); //загоняем в массив все, что после "?" и между "&"
        Map<String, String> mapPairs = new LinkedHashMap<>();
        for (int i = 0; i < params.length; i++){
            String[] pairsValue = params[i].split("=");
            if (pairsValue.length > 1) {
                mapPairs.put(pairsValue[0], pairsValue[1]);
            } else{
                mapPairs.put(pairsValue[0], null);
            }
        }
        //вывести на экран спиок всех параметров
        int i = 0;
        for (Map.Entry<String, String> param : mapPairs.entrySet()) {
            System.out.print(param.getKey()); // выводим имя параметра
            i++;
            if ((mapPairs.size() > 1) && i != mapPairs.size()){
                System.out.print(" ");
            }
        }
        System.out.println();

        //проверяем obj
        for (Map.Entry<String, String> pair : mapPairs.entrySet() ) {
            try {
                if (pair.getKey().equals("obj")){
                    if (pair.getValue().matches("-?\\d+(\\.\\d+)?")) {// представление числа
                        alert(Double.parseDouble(pair.getValue()));
                    } else
                        alert(pair.getValue());
                }
            }
            catch (NumberFormatException ex) {
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
