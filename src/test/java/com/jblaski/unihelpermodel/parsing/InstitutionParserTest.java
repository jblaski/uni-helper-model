package com.jblaski.unihelpermodel.parsing;

import com.jblaski.unihelpermodel.model.CourseLocation;
import com.jblaski.unihelpermodel.model.Institution;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.jblaski.unihelpermodel.Constants.TEST_RESOURCES_BASE_DIR;
import static org.junit.jupiter.api.Assertions.*;

class InstitutionParserTest {

    @Test
    public void shouldReadCorrectNumberOfObjects() {
        List<Institution> institutions = InstitutionParser.readAllFromFile(TEST_RESOURCES_BASE_DIR + "institution-truncated.csv");
        assertEquals(49, institutions.size());
    }

    @Test
    public void shouldPopulateAllFields() {
        List<Institution> institutions = InstitutionParser.readAllFromFile(TEST_RESOURCES_BASE_DIR + "institution-truncated.csv");
        institutions.forEach(courseLocation -> {
            assertNotNull(courseLocation.getPUBUKPRN());
            assertNotNull(courseLocation.getUKPRN());
        });
    }

}