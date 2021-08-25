package ru.mail.skorobogatov.www.functionality;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class DocReader {

    public String readFile(String path) throws FileNotFoundException {
        File file = new File(path); 
        Scanner sc = new Scanner(file); 
  
        sc.useDelimiter("\\Z"); 
  
        String str = sc.next();
        sc.close();
        
        return str; 
    }
}