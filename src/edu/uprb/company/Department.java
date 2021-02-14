/**
 * University of Puerto Rico at Bayamon
 * Department of Computer Science
 * SICI 4036 - Data Structures, Spring 2021
 * Luis J. Berríos Negrón
 * 802-18-1607
 * luis.berrios17@upr.edu
 */

package edu.uprb.company;

/**
 * Contains all the company's departments.
 *
 * @author Luis J. Berríos Negrón
 */
public enum Department {

    SALE, MKTG, HMRS, FINA, INTE;

    /**
     * Get the string representation of the company department.
     *
     * @return The string representation of the company department
     */
    @Override
    public String toString() {
        switch (this) {
            case SALE:
                return "for Sales";
            case MKTG:
                return "for Marketing";
            case HMRS:
                return "for Human Resources";
            case FINA:
                return "for Finance";
            case INTE:
                return "for Information Technology";
            default:
                return null;
        }
    }

}
