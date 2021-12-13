package com.mephi.rouol.HWs.HW6.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class P02NioRead {
    
    public static void main(String[] args) {

        Path file =  Paths.get("hamlet.txt");

        try{ // Create Try with Resources here
            System.out.println("\n=== Entire File ===");
            // print lines here
            Files.lines(file).forEach(System.out::println);

        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

    } 
}
