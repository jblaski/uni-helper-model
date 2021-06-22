package com.jblaski.unihelpermodel.parsing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static com.jblaski.unihelpermodel.Constants.*;

class ParseUtilsTest {

    @Test
    public void shouldParseFileIntoCorrectNumberOfLinesWithHeaders() {
        List<String> lines = ParseUtils.readLinesFromFile(TEST_RESOURCES_BASE_DIR + "course-location-truncated.csv", false);
        assertEquals(30, lines.size());
    }

    @Test
    public void shouldParseFileIntoCorrectNumberOfLinesWithoutHeaders() {
        List<String> lines = ParseUtils.readLinesFromFile(TEST_RESOURCES_BASE_DIR + "course-location-truncated.csv", true);
        assertEquals(29, lines.size());
    }
}