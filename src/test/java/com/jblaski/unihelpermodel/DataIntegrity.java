package com.jblaski.unihelpermodel;

import com.jblaski.unihelpermodel.model.Institution;
import com.jblaski.unihelpermodel.model.KISCourse;
import com.jblaski.unihelpermodel.parsing.InstitutionParser;
import com.jblaski.unihelpermodel.parsing.KISCourseParser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;

import static com.jblaski.unihelpermodel.Constants.DATA_BASE_DIR;
import static com.jblaski.unihelpermodel.Constants.TEST_RESOURCES_BASE_DIR;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class DataIntegrity {

    @Test
    public void kisCourseIdCombinedWithUkprnShouldBeUnique() {
        List<KISCourse> kisCourses = KISCourseParser.readAllFromFile(DATA_BASE_DIR + "KISCOURSE.csv");
        if (kisCourses.isEmpty()) {
            log.warn("Couldn't run test; no data found to investigate");
        } else {
            Map<String, KISCourse> map = new HashMap<>();
            List<KISCourse> duplicatedId = new LinkedList<>();

            for (KISCourse course : kisCourses) {
                KISCourse courseFromMap = map.get(course.getKISCOURSEID() + "-" + course.getUKPRN() + "-");
                if (courseFromMap != null) {
                    duplicatedId.add(courseFromMap);
                    duplicatedId.add(course);
                }
                map.put(course.getKISCOURSEID() + "-" + course.getUKPRN() + "-", course);
            }

            if (!duplicatedId.isEmpty()) {
                log.warn("Of " + kisCourses.size() + " courses, " + duplicatedId.size() + " did not have unique kisCourseId + UKPRN");
            }

            assertEquals(0, duplicatedId.size());
        }
    }

    @Test
    public void kisCourseIdCombinedWithUkprnAndKisModeShouldBeUnique() {
        List<KISCourse> kisCourses = KISCourseParser.readAllFromFile(DATA_BASE_DIR + "KISCOURSE.csv");
        if (kisCourses.isEmpty()) {
            log.warn("Couldn't run test; no data found to investigate");
        } else {
            Map<String, KISCourse> map = new HashMap<>();
            List<KISCourse> duplicatedId = new LinkedList<>();

            for (KISCourse course : kisCourses) {
                KISCourse courseFromMap = map.get(course.getKISCOURSEID() + "-" + course.getUKPRN() + "-" + course.getKISMODE());
                if (courseFromMap != null) {
                    duplicatedId.add(courseFromMap);
                    duplicatedId.add(course);
                }
                map.put(course.getKISCOURSEID() + "-" + course.getUKPRN() + "-" + course.getKISMODE(), course);
            }

            if (!duplicatedId.isEmpty()) {
                log.warn("Of " + kisCourses.size() + " courses, " + duplicatedId.size() + " did not have unique KISCOURSEID + UKPRN + KISMODE");
            }

            assertEquals(0, duplicatedId.size());
        }
    }

    @Test
    public void ukprnShouldBeUnique() {
        List<Institution> institutions = InstitutionParser.readAllFromFile(DATA_BASE_DIR + "INSTITUTION.csv");
        if (institutions.isEmpty()) {
            log.warn("Couldn't run test; no data found to investigate");
        } else {
            Map<String, Institution> map = new HashMap<>();
            List<Institution> duplicatedId = new LinkedList<>();

            for (Institution institution : institutions) {
                if (map.containsKey(institution.getUKPRN())) {
                    duplicatedId.add(map.get(institution.getUKPRN()));
                    duplicatedId.add(institution);
                }
                map.put(institution.getUKPRN(), institution);
            }

            if (!duplicatedId.isEmpty()) {
                log.warn("Of " + institutions.size() + " institutions, " + duplicatedId.size() + " did not have unique PUBUKPRN");
            }

            assertEquals(0, duplicatedId.size());
        }
    }
}
