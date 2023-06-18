package com.epam.mjc.io;

import java.io.*;


public class FileReader {
    public static void main(String[] args) {
        FileReader fr = new FileReader();
        File file = new File("D:\\java Praktikum\\stage1-module6-io-task1\\src\\main\\resources\\Profile.txt");
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
                }
                line = bufferedReader.readLine();
            }
        }catch (FileNotFoundException e){
            System.err.println(e);
        }catch (IOException e){
            System.err.println(e);
        }
        return profile;
    }
}
