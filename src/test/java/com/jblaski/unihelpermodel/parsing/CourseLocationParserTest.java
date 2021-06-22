package com.jblaski.unihelpermodel.parsing;

import com.jblaski.unihelpermodel.model.CourseLocation;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.jblaski.unihelpermodel.Constants.TEST_RESOURCES_BASE_DIR;
import static org.junit.jupiter.api.Assertions.*;

class CourseLocationParserTest {

    @Test
    public void shouldReadCorrectNumberOfObjects() {
        List<CourseLocation> courseLocations = CourseLocationParser.readAllFromFile(TEST_RESOURCES_BASE_DIR + "course-location-truncated.csv");
        assertEquals(29, courseLocations.size());
    }

    @Test
    public void shouldPopulateAllFields() {
        List<CourseLocation> courseLocations = CourseLocationParser.readAllFromFile(TEST_RESOURCES_BASE_DIR + "course-location-truncated.csv");
        courseLocations.forEach(courseLocation -> {
            assertNotNull(courseLocation.getPUBUKPRN());
            assertNotNull(courseLocation.getUKPRN());
            assertNotNull(courseLocation.getKISCOURSEID());
            assertNotNull(courseLocation.getKISMODE());
            assertNotNull(courseLocation.getLOCID());
        });
    }

}