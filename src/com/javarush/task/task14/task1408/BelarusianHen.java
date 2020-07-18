package com.javarush.task.task14.task1408;

import static com.javarush.task.task14.task1408.Country.BELARUS;

public class BelarusianHen extends Hen {
    public int getCountOfEggsPerMonth() {
        return 24;
    }

    public String getDescription() {
        return super.getDescription() + " Моя страна - " + BELARUS + ". Я несу " +
                getCountOfEggsPerMonth() + " яиц в месяц.";
    }

}
