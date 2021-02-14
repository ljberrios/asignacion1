/**
 * University of Puerto Rico at Bayamon
 * Department of Computer Science
 * SICI 4036 - Data Structures, Spring 2021
 * Luis J. Berríos Negrón
 * 802-18-1607
 * luis.berrios17@upr.edu
 */


package edu.uprb.app;

import edu.uprb.company.Department;
import edu.uprb.company.Employee;
import edu.uprb.company.HourlyEmployee;
import edu.uprb.company.SalesEmployee;

/**
 * Displays an array that contains different {@link Employee} records.
 *
 * @author Luis J. Berríos Negrón
 */
public class EmployeeArrayPrintingApp {

    public static void main(String[] args) {
        Employee[] employees = {
                new HourlyEmployee(1000),
                new HourlyEmployee(1001, "John", "Doe",
                        Department.INTE, 40, 20.00),
                new HourlyEmployee(1002, "Sarah", "Doe",
                        Department.INTE, 40, 20.00),
                new SalesEmployee(1003),
                new SalesEmployee(1004, "Jane", "Smith",
                        Department.FINA, 500.00, 3.00)
        };

        System.out.println("The company's employees:");
        for (Employee e : employees) {
            System.out.println("Employee ID: " + e.getEmployeeId());
            System.out.println("First Name: " + e.getFirstName());
            System.out.println("Last Name: " + e.getLastName());
            System.out.println("Department: " + e.getDepartment());
            System.out.printf("Weekly Salary: $%.2f\n", e.weeklySalary());

            if (e instanceof HourlyEmployee) {
                HourlyEmployee he = (HourlyEmployee) e;
                System.out.println("Hours Worked: " + he.getHoursWorked());
                System.out.printf("Pay Rate: %.2f\n", he.getPayRate());
            }

            if (e instanceof SalesEmployee) {
                SalesEmployee se = (SalesEmployee) e;
                System.out.printf(
                        "Sales Amount: $%.2f\n", se.getSalesAmount());
                System.out.printf(
                        "Commission Rate: %.2f\n", se.getCommissionRate());

            }

            System.out.println();
        }

        System.out.println("End of execution.");
        System.exit(0);
    }

}
