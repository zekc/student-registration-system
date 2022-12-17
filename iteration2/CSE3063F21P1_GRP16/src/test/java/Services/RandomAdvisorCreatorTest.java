package Services;

import Models.Advisor;
import Services.RandomAdvisorCreator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomAdvisorCreatorTest {
    RandomAdvisorCreator randomAdvisorCreator;

    @BeforeEach
    void setUp() {
        this.randomAdvisorCreator = new RandomAdvisorCreator();
    }

    @Test
    @DisplayName("Test random advisor creation size")
    void testSize() {
        final int desiredAdvisorSize = 4;
        verifyAll(advisors(desiredAdvisorSize), advisors -> assertEquals(desiredAdvisorSize, advisors.size()));
    }

    @Test
    @DisplayName("Test objects")
    void testObjects() {
        final int desiredAdvisorSize = 5;
        verifyForEach(advisors(desiredAdvisorSize), advisor -> assertTrue(advisor instanceof Advisor));
    }

    public void verifyAll(final Collection<Advisor> advisors, final Consumer<Collection<Advisor>> assertion) {
        assertion.accept(advisors);
    }

    public void verifyForEach(final Collection<Advisor> advisors, final Consumer<Advisor> assertion) {
        advisors.forEach(assertion);
    }

    private Set<Advisor> advisors(final int desiredAdvisorSize) {
        return new HashSet<>(randomAdvisorCreator.GenerateRandomAdv(desiredAdvisorSize));
    }
}
