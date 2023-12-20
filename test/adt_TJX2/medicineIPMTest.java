/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package adt_TJX2;

import Entity.Medicine;
import adt_TJX.medicineIPM;
import adt_TJX.ListInterfaceTJX;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author User
 */
public class medicineIPMTest {
    private static final ListInterfaceTJX<Medicine> medicineList = new medicineIPM<>(); 
    
    
    public medicineIPMTest() {
    }

    @Before
    public void setUp() {
        
        Medicine[] m = new Medicine[4];
        m[0] = new Medicine("Painkiller", 10.5, 10, "Pain relievers are medicines that reduce or relieve headaches,\n sore muscles, arthritis, or other aches and pains. \nThere are many different pain medicines, and each one has advantages and risks. \nSome types of pain respond better to certain medicines than others.\n");
        m[1] = new Medicine("Antibiotics ", 11.5, 10, "Antibiotics are medicines that fight infections caused by bacteria\n in humans and animals by either killing the bacteria or \n making it difficult for the bacteria to grow and multiply. Bacteria are germs.");
        m[2] = new Medicine("Antipyretics", 9.5, 10, "Antipyretics block or reverse fever's cytokine-mediated rise in\n core temperature, but do not affect body temperature in the afebrile state. \nThey are to be distinguished from hypothermia agents (cryogens),\n which are capable of lowering core temperature even in the absence of fever.\n");
        m[3] = new Medicine("Vitamins", 12.5, 10, "Some vitamins help you resist infections and keep your nerves healthy,\n while others may help your body get energy from food or help your blood clot properly.");

        medicineList.add(m[0]);
        medicineList.add(m[1]);
        medicineList.add(m[2]);
        medicineList.add(m[3]);
    }

    /**
     * Test of replace method, of class medicineIPM.
     */
    @Test
    public void testReplace() {
        //Edit Data
        int position = 1;
        String EName = "Edit Medicine";
        double EPrice = 25;
        int EStore = 100;
        String EDetail = "This is a edit medicine for testing.";
        
        //Show Old Data
        Medicine oldMedicine = medicineList.getEntry(position);
        System.out.println(oldMedicine.getMedicine());
        System.out.println(oldMedicine.getPrice());
        System.out.println(oldMedicine.getStore());
        System.out.println(oldMedicine.getDetail());

        //Replace it
        medicineList.replace(position, new Medicine(EName, EPrice, EStore, EDetail));

        // Check the edited data
        Medicine newMedicine = medicineList.getEntry(position);
        System.out.println(newMedicine.getMedicine());
        System.out.println(newMedicine.getPrice());
        System.out.println(newMedicine.getStore());
        System.out.println(newMedicine.getDetail());
        
        assertEquals("Medicine name should match", EName, newMedicine.getMedicine());
        assertEquals("Medicine price should match", EPrice, newMedicine.getPrice(), 0.01);
        assertEquals("Medicine store should match", EStore, newMedicine.getStore());
        assertEquals("Medicine detail should match", EDetail, newMedicine.getDetail());
        
    }

    // /**
    //  * Test of add method, of class medicineIPM.
    //  */
    // @Test
    // public void testAdd() {
    //     String newName = "New Medicine";
    //     double newPrice = 15.0;
    //     int newStore = 5;
    //     String newDetail = "This is a new medicine for testing.";

    //     // When
    //     Medicine newMedicine = new Medicine(newName, newPrice, newStore, newDetail);
    //     medicineList.add(newMedicine);

    //     // Then
    //     Medicine lastMedicine = medicineList.getEntry(medicineList.getNumberOfEntries());

    //     assertEquals("Medicine name should match", newName, lastMedicine.getMedicine());
    //     assertEquals("Medicine price should match", newPrice, lastMedicine.getPrice(), 0.001);
    //     assertEquals("Medicine store should match", newStore, lastMedicine.getStore());
    //     assertEquals("Medicine detail should match", newDetail, lastMedicine.getDetail());
    // }
//
//    /**
//     * Test of remove method, of class medicineIPM.
//     */
//    @Test
//    public void testRemove() {
//    }
//
//    /**
//     * Test of getEntry method, of class medicineIPM.
//     */
//    @Test
//    public void testGetEntry() {
//    }
//
//    /**
//     * Test of getNumberOfEntries method, of class medicineIPM.
//     */
//    @Test
//    public void testGetNumberOfEntries() {
//    }
//
//    /**
//     * Test of isEmpty method, of class medicineIPM.
//     */
//    @Test
//    public void testIsEmpty() {
//    }
//
//    /**
//     * Test of toString method, of class medicineIPM.
//     */
//    @Test
//    public void testToString() {
//    }
//
//    /**
//     * Test of addEntry method, of class medicineIPM.
//     */
//    @Test
//    public void testAddEntry() {
//    }
    
}
