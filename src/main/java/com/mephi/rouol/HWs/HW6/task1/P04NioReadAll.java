package com.mephi.rouol.HWs.HW6.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class P04NioReadAll {
  public static void main(String[] args) {
        
    Path file =  Paths.get("hamlet.txt");
    List<String> fileArr;

    try{
        // Read fileinto array here
        fileArr = Files.readAllLines(file);

        System.out.println("\n=== Lord Count ===");
        long wordCount = 0; // Replace with your pipeline
        wordCount = fileArr.stream().mapToInt(s ->
          s.split("lord", -1).length-1 +
          s.split("Lord", -1).length-1
        ).sum();

        System.out.println("Word count: " + wordCount);

        System.out.println("\n=== Prison Count ===");
        wordCount = 0; // Replace with your pipeline
        wordCount = fileArr.stream().mapToInt(s ->
          s.split("prison", -1).length-1 +
          s.split("Prison", -1).length-1
        ).sum();

        System.out.println("Word count: " + wordCount);

    }catch (IOException e){
        System.out.println("Error: " + e.getMessage());
    }

  }
}
