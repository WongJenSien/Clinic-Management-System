/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package adt_LXC2;

import adt_LXC.ArrayListLXC;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import entity.Treatment;
import adt_LXC.ArrayListLXC;
import adt_LXC.ListInterfaceLXC;

/**
 *
 * @author laixi
 */
public class ArrayListLXCTest {

    public ArrayListLXCTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class ArrayListLXC.
     */
    @Test
    public void testAdd_GenericType() {
        String newTreatment = "hihi ";
        String newVenue = "Room 101";
        double newPrice = 150;
        String newDesc = "hello world";

        // When
        Treatment newMedicine = new Treatment(newTreatment, newVenue, newPrice, newDesc);
        treatmentList.add(newMedicine);

        // Then
        Treatment treatment = medicineList.getEntry(medicineList.getNumberOfEntries());

        assertEquals("Medicine name should match", newTreatment, last());
        assertEquals("Medicine store should match", newVenue, lastMedicine.getStore());
        assertEquals("Medicine price should match", newPrice, lastMedicine.getPrice(), 0.001);
        assertEquals("Medicine detail should match", newDesc, lastMedicine.getDetail());
    }
}

/**
 * Test of add method, of class ArrayListLXC.
 */
@Test
public void testAdd_int_GenericType() {
     
    }

    /**
     * Test of remove method, of class ArrayListLXC.
     */
    @Test
public void testRemove() {
        
    }

    /**
     * Test of clear method, of class ArrayListLXC.
     */
    @Test
public void testClear() {
       
    }

    /**
     * Test of replace method, of class ArrayListLXC.
     */
    @Test
public void testReplace() {
      
    }

    /**
     * Test of getEntry method, of class ArrayListLXC.
     */
    @Test
public void testGetEntry() {
        System.out.println("getEntry");
        int givenPosition = 0;
        ArrayListLXC instance = new ArrayListLXC();
        Object expResult = null;
        Object result = instance.getEntry(givenPosition);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class ArrayListLXC.
     */
    @Test
public void testContains() {
        System.out.println("contains");
        Object anEntry = null;
        ArrayListLXC instance = new ArrayListLXC();
        boolean expResult = false;
        boolean result = instance.contains(anEntry);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumberOfEntries method, of class ArrayListLXC.
     */
    @Test
public void testGetNumberOfEntries() {
        System.out.println("getNumberOfEntries");
        ArrayListLXC instance = new ArrayListLXC();
        int expResult = 0;
        int result = instance.getNumberOfEntries();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class ArrayListLXC.
     */
    @Test
public void testIsEmpty() {
        
    }

    /**
     * Test of isFull method, of class ArrayListLXC.
     */
    @Test
public void testIsFull() {
        
    }

    /**
     * Test of toString method, of class ArrayListLXC.
     */
    @Test
public void testToString() {
        
    
}
