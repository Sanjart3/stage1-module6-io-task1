package com.epam.mjc.io;

import java.io.*;
import java.util.logging.Logger;


public class FileReader {

    public static void main(String[] args) {
        File file = new File("D:\\java Praktikum\\stage1-module6-io-task1\\src\\resources\\Profile.txt");
        FileReader fr = new FileReader();
        Profile profile = fr.getDataFromFile(file);
        System.out.println(profile.toString());
    }

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))){
            String line = bufferedReader.readLine();
            while (line!=null){
                String value = line.split(":")[1];
                switch(line.split(":")[0]){
                    case "Name": profile.setName(value.trim()); break;
                    case "Age": profile.setAge(Integer.valueOf(value.trim())); break;
                    case "Email": profile.setEmail(value.trim()); break;
                    case "Phone": profile.setPhone(Long.valueOf(value.trim()));
                    default: continue;
                }
                line = bufferedReader.readLine();
            }
        }catch (IOException exception){
            Logger.getLogger(String.valueOf(exception));
        }
        return profile;
    }
}
