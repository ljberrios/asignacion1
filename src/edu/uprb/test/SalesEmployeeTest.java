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
import edu.uprb.company.SalesEmployee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for {@link SalesEmployee} record functionality.
 *
 * @author Luis J. Berríos Negrón
 */
class SalesEmployeeTest {

    /**
     * Represents a standard sales employee record.
     */
    private SalesEmployee se;

    /**
     * Represents a sales employee record
     * constructed with only the employee ID.
     */
    private SalesEmployee def;

    /**
     * Executes before each test to set it up.
     */
    @BeforeEach
    void setUp() {
        se = new SalesEmployee(2000,
                "Jane", "Doe", Department.SALE, 4000.00, 0.125);
        def = new SalesEmployee(2001);
    }

    /**
     * Tests that the standard sales employee
     * record has the expected string representation.
     */
    @Test
    void testToString() {
        String expected = "Employee ID: 2000, First Name: Jane, " +
                "Last Name: Doe, Department: for Sales, " +
                "Sales Amount: $4000.00, Commission Rate: 12.50%";
        assertEquals(expected, se.toString());
    }

    /**
     * Tests that the standard sales employee
     * record has the expected employee ID.
     */
    @Test
    void testGetEmployeeId() {
        assertEquals(2000, se.getEmployeeId());
    }

    /**
     * Tests that the standard sales employee
     * record has the expected first name.
     */
    @Test
    void testGetFirstName() {
        assertEquals("Jane", se.getFirstName());
    }

    /**
     * Tests that the standard sales employee
     * record has the expected last name.
     */
    @Test
    void testGetLastName() {
        assertEquals("Doe", se.getLastName());
    }

    /**
     * Tests that the standard sales employee
     * record has the expected company {@link Department}.
     */
    @Test
    void testGetDepartment() {
        assertEquals(Department.SALE, se.getDepartment());
    }

    /**
     * Tests that the standard sales employee
     * record has the expected sales amount.
     */
    @Test
    void testGetSalesAmount() {
        assertEquals(4000.00, se.getSalesAmount());
    }

    /**
     * Tests that the standard sales employee
     * record has the expected commission rate.
     */
    @Test
    void testGetCommissionRate() {
        assertEquals(0.125, se.getCommissionRate());
    }

    /**
     * Tests that the weekly salary for the standard
     * sales employee record is computed as expected.
     */
    @Test
    void testWeeklySalary() {
        assertEquals(500, se.weeklySalary());
    }

    /**
     * Tests that the standard sales employee record is equal to itself.
     */
    @Test
    void testEqualsWithItself() {
        assertEquals(se, se);
    }

    /**
     * Tests that the standard sales employee record is equal to a copy.
     */
    @Test
    void testEqualsWithCopy() {
        SalesEmployee copy = new SalesEmployee(2000,
                "Jane", "Doe", Department.SALE, 4000.00, 0.125);
        assertEquals(copy, se);
    }

    /**
     * Tests that the standard sales employee
     * record is not equal to a different one.
     */
    @Test
    void testEqualsWithDifferent() {
        SalesEmployee diff = new SalesEmployee(2001,
                "Jane", "Doe", Department.SALE, 4000.00, 0.125);
        assertNotEquals(diff, se);
    }

    /**
     * Tests that the first name in the standard
     * sales employee record can be changed.
     */
    @Test
    void testSetValidFirstName() {
        se.setFirstName("Sarah");
        assertEquals("Sarah", se.getFirstName());
    }

    /**
     * Tests that the first name in the standard sales
     * employee record cannot be set to an invalid value.
     */
    @Test
    void testSetInvalidFirstName() {
        try {
            se.setFirstName("sarah0");
            fail("Test failure with invalid first name: sarah0");
        } catch (IllegalArgumentException ex) {
            assertEquals("Invalid first name: sarah0", ex.getMessage());
        }
    }

    /**
     * Tests that the last name in the standard
     * sales employee record can be changed.
     */
    @Test
    void testSetValidLastName() {
        se.setLastName("Smith");
        assertEquals("Smith", se.getLastName());
    }

    /**
     * Tests that the last name in the standard sales
     * employee record cannot be set to an invalid value.
     */
    @Test
    void testSetInvalidLastName() {
        try {
            se.setLastName("smith0");
            fail("Test failure with invalid last name: smith0");
        } catch (IllegalArgumentException ex) {
            assertEquals("Invalid last name: smith0", ex.getMessage());
        }
    }

    /**
     * Tests that the sales amount in the standard
     * sales employee record can be changed.
     */
    @Test
    void testSetValidSalesAmount() {
        se.setSalesAmount(5.00);
        assertEquals(5.00, se.getSalesAmount());
    }

    /**
     * Tests that the sales amount in the standard sales
     * employee record cannot be set to an invalid value.
     */
    @Test
    void testSetInvalidSalesAmount() {
        try {
            se.setSalesAmount(-5.00);
            fail("Test failure with invalid sales amount: $-5.00");
        } catch (IllegalArgumentException ex) {
            assertEquals("Invalid sales amount: $-5.00", ex.getMessage());
        }
    }

    /**
     * Tests that the commission rate in the standard
     * sales employee record can be changed.
     */
    @Test
    void testSetValidCommissionRate() {
        se.setCommissionRate(0.30);
        assertEquals(0.30, se.getCommissionRate());
    }

    /**
     * Tests that the commission rate in the standard sales
     * employee record cannot be set to an invalid value.
     */
    @Test
    void testSetInvalidCommissionRate() {
        try {
            se.setCommissionRate(5.00);
            fail("Test failure with invalid commission rate: 500.00%");
        } catch (IllegalArgumentException ex) {
            assertEquals("Invalid commission rate: 500.00%", ex.getMessage());
        }
    }

    /**
     * Tests that the sales employee record constructed
     * with only the employee ID has the expected string representation.
     */
    @Test
    void testToStringForDefaultEmployee() {
        String expected = "Employee ID: 2001, First Name: null, " +
                "Last Name: null, Department: null, " +
                "Sales Amount: $0.00, Commission Rate: 10.00%";
        assertEquals(expected, def.toString());
    }

    /**
     * Tests that the weekly salary for the sales employee
     * record constructed with only the employee ID is computed as expected.
     */
    @Test
    void testWeeklySalaryForDefaultEmployee() {
        assertEquals(0.00, def.weeklySalary());
    }

    /**
     * Tests that a sales employee record
     * cannot be constructed with an invalid employee ID.
     */
    @Test
    void testConstructorWithInvalidEmployeeId() {
        try {
            def = new SalesEmployee(500);
            fail("Test failure with invalid employee id: 500");
        } catch (IllegalArgumentException ex) {
            assertEquals("Invalid employee id: 500", ex.getMessage());
        }
    }

}
