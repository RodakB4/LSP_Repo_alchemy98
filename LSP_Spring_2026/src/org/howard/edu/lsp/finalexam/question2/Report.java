package org.howard.edu.lsp.finalexam.question2;

/**
 * Abstract base class defining the Template Method for generating reports.
 * The workflow is fixed: loadData → formatHeader → formatBody → formatFooter.
 * Subclasses implement the variable steps.
 */
public abstract class Report {

    /**
     * Template method that defines the fixed report generation workflow.
     * Subclasses may not override this method.
     */
    public final void generateReport() {
        loadData();
        System.out.println("=== HEADER ===");
        formatHeader();
        System.out.println();
        System.out.println("=== BODY ===");
        formatBody();
        System.out.println();
        System.out.println("=== FOOTER ===");
        formatFooter();
        System.out.println();
    }

    /**
     * Loads the data needed for this report.
     * Must be implemented by each concrete report subclass.
     */
    protected abstract void loadData();

    /**
     * Prints the report-specific header content.
     */
    protected abstract void formatHeader();

    /**
     * Prints the report-specific body content.
     */
    protected abstract void formatBody();

    /**
     * Prints the report-specific footer content.
     */
    protected abstract void formatFooter();
}
