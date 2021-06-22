package com.jblaski.unihelpermodel.parsing;

import com.jblaski.unihelpermodel.model.Location;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.jblaski.unihelpermodel.Constants.TEST_RESOURCES_BASE_DIR;
import static org.junit.jupiter.api.Assertions.*;

class LocationParserTest {

    @Test
    public void shouldReadCorrectNumberOfObjects() {
        List<Location> locations = LocationParser.readAllFromFile(TEST_RESOURCES_BASE_DIR + "location-truncated.csv");
        assertEquals(49, locations.size());
    }

    @Test
    public void shouldPopulateMandatoryFields() {
        List<Location> locations = LocationParser.readAllFromFile(TEST_RESOURCES_BASE_DIR + "location-truncated.csv");
        locations.forEach(location -> {
            assertNotNull(location.getLOCID());
            assertNotEquals("", location.getLOCID());
        });
    }

}