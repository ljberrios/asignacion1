/**
 * University of Puerto Rico at Bayamon
 * Department of Computer Science
 * SICI 4036 - Data Structures, Spring 2021
 * Luis J. Berríos Negrón
 * 802-18-1607
 * luis.berrios17@upr.edu
 */


package edu.uprb.test;

import edu.uprb.company.Department;
import edu.uprb.company.HourlyEmployee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for {@link HourlyEmployee} record functionality.
 *
 * @author Luis J. Berríos Negrón
 */
class HourlyEmployeeTest {

    /**
     * Represents an hourly employee record with no overtime.
     */
    private HourlyEmployee standard;

    /**
     * Represents an hourly employee record with overtime.
     */
    private HourlyEmployee overtime;

    /**
     * Represents an hourly employee record
     * constructed with only the employee's ID.
     */
    private HourlyEmployee def;

    /**
     * Executes before each test to set it up.
     */
    @BeforeEach
    void setUp() {
        standard = new HourlyEmployee(1000,
                "John", "Doe", Department.FINA, 40, 7.50);
        overtime = new HourlyEmployee(1001,
                "Jane", "Smith", Department.HMRS, 45, 7.50);
        def = new HourlyEmployee(1002);
    }

    /**
     * Tests that the standard hourly employee
     * record has the expected string representation.
     */
    @Test
    void testToString() {
        String expected = "Employee ID: 1000, First Name: John, " +
                "Last Name: Doe, Department: for Finance, " +
                "Hours Worked: 40, Pay Rate: $7.50";
        assertEquals(expected, standard.toString());
    }

    /**
     * Tests that the standard hourly employee
     * record has the expected employee ID.
     */
    @Test
    void testGetEmployeeId() {
        assertEquals(1000, standard.getEmployeeId());
    }

    /**
     * Tests that the standard hourly employee
     * record has the expected first name.
     */
    @Test
    void testGetFirstName() {
        assertEquals("John", standard.getFirstName());
    }

    /**
     * Tests that the standard hourly
     * employee record has the expected last name.
     */
    @Test
    void testGetLastName() {
        assertEquals("Doe", standard.getLastName());
    }

    /**
     * Tests that the standard hourly employee
     * record has the expected company {@link Department}.
     */
    @Test
    void testGetDepartment() {
        assertEquals(Department.FINA, standard.getDepartment());
    }

    /**
     * Tests that the standard hourly employee
     * record has the expected amount of hours worked.
     */
    @Test
    void testGetHoursWorked() {
        assertEquals(40, standard.getHoursWorked());
    }

    /**
     * Tests that the standard hourly employee
     * record has the expected hourly pay rate.
     */
    @Test
    void testGetPayRate() {
        assertEquals(7.50, standard.getPayRate());
    }

    /**
     * Tests that the weekly salary for the standard
     * hourly employee record is computed as expected.
     */
    @Test
    void testWeeklySalary() {
        assertEquals(300.00, standard.weeklySalary());
    }

    /**
     * Tests that the standard hourly employee record is equal to itself.
     */
    @Test
    void testEqualsWithItself() {
        assertEquals(standard, standard);
    }

    /**
     * Tests that the standard hourly employee record is equal to a copy.
     */
    @Test
    void testEqualsWithCopy() {
        HourlyEmployee copy = new HourlyEmployee(1000,
                "John", "Doe", Department.FINA, 40, 7.50);
        assertEquals(copy, standard);
    }

    /**
     * Tests that the standard hourly
     * employee record is not equal to a different one.
     */
    @Test
    void testEqualsWithDifferent() {
        HourlyEmployee diff = new HourlyEmployee(1001,
                "John", "Doe", Department.FINA, 40, 7.50);
        assertNotEquals(diff, standard);
    }

    /**
     * Tests that the first name in the
     * standard hourly employee record can be changed.
     */
    @Test
    void testSetValidFirstName() {
        standard.setFirstName("Jane");
        assertEquals("Jane", standard.getFirstName());
    }

