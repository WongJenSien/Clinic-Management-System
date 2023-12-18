/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package adt_TJX;

import Entity.Medicine;
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
    private static final ListInterfaceTJX<Medicine> medicineList = new medicineIPM<>();
    
    
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
     * Test of replace method, of class medicineIPM.
     */
    @Test
    public void testReplace() {
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
        
        String medicine = "";
        double price = 0.0;
        int store = 1;
        String detail = "";
        
        System.out.println("replace");
        int givenPosition = 1;
        boolean expResult = false;
        boolean result = medicineList.replace(givenPosition, new Medicine(medicine, price, store, detail));
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
