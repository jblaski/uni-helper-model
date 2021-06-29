package com.jblaski.unihelpermodel.parsing;

import com.jblaski.unihelpermodel.model.KISCourse;
import com.jblaski.unihelpermodel.model.Location;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jblaski.unihelpermodel.Constants.DATA_BASE_DIR;
import static com.jblaski.unihelpermodel.Constants.TEST_RESOURCES_BASE_DIR;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class KISCourseParserTest {

    @Test
    public void shouldReadCorrectNumberOfObjects() {
        List<KISCourse> kisCourses = KISCourseParser.readAllFromFile(TEST_RESOURCES_BASE_DIR + "kiscourse-truncated.csv");
        assertEquals(45, kisCourses.size());
    }

    @Test
    public void shouldPopulateMandatoryFields() {
        List<KISCourse> kisCourses = KISCourseParser.readAllFromFile(TEST_RESOURCES_BASE_DIR + "kiscourse-truncated.csv");
        kisCourses.forEach(course -> {
            assertNotNull(course.getUKPRN());
            assertNotEquals("", course.getUKPRN());
        });
    }

    @Test
    public void shouldHaveUniqueCompositeUkprnWithId() {
        List<KISCourse> kisCourses = KISCourseParser.readAllFromFileUniqueUkprnAndKisCourseId(DATA_BASE_DIR + "KISCOURSE.csv");
        if (kisCourses.isEmpty()) {
            log.warn("Couldn't run test; no data found to investigate");
        } else {
            Map<String, KISCourse> map = new HashMap<>();
            int duplicates = 0;
            for (KISCourse course: kisCourses) {
                if (map.containsKey(course.getUKPRN() + course.getKISCOURSEID())) {
                    duplicates++;
                }
                map.put(course.getUKPRN() + course.getKISCOURSEID(), course);
            }
            assertEquals(0, duplicates);
        }
    }
}