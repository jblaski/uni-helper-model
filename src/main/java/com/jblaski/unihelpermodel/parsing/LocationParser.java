package com.jblaski.unihelpermodel.parsing;

import com.jblaski.unihelpermodel.model.CourseLocation;
import com.jblaski.unihelpermodel.model.Location;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class LocationParser {

    public static String expectedHeaders = "UKPRN,ACCOMURL,ACCOMURLW,LOCID,LOCNAME,LOCNAMEW,LATITUDE,LONGITUDE,LOCUKPRN,LOCCOUNTRY,SUURL,SUURLW";

    public static Location parseLine(String line) {
        String[] fields = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1); // handles commas enclosed in quotes
        return Location.builder()
                .UKPRN(fields[0])
                .ACCOMURL(fields[1])
                .ACCOMURLW(fields[2])
                .LOCID(fields[3])
                .LOCNAME(fields[4])
                .LOCNAMEW(fields[5])
                .LATITUDE(fields[6])
                .LONGITUDE(fields[7])
                .LOCUKPRN(fields[8])
                .LOCCOUNTRY(fields[9])
                .SUURL(fields[10])
                .SUURLW(fields[11])
                .build();
    }

    public static List<Location> readAllFromFile(String filepath) {
        validateHeaders(filepath);
        List<String> lines = ParseUtils.readLinesFromFile(filepath, true);
        return lines.stream()
                    .map(LocationParser::parseLine)
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
