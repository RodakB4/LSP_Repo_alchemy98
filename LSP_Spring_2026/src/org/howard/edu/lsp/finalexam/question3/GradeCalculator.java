package org.howard.edu.lsp.finalexam.question3;

/**
 * Calculates letter grades and pass/fail status from numeric scores.
 */
public class GradeCalculator {

    /**
     * Computes the average of three scores.
     *
     * @param score1 first score (0-100)
     * @param score2 second score (0-100)
     * @param score3 third score (0-100)
     * @return the average of the three scores
     * @throws IllegalArgumentException if any score is outside the range 0-100
     */
    public double average(int score1, int score2, int score3) {
        validateScore(score1);
        validateScore(score2);
        validateScore(score3);
        return (score1 + score2 + score3) / 3.0;
    }

    /**
     * Returns the letter grade corresponding to the given average.
     *
     * @param average the numeric average
     * @return letter grade: "A", "B", "C", "D", or "F"
     */
    public String letterGrade(double average) {
        if (average >= 90) return "A";
        else if (average >= 80) return "B";
        else if (average >= 70) return "C";
        else if (average >= 60) return "D";
        else return "F";
    }

    /**
     * Determines whether the given average is a passing grade.
     *
     * @param average the numeric average
     * @return true if average is 60 or above, false otherwise
     */
    public boolean isPassing(double average) {
        return average >= 60;
    }

    /**
     * Validates that a score is in the range 0-100.
     *
     * @param score the score to validate
     * @throws IllegalArgumentException if score is less than 0 or greater than 100
     */
    private void validateScore(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100");
        }
    }
}
