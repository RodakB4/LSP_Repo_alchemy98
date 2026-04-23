package org.howard.edu.lsp.finalexam.question2;

/**
 * Concrete report for a course, providing course-specific header, body, and footer.
 */
public class CourseReport extends Report {

    private String courseName;
    private int enrollment;

    /**
     * Loads course data for the report.
     */
    @Override
    protected void loadData() {
        courseName = "CSCI 363";
        enrollment = 45;
    }

    /**
     * Prints the course report header.
     */
    @Override
    protected void formatHeader() {
        System.out.println("Course Report");
    }

    /**
     * Prints the course name and enrollment.
     */
    @Override
    protected void formatBody() {
        System.out.println("Course: " + courseName);
        System.out.println("Enrollment: " + enrollment);
    }

    /**
     * Prints the course report footer.
     */
    @Override
    protected void formatFooter() {
        System.out.println("End of Course Report");
    }
}
