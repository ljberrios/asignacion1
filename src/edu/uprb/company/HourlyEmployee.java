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
 * Represents a record of a company's hourly {@link Employee}.
 *
 * @author Luis J. Berríos Negrón
 */
public class HourlyEmployee extends Employee {

    /**
     * The amount of hours the employee has worked
     * during the current work week
     */
    private int hoursWorked;

    /**
     * The hourly pay rate of the employee
     */
    private double payRate;

    /**
     * Construct an hourly employee record with the specified
     * employee ID, first name, last name, company {@link Department},
     * amount of hours worked, and hourly pay rate.
     *
     * @param employeeId  The employee's ID
     * @param firstName   The employee's first name
     * @param lastName    The employee's last name
     * @param department  The company {@link Department}
     * @param hoursWorked The amount of hours worked
     * @param payRate     The employee's hourly pay rate
     */
    public HourlyEmployee(int employeeId, String firstName,
                          String lastName, Department department,
                          int hoursWorked, double payRate)
    {
        super(employeeId, firstName, lastName, department);
        setHoursWorked(hoursWorked);
        setPayRate(payRate);
    }

    /**
     * Construct an hourly employee record
     * with the specified employee ID.
     *
     * @param employeeId The employee's ID
     */
    public HourlyEmployee(int employeeId) {
        super(employeeId);
        hoursWorked = 40;
        payRate = 10.00;
    }

    /**
     * Calculate the employee's weekly salary
     * based on the hours worked during the current work week
     * and the hourly pay rate.
     *
     * @return The employee's weekly salary
     */
    @Override
    public double weeklySalary() {
        if (hoursWorked <= 40) {
            return hoursWorked * payRate;
        } else {
            double overtimeHours = hoursWorked - 40;
            return (40 * payRate) + (payRate * 1.5 * overtimeHours);
        }
    }

    /**
     * Get the amount of hours the employee
     * has worked during the current work week.
     *
     * @return The amount of hours worked
     */
    public int getHoursWorked() {
        return hoursWorked;
    }

    /**
     * Set the amount of hours the employee
     * has worked during the current work week.
     *
     * @param hoursWorked The amount of hours worked
     */
    public void setHoursWorked(int hoursWorked) {
        if (hoursWorked < 0 || hoursWorked > 60) {
            throw new IllegalArgumentException(
                    "Invalid hours worked: " + hoursWorked);
        }
        this.hoursWorked = hoursWorked;
    }

    /**
     * Get the employee's hourly pay rate.
     *
     * @return The employee's hourly pay rate
     */
    public double getPayRate() {
        return payRate;
    }

    /**
     * Set the employee's hourly pay rate.
     *
     * @param payRate The employee's hourly pay rate
     */
    public void setPayRate(double payRate) {
        if (payRate < 7.00 || payRate > 50.00) {
            throw new IllegalArgumentException(String.format(
                    "Invalid pay rate: $%.2f", payRate));
        }
        this.payRate = payRate;
    }

    /**
     * Get the string representation of the hourly employee record.
     *
     * @return The string representation
     */
    @Override
    public String toString() {
        return super.toString() + ", " +
                String.format(
                        "Hours Worked: %d, Pay Rate: $%.2f",
                        hoursWorked, payRate
                );
    }

}
