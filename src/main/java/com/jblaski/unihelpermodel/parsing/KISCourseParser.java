package com.jblaski.unihelpermodel.parsing;

import com.jblaski.unihelpermodel.model.CourseLocation;
import com.jblaski.unihelpermodel.model.KISCourse;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class KISCourseParser {

    public static String expectedHeaders = "PUBUKPRN,UKPRN,ASSURL,ASSURLW,CRSECSTURL,CRSECSTURLW,CRSEURL,CRSEURLW,DISTANCE,EMPLOYURL,EMPLOYURLW,FOUNDATION,HONOURS,HECOS,HECOS,HECOS,HECOS,HECOS,KISCOURSEID," +
            "KISMODE,LDCS,LDCS,LDCS,LOCCHNGE,LTURL,LTURLW,NHS,NUMSTAGE,SANDWICH,SUPPORTURL,SUPPORTURLW,TITLE,TITLEW,UCASPROGID,UKPRNAPPLY,YEARABROAD,KISAIMCODE,KISLEVEL";

    public static KISCourse parseLine(String line) {
        String[] fields = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1); // handles commas enclosed in quotes

        // the final field is not mandatory, so we may need to pad
        int requiredNumberOfFields = expectedHeaders.length();
        if (fields.length < requiredNumberOfFields) {
            fields = Arrays.copyOf(fields, requiredNumberOfFields);
        }

        return KISCourse.builder()
                .PUBUKPRN(fields[0])
                .UKPRN(fields[1])
                .ASSURL(fields[2])
                .ASSURLW(fields[3])
                .CRSECSTURL(fields[4])
                .CRSECSTURLW(fields[5])
                .CRSEURL(fields[6])
                .CRSEURLW(fields[7])
                .DISTANCE(fields[8])
                .EMPLOYURL(fields[9])
                .EMPLOYURLW(fields[10])
                .FOUNDATION(fields[11])
                .HONOURS(fields[12])
                .HECOS1(fields[13])
                .HECOS2(fields[14])
                .HECOS3(fields[15])
                .HECOS4(fields[16])
                .HECOS5(fields[17])
                .KISCOURSEID(fields[18])
                .KISMODE(fields[19])
                .LDCS1(fields[20])
                .LDCS2(fields[21])
                .LDCS3(fields[22])
                .LOCCHNGE(fields[23])
                .LTURL(fields[24])
                .LTURLW(fields[25])
                .NHS(fields[26])
                .NUMSTAGE(fields[27])
                .SANDWICH(fields[28])
                .SUPPORTURL(fields[29])
                .SUPPORTURLW(fields[30])
                .TITLE(fields[31])
                .TITLEW(fields[32])
                .UCASPROGID(fields[33])
                .UKPRNAPPLY(fields[34])
                .YEARABROAD(fields[35])
                .KISAIMCODE(fields[36])
                .KISLEVEL(fields[37])
                .build();
    }

    public static List<KISCourse> readAllFromFile(String filepath) {
        validateHeaders(filepath);
        List<String> lines = ParseUtils.readLinesFromFile(filepath, true);
        return lines.stream()
                    .map(KISCourseParser::parseLine)
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
