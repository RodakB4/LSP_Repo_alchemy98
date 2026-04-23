package org.howard.edu.lsp.finalexam.question3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 tests for GradeCalculator.
 */
public class GradeCalculatorTest {

    private GradeCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new GradeCalculator();
    }

    /** Tests average() with three normal valid scores. */
    @Test
    public void testAverageNormal() {
        assertEquals(80.0, calculator.average(90, 80, 70), 0.001);
    }

    /** Tests letterGrade() returns correct letter for a B-range average. */
    @Test
    public void testLetterGradeB() {
        assertEquals("B", calculator.letterGrade(85.0));
    }

    /** Tests isPassing() returns true for a passing average. */
    @Test
    public void testIsPassingTrue() {
        assertTrue(calculator.isPassing(75.0));
    }

    /** Boundary: average of all-zero scores (minimum valid input) returns 0.0. */
    @Test
    public void testBoundaryAllZeroScores() {
        assertEquals(0.0, calculator.average(0, 0, 0), 0.001);
    }

    /** Boundary: average of exactly 90 should return letter grade "A". */
    @Test
    public void testBoundaryLetterGradeExactly90() {
        assertEquals("A", calculator.letterGrade(90.0));
    }

    /** Exception: average() throws IllegalArgumentException for a negative score. */
    @Test
    public void testExceptionNegativeScore() {
        assertThrows(IllegalArgumentException.class, () -> calculator.average(-1, 50, 50));
    }

    /** Exception: average() throws IllegalArgumentException for a score above 100. */
    @Test
    public void testExceptionScoreOver100() {
        assertThrows(IllegalArgumentException.class, () -> calculator.average(50, 101, 50));
    }
}
