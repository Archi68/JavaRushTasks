package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[1]);
        FileOutputStream fos = new FileOutputStream(args[2]);
        switch (args[0]) {
            case "-e": {
                while (fis.available() > 0) {
                    fos.write(fis.read() ^ 1);
                }
                break;
            }
            case "-d": {
                while (fis.available() > 0) {
                    fos.write(fis.read() ^ 1);
                }
                break;
            }
        }
        fis.close();
        fos.close();
    }
}
