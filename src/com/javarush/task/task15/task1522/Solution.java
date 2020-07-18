package com.javarush.task.task15.task1522;

/* 
Закрепляем паттерн Singleton
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        // implement step #5 here - реализуйте задание №5 тут
        Scanner scanner = new Scanner(System.in);
        String planet = scanner.nextLine();
        if (planet.equals(Planet.EARTH)){
            thePlanet = Earth.getInstance();
        } else if (planet.equals(Planet.MOON)){
            thePlanet = Moon.getInstance();
        } else if (planet.equals(Planet.SUN)){
            thePlanet = Sun.getInstance();
        } else {
            thePlanet = null;
        }
        scanner.close();
    }
}
