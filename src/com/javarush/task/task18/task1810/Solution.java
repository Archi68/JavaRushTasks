package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException, DownloadException {
        Scanner scanner = new Scanner(System.in);
        FileInputStream file;// = new FileInputStream(scanner.nextLine());
        int fSize = 0; //file.available();
        while (true) {
            file = new FileInputStream(scanner.nextLine());
            fSize = file.available();
            if (fSize < 1000) {
                file.close();
                throw new DownloadException();
            }
        }

    }

    public static class DownloadException extends Exception {

    }
}
