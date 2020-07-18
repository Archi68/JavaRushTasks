package com.javarush.task.task15.task1529;

/* 
Осваивание статического блока
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

    }

    static {
        //add your code here - добавьте код тут
        reset();
    }

    public static CanFly result;

    public static void reset() {
        //add your code here - добавьте код тут
        Scanner scan = new Scanner(System.in);
        String machineType = scan.nextLine();
        if (machineType.equals("helicopter")){
            result = new Helicopter();
        } else if (machineType.equals("plane")) {
            result = new Plane(35);
        }
    }
}
