package org.howard.edu.lsp.finalexam.question2;

/**
 * Concrete report for a student, providing student-specific header, body, and footer.
 */
public class StudentReport extends Report {

    private String studentName;
    private double gpa;

    /**
     * Loads student data for the report.
     */
    @Override
    protected void loadData() {
        studentName = "John Doe";
        gpa = 3.8;
    }

    /**
     * Prints the student report header.
     */
    @Override
    protected void formatHeader() {
        System.out.println("Student Report");
    }

    /**
     * Prints the student name and GPA.
     */
    @Override
    protected void formatBody() {
        System.out.println("Student Name: " + studentName);
        System.out.println("GPA: " + gpa);
    }

    /**
     * Prints the student report footer.
     */
    @Override
    protected void formatFooter() {
        System.out.println("End of Student Report");
    }
}
