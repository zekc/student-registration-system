package Services;

import Models.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class JsonServiceTest {
    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Test course parsing size")
    void testParsing() {
        try {
            final var courses = JsonService.InitCourses("src/test/lectures.json");
            assertEquals(3, courses.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Test parsed objects")
    void testObjects() {
        try {
            final var courses = JsonService.InitCourses("src/test/lectures.json");
            courses.forEach(course -> assertTrue(course instanceof Course));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Test parsed content")
    void testContent() {
        try {
            final var courses = JsonService.InitCourses("src/test/lectures.json");
            assertEquals("ATA121", courses.get(0).getCourseCode());
            assertEquals("MBG1201", courses.get(1).getCourseCode());
            assertEquals("CSE1200", courses.get(2).getCourseCode());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
