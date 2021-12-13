package com.mephi.rouol.HWs.HW6.task2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DirWalk {
  public static void main(String[] args) {

    try{// Add try with resources here

        System.out.println("\n=== Dir walk ===");
        // Print directory list here
        System.out.println(Stream.of(Objects.requireNonNull(new File(System.getProperty("user.dir")).listFiles()))
              .filter(File::isDirectory)
              .map(File::getName)
              .collect(Collectors.toSet()));

    } catch (Exception e) {
      e.printStackTrace();
    }

    try(Stream<Path> files = Files.walk(Paths.get("."))){

        System.out.println("\n=== Dir build ===");
        files
            .filter(path -> path.toString().contains("build"))
            .forEach(System.out::println);

    }catch (IOException e){
        System.out.println("Error: " + e.getMessage());
    }

  } 
}
