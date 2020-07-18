package com.javarush.task.task16.task1632;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    public static class Thread1 implements Runnable {
        public void run(){
            while (true);
        }
    }
    public static class Thread2 implements Runnable {
        public void run(){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }
    public static class Thread3 implements Runnable {
        public void run(){
            try {
                while (true) {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {}
        }
    }

    public static class Thread4 extends Thread implements Message {
/*        @Override
        public void showWarning() {
            interrupt();
        }

        @Override
        public void run() {
            while (!isInterrupted()){
                showWarning();
            }
        }
 */
        boolean repeat = true;

        @Override
        public void showWarning() {
            repeat = false;
        }

        @Override
        public void run() {
            while (repeat);
        }

    }

    public static class Thread5 implements Runnable {
        public void run(){
            try {
                Scanner read = new Scanner(System.in);
                String s;
                int sum = 0;
                while (!(s = read.nextLine()).equals("N")) {
                    sum += Integer.valueOf(s);
                }
                System.out.println(sum);
                read.close();
            } catch (Exception e) {}
        }
    }

    static {
        threads.add(new Thread(new Thread1()));
        threads.add(new Thread(new Thread2()));
        threads.add(new Thread(new Thread3()));
        threads.add(new Thread4());
        threads.add(new Thread(new Thread5()));
    }

    public static void main(String[] args) {
    }
}