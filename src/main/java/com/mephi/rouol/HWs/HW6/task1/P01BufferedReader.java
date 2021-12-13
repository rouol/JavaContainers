package com.mephi.rouol.HWs.HW6.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class P01BufferedReader {
    
    public static void main(String[] args) {
        
        try{
            BufferedReader bReader = new BufferedReader(new FileReader("hamlet.txt"));
            System.out.println("=== Entire File ===");
            //print out file here
            System.out.println(bReader.lines().collect(Collectors.joining("\n")));
                        
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    } 
}
