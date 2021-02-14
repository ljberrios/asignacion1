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
 * Represents a record of a company's employee.
 *
 * @author Luis J. Berríos Negrón
 */
public abstract class Employee {

    /**
     * The employee's identification number
     */
    private final int employeeId;

    /**
     * The employee's first name
     */
    private String firstName;

    /**
     * The employee's last name
     */
    private String lastName;

    /**
     * The company {@link Department} the employee works in
     */
    private Department department;

    /**
     * Construct an employee record with the specified
     * employee ID, first name, last name, and company {@link Department}.
     *
     * @param employeeId The employee's ID
     * @param firstName  The employee's first name
     * @param lastName   The employee's last name
     * @param department The company {@link Department}
     */
    public Employee(int employeeId, String firstName,
                    String lastName, Department department)
    {
        validateEmployeeId(employeeId);
        this.employeeId = employeeId;
        setFirstName(firstName);
        setLastName(lastName);
        setDepartment(department);
    }

    /**
     * Construct an employee record with the specified employee ID.
     *
     * @param employeeId The employee's ID
     */
    public Employee(int employeeId) {
        validateEmployeeId(employeeId);
        this.employeeId = employeeId;
    }

    /**
     * Validate that the given employee ID
     * is within the default constraints.
     *
     * @param employeeId The employee ID
     */
    private void validateEmployeeId(int employeeId) {
        if (employeeId < 1000 || employeeId > 9999) {
            throw new IllegalArgumentException(
                    "Invalid employee id: " + employeeId);
        }
    }

    /**
     * Get the employee's ID.
     *
     * @return The employee's ID
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * Get the employee's first name.
     *
     * @return The employee's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the employee's first name
     *
     * @param firstName The employee's first name
     */
    public void setFirstName(String firstName) {
        if (!firstName.matches("[A-Z][a-z]{1,9}")) {
            throw new IllegalArgumentException(
                    "Invalid first name: " + firstName);
        }
        this.firstName = firstName;
    }

    /**
     * Get the employee's last name.
     *
     * @return The employee's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the employee's last name.
     *
     * @param lastName The employee's last name
     */
    public void setLastName(String lastName) {
        if (!lastName.matches("[A-Z][a-z]{1,9}")) {
            throw new IllegalArgumentException(
                    "Invalid last name: " + lastName);
        }
        this.lastName = lastName;
    }

    /**
     * Get the company {@link Department} the employee works in.
     *
     * @return The company {@link Department}
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Set the company {@link Department} the employee works in.
     *
     * @param department The company {@link Department}
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * Abstract method for the calculation
     * of the employee's weekly salary.
     *
     * @return The employee's weekly salary
     */
    public abstract double weeklySalary();

    /**
     * Determine if the employee record is equal to the given object.
     * Two employee records are equal if they have the same employee ID.
     *
     * @param obj The object to compare the employee to
     * @return {@code true} if the employee record is equal
     * to the given object, {@code false} if otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Employee)) {
            return false;
        }

        Employee other = (Employee) obj;
        return employeeId == other.getEmployeeId();
    }

    /**
     * Get the string representation of the employee record.
     *
     * @return The string representation
     */
    @Override
    public String toString() {
        return String.format(
                "Employee ID: %d, First Name: %s, " +
                        "Last Name: %s, Department: %s",
                employeeId, firstName, lastName, department
        );
    }

}
