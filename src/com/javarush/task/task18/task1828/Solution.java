package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length != 0) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fName = reader.readLine();
            FileInputStream fis = new FileInputStream(fName);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            ArrayList<String> data = new ArrayList<>();
            int ind = 0;
            int i = 0;
            while (true) {
                String sData;
                if ((sData = br.readLine()) == null) {
                    break; // конец файла
                } else {
                    if (sData.substring(0, 8).trim().equals(args[1].trim())) {
                        ind = i;
                    }
                    data.add(sData);
                }
                i++;
            }
            br.close();
            fis.close();

            switch (args[0]) {
                case "-u": {
                    //-u id productName price quantity
                    for (int j = args[1].length(); j < 8; j++) { args[1] += " "; }
                    for (int j = args[2].length(); j < 30; j++) { args[2] += " "; }
                    for (int j = args[3].length(); j < 8; j++) { args[3] += " "; }
                    for (int j = args[4].length(); j < 4; j++) { args[4] += " "; }
                    data.set(ind, args[1] + args[2] + args[3] + args[4]);
                    break;
                }
                case "-d": {
                    // -d id
                    data.remove(ind);
                }
            }

            FileOutputStream fos = new FileOutputStream(fName);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            int count = data.size();
            for (int j = 0; j < count; j++) {
                bw.write(data.get(j).concat((j == (count - 1)) ? "" : "\n"));
            }
            bw.close();
            fos.close();
        } else {
            System.out.println("Something wrong with program parameters!!!");
        }
    }
}
