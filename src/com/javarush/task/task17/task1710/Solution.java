package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        String cmd = args[0];
        switch (cmd) {
            case "-c": {
                createPerson(args[1], args[2], args[3]); //-c name sex bd
                break;
            }
            case "-u": {
                updatePerson(args[1], args[2], args[3], args[4]); //-u id name sex bd
                break;
            }
            case "-d": {
                deletePerson(args[1]); //-d id
                break;
            }
            case "-i": {
                infoPerson(args[1]); //-i id
                break;
            }
        }
    }
    public static void createPerson(String name, String sex, String bd) throws ParseException {
        //-c name sex bd
        Date birthDate = new SimpleDateFormat("dd/MM/yyy").parse(bd);
        if (sex.equals("м")) {
            Person pers = Person.createMale(name, birthDate);
            allPeople.add(pers);
            System.out.println(allPeople.indexOf(pers));
        } else if (sex.equals("ж")) {
            Person pers = Person.createFemale(name, birthDate);
            allPeople.add(pers);
            System.out.println(allPeople.indexOf(pers));
        }
    }

    public static void updatePerson(String id, String name, String sex, String bd)
        throws ParseException {
        //-u id name sex bd
        Date birthDate = new SimpleDateFormat("dd/MM/yyy").parse(bd);
        allPeople.get(Integer.valueOf(id)).setName(name);
        allPeople.get(Integer.valueOf(id)).setBirthDate(birthDate);
        allPeople.get(Integer.valueOf(id)).setSex(sex.equals("м") ? Sex.MALE : Sex.FEMALE);
    }

    public static void deletePerson(String id) {
        //-d id
        Person person = allPeople.get(Integer.valueOf(id));
        person.setName(null);
        person.setSex(null);
        person.setBirthDate(null);
    }

    public static void infoPerson(String id) {
        //-i id
        //name sex (м/ж) bd (формат 15-Apr-1990)
        System.out.println(allPeople.get(Integer.valueOf(id)));
    }

}
