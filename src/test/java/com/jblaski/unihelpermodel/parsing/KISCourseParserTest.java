package com.jblaski.unihelpermodel.parsing;

import com.jblaski.unihelpermodel.model.KISCourse;
import com.jblaski.unihelpermodel.model.Location;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.jblaski.unihelpermodel.Constants.TEST_RESOURCES_BASE_DIR;
import static org.junit.jupiter.api.Assertions.*;

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

}