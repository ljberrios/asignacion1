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
 * Represents a record of a company's sales {@link Employee}.
 *
 * @author Luis J. Berríos Negrón
 */
public class SalesEmployee extends Employee {

    /**
     * The sales amount for the employee for the current work week
     */
    private double salesAmount;

    /**
     * The employee's commission rate
     */
    private double commissionRate;

    /**
     * Construct a sales employee record with the specified
     * employee ID, first name, last name, company {@link Department},
     * sales amount, and commission rate.
     *
     * @param employeeId     The employee's ID
     * @param firstName      The employee's first name
     * @param lastName       The employee's last name
     * @param department     The company {@link Department}
     * @param salesAmount    The sales amount
     * @param commissionRate The commission rate
     */
    public SalesEmployee(int employeeId, String firstName,
                         String lastName, Department department,
                         double salesAmount, double commissionRate)
    {
        super(employeeId, firstName, lastName, department);
        this.salesAmount = salesAmount;
        this.commissionRate = commissionRate;
    }

    /**
     * Construct a sales employee record with the specified employee ID.
     *
     * @param employeeId The employee's ID
     */
    public SalesEmployee(int employeeId) {
        super(employeeId);
        salesAmount = 0.00;
        commissionRate = 0.10;
    }

    /**
     * Get the sales amount for the employee for the current work week.
     *
     * @return The sales amount
     */
    public double getSalesAmount() {
        return salesAmount;
    }

    /**
     * Set the sales amount for the employee for the current work week.
     *
     * @param salesAmount The sales amount
     */
    public void setSalesAmount(double salesAmount) {
        if (salesAmount < 0.00) {
            throw new IllegalArgumentException(String.format(
                    "Invalid sales amount: $%.2f", salesAmount));
        }
        this.salesAmount = salesAmount;
    }

    /**
     * Get the employee's commission rate.
     *
     * @return The commission rate
     */
    public double getCommissionRate() {
        return commissionRate;
    }

    /**
     * Set the employee's commission rate.
     *
     * @param commissionRate The commission rate
     */
    public void setCommissionRate(double commissionRate) {
        if (commissionRate < 0.00 || commissionRate > 1.00) {
            throw new IllegalArgumentException(String.format(
                    "Invalid commission rate: %.2f%%", commissionRate * 100));
        }
        this.commissionRate = commissionRate;
    }

    /**
     * Calculate the employee's weekly salary
     * based on the sales amount and commission rate.
     *
     * @return The employee's weekly salary
     */
    @Override
    public double weeklySalary() {
        return salesAmount * commissionRate;
    }

    /**
     * Get the string representation of the sales employee record.
     *
     * @return The string representation
     */
    @Override
    public String toString() {
        return super.toString() + ", " +
                String.format(
                        "Sales Amount: $%.2f, Commission Rate: %.2f%%",
                        salesAmount, commissionRate * 100
                );
    }

}
