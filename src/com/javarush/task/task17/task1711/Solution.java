package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        //String cmd = args[0];
        switch (args[0]) {
            case "-c": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length - 2; i += 3) {
                        createPerson(args[i], args[i + 1], args[i + 2]); //-c name sex bd
                        //System.out.println(createPerson(args[i], args[i + 1], args[i + 2]));
                    }
                }
                break;
            }
            case "-u": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length - 3; i += 4) {
                        updatePerson(args[i], args[i + 1], args[i + 2], args[i + 3]); //-u id name sex bd
                    }
                }
                break;
            }
            case "-d": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        deletePerson(args[i]); //-d id
                    }
                }
                break;
            }
            case "-i": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        infoPerson(args[i]); //-i id
                    }
                }
                break;
            }
            default:
                synchronized (allPeople) {
                    System.out.println("Use keys: -i -d -c -u");
                }
        }
    }

    public static Person createPerson(String name, String sex, String bd) throws ParseException {
        //-c name sex bd
        Date birthDate = new SimpleDateFormat("dd/MM/yyy").parse(bd);
        Person pers = null;
        if (sex.equals("м")) {
            pers = Person.createMale(name, birthDate);
            allPeople.add(pers);
            System.out.println(allPeople.indexOf(pers));
        } else if (sex.equals("ж")) {
            pers = Person.createFemale(name, birthDate);
            allPeople.add(pers);
            System.out.println(allPeople.indexOf(pers));
        }
        return pers;
    }

    public static void updatePerson(String id, String name, String s, String bd)
            throws ParseException {
        //-u id name sex bd
        Date birthDate = new SimpleDateFormat("dd/MM/yyy").parse(bd);
        allPeople.get(Integer.valueOf(id)).setName(name);
        allPeople.get(Integer.valueOf(id)).setBirthDate(birthDate);
        allPeople.get(Integer.valueOf(id)).setSex(s.equals("м") ? Sex.MALE : Sex.FEMALE);
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

