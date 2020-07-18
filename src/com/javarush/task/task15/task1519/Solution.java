package com.javarush.task.task15.task1519;

import java.io.IOException;
import java.util.Scanner;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        Scanner scanner = new Scanner(System.in);
        String strVal = null;
        Integer IntegerValue = 0;
        boolean isInt;
        while (!(strVal = scanner.nextLine()).equals("exit")) {
            try {
                if (strVal.matches("-?\\d+(\\.\\d+)?")) {// strVal есть представление числа
                    if (strVal.contains(".")) {
                        print(Double.parseDouble(strVal));
                    } else if ((IntegerValue = Integer.valueOf(strVal)) > 0 && IntegerValue < 128) {
                            print(IntegerValue.shortValue());
                        } else if (IntegerValue<=0 || IntegerValue >= 128) {
                            print(IntegerValue);
                        }
                } else {
                    print(strVal);
                }
            }
            catch (NumberFormatException ex){}
            catch (Exception ex) {
                System.out.println(ex);
            }
        }
        scanner.close();
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