    /**
     * Tests that the first name in the standard
     * hourly employee record cannot be set to an invalid value.
     */
    @Test
    void testSetInvalidFirstName() {
        try {
            standard.setFirstName("jane0");
            fail("Test failure with invalid first name: jane0");
        } catch (IllegalArgumentException ex) {
            assertEquals("Invalid first name: jane0", ex.getMessage());
        }
    }

    /**
     * Tests that the last name in the
     * standard hourly employee record can be changed.
     */
    @Test
    void testSetValidLastName() {
        standard.setLastName("Smith");
        assertEquals("Smith", standard.getLastName());
    }

    /**
     * Tests that the last name in the standard
     * hourly employee record cannot be set to an invalid value.
     */
    @Test
    void testSetInvalidLastName() {
        try {
            standard.setLastName("smith0");
            fail("Test failure with invalid last name: smith0");
        } catch (IllegalArgumentException ex) {
            assertEquals("Invalid last name: smith0", ex.getMessage());
        }
    }

    /**
     * Tests that the amount of hours worked
     * in the standard hourly employee record can be changed.
     */
    @Test
    void testSetValidHoursWorked() {
        standard.setHoursWorked(45);
        assertEquals(45, standard.getHoursWorked());
    }

    /**
     * Tests that the amount of hours worked in the
     * standard hourly employee record cannot be set to an invalid value.
     */
    @Test
    void testSetInvalidHoursWorked() {
        try {
            standard.setHoursWorked(100);
            fail("Test failure with invalid hours worked: 100");
        } catch (IllegalArgumentException ex) {
            assertEquals("Invalid hours worked: 100", ex.getMessage());
        }
    }

    /**
     * Tests that the hourly pay rate in the
     * standard hourly employee record can be changed.
     */
    @Test
    void testSetValidPayRate() {
        standard.setPayRate(49.00);
        assertEquals(49.00, standard.getPayRate());
    }

    /**
     * Tests that the hourly pay rate in the standard
     * hourly employee record cannot be set to an invalid value.
     */
    @Test
    void testSetInvalidPayRate() {
        try {
            standard.setPayRate(60.00);
            fail("Test failure with invalid pay rate: $60.00");
        } catch (IllegalArgumentException ex) {
            assertEquals("Invalid pay rate: $60.00", ex.getMessage());
        }
    }

    /**
     * Tests that the hourly employee record with
     * overtime has the expected string representation.
     */
    @Test
    void testToStringForEmployeeWithOvertime() {
        String expected = "Employee ID: 1001, First Name: Jane, " +
                "Last Name: Smith, Department: for Human Resources, " +
                "Hours Worked: 45, Pay Rate: $7.50";
        assertEquals(expected, overtime.toString());
    }

    /**
     * Tests that the weekly salary for the hourly
     * employee record with overtime is computed as expected.
     */
    @Test
    void testWeeklySalaryForEmployeeWithOvertime() {
        assertEquals(356.25, overtime.weeklySalary());
    }

    /**
     * Tests that the hourly employee record constructed with
     * only the employee ID has the expected string representation.
     */
    @Test
    void testToStringForDefaultEmployee() {
        String expected = "Employee ID: 1002, First Name: null, " +
                "Last Name: null, Department: null, " +
                "Hours Worked: 40, Pay Rate: $10.00";
        assertEquals(expected, def.toString());
    }

    /**
     * Tests that the weekly salary for the hourly
     * employee record constructed with only the employee ID
     * is computed as expected.
     */
    @Test
    void testWeeklySalaryForDefaultEmployee() {
        assertEquals(400.00, def.weeklySalary());
    }

    /**
     * Tests that an hourly employee record
     * cannot be constructed with an invalid employee ID.
     */
    @Test
    void testConstructorWithInvalidEmployeeId() {
        try {
            def = new HourlyEmployee(500);
            fail("Test failure with invalid employee id: 500");
        } catch (IllegalArgumentException ex) {
            assertEquals("Invalid employee id: 500", ex.getMessage());
        }
    }

}
