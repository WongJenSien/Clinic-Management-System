/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package adt_LXC;

import entity.Treatment;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


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
        ArrayListLXC<Treatment> treatmentList = new ArrayListLXC<>();

        // Creating Treatment objects
        Treatment treatment1 = new Treatment("bloodTest", "ROOM 101", 50.0, "this is a blood test");
        Treatment treatment2 = new Treatment("hihiihi", "ROOM 909", 80.0, "hihi");

        // Adding Treatment objects to the list
        treatmentList.add(treatment1);
        treatmentList.add(treatment2);

        // Checking the size and contents of the list
        assertEquals(2, treatmentList.getNumberOfEntries());
        assertTrue(treatmentList.contains(treatment1));
        assertTrue(treatmentList.contains(treatment2));
        
    }

    /**
     * Test of add method, of class ArrayListLXC.
     */
    @Test
    public void testAdd_int_GenericType() {
        ArrayListLXC<Treatment> treatmentList = new ArrayListLXC<>();

        // Creating Treatment objects
      Treatment treatment1 = new Treatment("bloodTest", "ROOM 101", 50.0, "this is a blood test");
        Treatment treatment2 = new Treatment("hihiihi", "ROOM 909", 80.0, "hihihihiihihiihi");

        // Adding Treatment objects to specific positions in the list
        treatmentList.add(1, treatment1);
        treatmentList.add(2, treatment2);

        // Creating a new Treatment object
        Treatment newTreatment = new Treatment("Covid-19", "Room 409", 25.0, "This is covid-19 test");

        // Inserting a new Treatment object at the beginning (position 1)
        assertTrue(treatmentList.add(1, newTreatment));

        // Checking the size and contents of the list
        assertEquals(3, treatmentList.getNumberOfEntries());
        assertEquals(newTreatment, treatmentList.getEntry(1));
        assertEquals(treatment1, treatmentList.getEntry(2));
        assertEquals(treatment2, treatmentList.getEntry(3));
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
       
    }

    /**
     * Test of contains method, of class ArrayListLXC.
     */
    @Test
    public void testContains() {
      
    }

    /**
     * Test of getNumberOfEntries method, of class ArrayListLXC.
     */
    @Test
    public void testGetNumberOfEntries() {
        
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
    
}
