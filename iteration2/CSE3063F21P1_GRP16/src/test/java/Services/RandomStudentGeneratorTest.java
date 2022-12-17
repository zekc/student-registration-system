package Services;

import Models.Course;
import Models.Student;
import Services.JsonService;
import Services.RandomStudentGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class RandomStudentGeneratorTest {
    RandomStudentGenerator generator;
    List<Course> courses;

    @BeforeEach
    void setUp() {
        this.generator = new RandomStudentGenerator();
        try {
            this.courses = JsonService.InitCourses("src/test/lectures.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Test generator output size")
    void testSize() {
        verifyAll(students(), students -> assertEquals(400, students.size()));
    }

    @Test
    @DisplayName("Test student objects")
    void testObjects() {
        verifyForEach(students(), student -> assertTrue(student instanceof Student));
    }

    public void verifyAll(final Collection<Student> students, final Consumer<Collection<Student>> assertion) {
        assertion.accept(students);
    }

    public void verifyForEach(final Collection<Student> students, final Consumer<Student> assertion) {
        students.forEach(assertion);
    }

    private Set<Student> students() {
        return new HashSet<>(generator.GenerateRandomStudents(new ArrayList<>(courses)));
    }
}
