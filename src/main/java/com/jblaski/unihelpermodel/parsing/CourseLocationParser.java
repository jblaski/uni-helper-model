package com.jblaski.unihelpermodel.parsing;

import com.jblaski.unihelpermodel.model.CourseLocation;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class CourseLocationParser {

    public static String expectedHeaders = "PUBUKPRN,UKPRN,KISCOURSEID,KISMODE,LOCID";

    public static CourseLocation parseLine(String line) {
        String[] fields = line.split(",");
        return CourseLocation.builder()
                .PUBUKPRN(fields[0])
                .UKPRN(fields[1])
                .KISCOURSEID(fields[2])
                .KISMODE(fields[3])
                .LOCID(fields[4])
                .build();
    }

    public static List<CourseLocation> readAllFromFile(String filepath) {
        validateHeaders(filepath);
        List<String> lines = ParseUtils.readLinesFromFile(filepath, true);
        return lines.stream()
                    .map(CourseLocationParser::parseLine)
                    .collect(Collectors.toList());
    }

    public static void validateHeaders(String filepath) {
        String actualHeaders = ParseUtils.readHeaders(filepath);
        if (!actualHeaders.equals(expectedHeaders)) {
            log.error("Error: expected file [" + filepath + "] to have headers of [" + expectedHeaders + "], but found [" + actualHeaders + "]");
        } else {
            log.info("Expected headers were found for file " + filepath);
        }
    }


}
