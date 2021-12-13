package com.mephi.rouol.HWs.HW6.task2;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DirFind {
    
    public static void main(String[] args) {

        try{ // Add try with resources
            
            System.out.println("\n=== Find all dirs ===");
            // Print out directory list here
            System.out.println(Stream.of(Objects.requireNonNull(new File(System.getProperty("user.dir")).listFiles()))
                    .filter(file -> file.isDirectory())
                    .map(File::getName)
                    .collect(Collectors.toSet()));
        }catch (Exception ignored) {
        }

    } 
}
