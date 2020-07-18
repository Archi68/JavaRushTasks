package com.javarush.task.task15.task1530;

/* 
Template pattern
*/

public class Solution {
    public static void main(String[] args) {
        LatteMaker cofe = new LatteMaker();
        cofe.makeDrink();
        TeaMaker tea = new TeaMaker();
        tea.makeDrink();
    }
}
