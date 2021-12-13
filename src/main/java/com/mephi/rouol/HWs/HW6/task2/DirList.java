package com.mephi.rouol.HWs.HW6.task2;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DirList {
  public static void main(String[] args) {

    try{ // Add Try with resources here

        System.out.println("\n=== Dir list ===");
        // Print directory list here
        System.out.println(Stream.of(Objects.requireNonNull(new File(System.getProperty("user.dir")).listFiles()))
//                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toSet()));

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
