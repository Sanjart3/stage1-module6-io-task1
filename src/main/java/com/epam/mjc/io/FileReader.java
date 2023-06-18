package com.epam.mjc.io;

import java.io.*;
import java.util.logging.Logger;

public class FileReader {
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
                    case "Phone": profile.setPhone(Long.valueOf(value.trim())); break;
                    default: line=null;
                }
                line = bufferedReader.readLine();
            }
        }catch (IOException exception){
            Logger.getLogger(String.valueOf(exception));
        }
        return profile;
    }
}
