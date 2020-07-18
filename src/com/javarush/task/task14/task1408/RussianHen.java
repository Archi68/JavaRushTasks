package com.javarush.task.task14.task1408;

import static com.javarush.task.task14.task1408.Country.RUSSIA;

public class RussianHen extends Hen {
    public int getCountOfEggsPerMonth() {
        return 20;
    }

    String getDescription() {
        return super.getDescription() + " Моя страна - " + RUSSIA + ". Я несу " +
                getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
