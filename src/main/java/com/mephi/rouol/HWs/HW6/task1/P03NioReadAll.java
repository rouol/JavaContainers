package com.mephi.rouol.HWs.HW6.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class P03NioReadAll {
    
    public static void main(String[] args) {
        
        List<String> fileArr;
        Path file =  Paths.get("hamlet.txt");

        try{
            // Read file into array here
            fileArr = Files.readAllLines(file);
            
            System.out.println("\n=== Rosencrantz ===");
            // Filter for Ros. here
            Boolean check = false;
            for (String line: fileArr) {
                if (line.contains("Ros.")) {
                    check = true;
                    System.out.println(line);
                } else if (
                        check&
                        !line.contains("Pol.")&
                        !line.contains("Ham.")&
                        !line.contains("Guil.")&
                        !line.contains("Exit [")) {
                    System.out.println(line);
                } else {
                    check = false;
                }
            }
            fileArr.stream().filter(line -> line.contains("Ros.")).forEach(System.out::println);
            
            System.out.println("\n=== Guildenstern ===");
            // Filter for Guil. here
            check = false;
            for (String line: fileArr) {
                if (line.contains("Guil.")) {
                    check = true;
                    System.out.println(line);
                } else if (
                        check&
                                !line.contains("Pol.")&
                                !line.contains("Ham.")&
                                !line.contains("Ros.")&
                                !line.contains("Exit [")) {
                    System.out.println(line);
                } else {
                    check = false;
                }
            }
            

        }catch (IOException e){
          System.out.println("Error: " + e.getMessage());
        }

    } 
}
