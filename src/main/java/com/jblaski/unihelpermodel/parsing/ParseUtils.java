package com.jblaski.unihelpermodel.parsing;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
public class ParseUtils {

    public static List<String> readLinesFromFile(String fileName, boolean ignoreHeaders) {
        List<String> lines = new LinkedList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(lines::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (ignoreHeaders) ? lines.subList(1, lines.size()) : lines;
    }

    public static String readHeaders(String fileName) {
        List<String> lines = readLinesFromFile(fileName, false); // inefficient, no need to read all the lines!
        String headers = "";
        try {
            headers = lines.get(0);
        } catch (IndexOutOfBoundsException e) {
            log.error("Couldn't get headers for file " + fileName);
        }
        return headers;
    }
}
