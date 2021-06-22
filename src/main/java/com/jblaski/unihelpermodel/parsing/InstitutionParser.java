package com.jblaski.unihelpermodel.parsing;

import com.jblaski.unihelpermodel.model.Institution;
import com.jblaski.unihelpermodel.model.Location;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class InstitutionParser {

    public static String expectedHeaders = "PUBUKPRN,UKPRN,COUNTRY,PUBUKPRNCOUNTRY,TEFOutcome,APROutcome,SUURL,SUURLW";

    public static Institution parseLine(String line) {
        String[] fields = line.split(",");

        // the final field is not mandatory, so we may need to pad
        int requiredNumberOfFields = expectedHeaders.length();
        if (fields.length < requiredNumberOfFields) {
            fields = Arrays.copyOf(fields, requiredNumberOfFields);
        }

        return Institution.builder()
                .PUBUKPRN(fields[0])
                .UKPRN(fields[1])
                .COUNTRY(fields[2])
                .PUBUKPRNCOUNTRY(fields[3])
                .TEFOutcome(fields[4])
                .APROutcome(fields[5])
                .SUURL(fields[6])
                .SUURLW(fields[7])
                .build();
    }

    public static List<Institution> readAllFromFile(String filepath) {
        validateHeaders(filepath);
        List<String> lines = ParseUtils.readLinesFromFile(filepath, true);
        return lines.stream()
                    .map(InstitutionParser::parseLine)
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
