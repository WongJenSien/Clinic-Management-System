/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package adt_TJX;

import Entity.Medicine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;


/**
 *
 * @author User
 */
public class medicineIPMTest {
    private static final ListInterfaceTJX<Medicine> medicineList = new medicineIPM<>(); 
    
    
    public medicineIPMTest() {
    }

    @BeforeEach
    public void setUp() {
        int index = 5;

        Medicine[] m = new Medicine[index];
        m[0] = new Medicine("Painkiller", 10.5, 10, "Pain relievers are medicines that reduce or relieve headaches,\n sore muscles, arthritis, or other aches and pains. \nThere are many different pain medicines, and each one has advantages and risks. \nSome types of pain respond better to certain medicines than others.\n");
        m[1] = new Medicine("Antibiotics ", 11.5, 10, "Antibiotics are medicines that fight infections caused by bacteria\n in humans and animals by either killing the bacteria or \n making it difficult for the bacteria to grow and multiply. Bacteria are germs.");
        m[2] = new Medicine("Antipyretics", 9.5, 10, "Antipyretics block or reverse fever's cytokine-mediated rise in\n core temperature, but do not affect body temperature in the afebrile state. \nThey are to be distinguished from hypothermia agents (cryogens),\n which are capable of lowering core temperature even in the absence of fever.\n");
        m[3] = new Medicine("Vitamins", 12.5, 10, "Some vitamins help you resist infections and keep your nerves healthy,\n while others may help your body get energy from food or help your blood clot properly.");
        m[4] = new Medicine("Morphine", 8, 10, "Morphine is used to relieve severe pain, such as pain caused by a major trauma or\n surgery, labour pain in childbirth or cancer pain.");

        for (Medicine m1 : m) {
            medicineList.add(m1);
        }
    }

    /**
     * Test of add method, of class medicineIPM.
     */
    @Test
    public void testAdd() {
        String newName = "New Medicine";
        double newPrice = 15.0;
        int newStore = 5;
        String newDetail = "This is a new medicine for testing.";

        // When
        Medicine newMedicine = new Medicine(newName, newPrice, newStore, newDetail);
        medicineList.add(newMedicine);

        // Then
        Medicine lastMedicine = medicineList.getEntry(medicineList.getNumberOfEntries());

        assertEquals("Medicine name should match", newName, lastMedicine.getMedicine());
        assertEquals("Medicine price should match", newPrice, lastMedicine.getPrice(), 0.001);
        assertEquals("Medicine store should match", newStore, lastMedicine.getStore());
        assertEquals("Medicine detail should match", newDetail, lastMedicine.getDetail());
        fail("hihi");
    }

    /**
     * Test of remove method, of class medicineIPM.
     */
    @Test
    public void testRemove() {
    }

    /**
     * Test of replace method, of class medicineIPM.
     */
    @Test
    public void testReplace() {
    }

    /**
     * Test of getEntry method, of class medicineIPM.
     */
    @Test
    public void testGetEntry() {
    }

    /**
     * Test of getNumberOfEntries method, of class medicineIPM.
     */
    @Test
    public void testGetNumberOfEntries() {
    }

    /**
     * Test of isEmpty method, of class medicineIPM.
     */
    @Test
    public void testIsEmpty() {
    }

    /**
     * Test of toString method, of class medicineIPM.
     */
    @Test
    public void testToString() {
    }

    /**
     * Test of addEntry method, of class medicineIPM.
     */
    @Test
    public void testAddEntry() {
    }
    
}
