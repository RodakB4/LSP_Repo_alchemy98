package org.howard.edu.lsp.finalexam.question2;

import java.util.ArrayList;
import java.util.List;

/**
 * Driver demonstrating the Template Method pattern through polymorphism.
 * Both StudentReport and CourseReport are treated as Report objects.
 */
public class Driver {

    /**
     * Entry point. Adds StudentReport and CourseReport to a list and
     * calls generateReport() on each, demonstrating polymorphism.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        List<Report> reports = new ArrayList<>();
        reports.add(new StudentReport());
        reports.add(new CourseReport());

        for (Report report : reports) {
            report.generateReport();
        }
    }
}
