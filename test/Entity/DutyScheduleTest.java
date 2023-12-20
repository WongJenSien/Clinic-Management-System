/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Entity;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jensienwong
 */
public class DutyScheduleTest {

    Time time = new Time();
    DutySchedule timeSlot = new DutySchedule();

    public DutyScheduleTest() {
        time = new Time(800, 1000);
        timeSlot = new DutySchedule(1, "JAN", 2022, time);
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("* DutyScheduleTest: Start *");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("* DutyScheduleTest: End *");
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getMonth method, of class DutySchedule.
     */
    @Test
    public void testGetMonth() {
        System.out.println("getMonth");
        DutySchedule instance = timeSlot;
        String expResult = "JAN";
        String result = instance.getMonth();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDay method, of class DutySchedule.
     */
    @Test
    public void testGetDay() {
        System.out.println("getDay");
        DutySchedule instance = timeSlot;
        int expResult = 1;
        int result = instance.getDay();
        assertEquals(expResult, result);
    }

    /**
     * Test of getYears method, of class DutySchedule.
     */
    @Test
    public void testGetYears() {
        System.out.println("getYears");
        DutySchedule instance = timeSlot;
        int expResult = 2022;
        int result = instance.getYears();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTimeSlot method, of class DutySchedule.
     */
    @Test
    public void testGetTimeSlot() {
        System.out.println("getTimeSlot");
        DutySchedule instance = timeSlot;
        Time expResult = timeSlot.getTimeSlot();
        Time result = instance.getTimeSlot();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatus method, of class DutySchedule.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        DutySchedule instance = new DutySchedule();
        boolean expResult = false;
        boolean result = instance.getStatus();
        assertEquals(expResult, result);

        instance = timeSlot;
        expResult = true;
        result = instance.getStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMonth method, of class DutySchedule.
     */
    @Test
    public void testSetMonth() {
        System.out.println("setMonth");
        String month = "FEB";
        DutySchedule instance = new DutySchedule();
        instance.setMonth(month);
    }

    /**
     * Test of setDay method, of class DutySchedule.
     */
    @Test
    public void testSetDay() {
        System.out.println("setDay");
        int day = 0;
        DutySchedule instance = new DutySchedule();
        instance.setDay(day);

    }

    /**
     * Test of setYears method, of class DutySchedule.
     */
    @Test
    public void testSetYears() {
        System.out.println("setYears");
        int years = 2023;
        DutySchedule instance = new DutySchedule();
        instance.setYears(years);
    }

    /**
     * Test of setTimeSlot method, of class DutySchedule.
     */
    @Test
    public void testSetTimeSlot() {
        System.out.println("setTimeSlot");
        Time timeSlot = null;
        DutySchedule instance = new DutySchedule();
        instance.setTimeSlot(timeSlot);
    }

    /**
     * Test of setStatus method, of class DutySchedule.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        boolean status = false;
        DutySchedule instance = new DutySchedule();
        instance.setStatus(status);
    }

    /**
     * Test of checkValidDate method, of class DutySchedule.
     */
    @Test
    public void testCheckValidDate() {
        System.out.println("checkValidDate");
        DutySchedule instance = new DutySchedule();
//        boolean expResult = true;
//        boolean result = instance.checkValidDate();
        instance = new DutySchedule(1, "JAN", 2023);
        assertTrue("TRUE", instance.checkValidDate());

        instance = new DutySchedule(31, "JAN", 2023);
        assertTrue("TRUE", instance.checkValidDate());

        instance = new DutySchedule(28, "FEB", 2023);
        assertTrue("TRUE", instance.checkValidDate());

        instance = new DutySchedule(32, "JAN", 2023);
        assertFalse("FALSE", instance.checkValidDate());
    }

    /**
     * Test of checkDay method, of class DutySchedule.
     */
    @Test
    public void testCheckDay() {
        System.out.println("checkDay");
        DutySchedule instance = new DutySchedule(1, "JAN", 2023, time);
        int month = instance.checkMonth(instance.getMonth());
        boolean expResult = true;
        boolean result = instance.checkDay(month);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkMonth method, of class DutySchedule.
     */
    @Test
    public void testCheckMonth() {
        System.out.println("checkMonth");
        String month = "JAN";
        DutySchedule instance = new DutySchedule();
        int expResult = 1;
        int result = instance.checkMonth(month);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class DutySchedule.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        DutySchedule instance = timeSlot;
        String expResult = String.format("%-2d %3s %4d (%s)", timeSlot.getDay(), timeSlot.getMonth(), timeSlot.getYears(), timeSlot.getTimeSlot());
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
