/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package adt_TJX;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author User
 */
public class medicineIPMTest {
    
    public medicineIPMTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of add method, of class medicineIPM.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Object newEntry = null;
        medicineIPM instance = new medicineIPM();
        boolean expResult = false;
        boolean result = instance.add(newEntry);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class medicineIPM.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        int givenPosition = 0;
        medicineIPM instance = new medicineIPM();
        Object expResult = null;
        Object result = instance.remove(givenPosition);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of replace method, of class medicineIPM.
     */
    @Test
    public void testReplace() {
        System.out.println("replace");
        int givenPosition = 1;
        Object newEntry = null;
        medicineIPM instance = new medicineIPM();
        instance.addEntry("Entry1");
        instance.addEntry("Entry2");
        instance.addEntry("Entry3");
        boolean expResult = false;
        boolean result = instance.replace(givenPosition, newEntry);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEntry method, of class medicineIPM.
     */
    @Test
    public void testGetEntry() {
        System.out.println("getEntry");
        int givenPosition = 0;
        medicineIPM instance = new medicineIPM();
        Object expResult = null;
        Object result = instance.getEntry(givenPosition);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumberOfEntries method, of class medicineIPM.
     */
    @Test
    public void testGetNumberOfEntries() {
        System.out.println("getNumberOfEntries");
        medicineIPM instance = new medicineIPM();
        int expResult = 0;
        int result = instance.getNumberOfEntries();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class medicineIPM.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        medicineIPM instance = new medicineIPM();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class medicineIPM.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        medicineIPM instance = new medicineIPM();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
