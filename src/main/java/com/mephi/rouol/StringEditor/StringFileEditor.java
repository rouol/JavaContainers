package com.mephi.rouol.StringEditor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class StringFileEditor {

    private final String filename;

    public StringFileEditor(String filename) {
        this.filename = filename;
    }

    public int countOccurrences(String string) {
        Path path = Paths.get(this.filename);
        try (Stream<String> lineStream = Files.lines(path)) {
            return lineStream.mapToInt((s) -> s.split(string, -1).length-1).sum();
        } catch (IOException e) {
            return 0;
        }
    }

    public int findString(String string) {
        File file = new File(this.filename);
        try {
            final Scanner scanner = new Scanner(file);
            int stringNumber = 1;
            while (scanner.hasNextLine()) {
                final String lineFromFile = scanner.nextLine();
                if(lineFromFile.contains(string)) {
                    return stringNumber;
                }
                stringNumber++;
            }
        } catch(FileNotFoundException e) {
            return 0;
        }
        return 0;
    }

    public int findInputString() {
        // read string from console
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String string = scanner.nextLine();
        scanner.close();
        // find string in file
        return this.findString(string);
    }

}
