/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Entity;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author jensienwong
 */
public class AppointmentTest {

    Time time = new Time();
    DutySchedule timeSlot = new DutySchedule();
    Patient patient = new Patient();
    Doctor doctor = new Doctor();
    Treatment treatment = new Treatment();
    Appointment appointment = new Appointment();

    public AppointmentTest() {
        time = new Time(800, 1000);
        timeSlot = new DutySchedule(1, "JAN", 2022, time);
        patient = new Patient("YUE YI CHEN", "2201001", "0121235678", "010903041901", 21, 'M');
        doctor = new Doctor("Bryan Ng", 45, "M");
        treatment = new Treatment("Blood Test", "Room B1000", 150);
        appointment = new Appointment(timeSlot, patient, doctor, treatment);
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("* AppointmentTest: Start *");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("* AppointmentTest: End *");
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    /**
     * Test of getDutySchedule method, of class Appointment.
     */
    @Test
    public void testGetDutySchedule() {
        System.out.println("getDutySchedule");
        Appointment instance = appointment;
        DutySchedule expResult = timeSlot;
        DutySchedule result = instance.getDutySchedule();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPatient method, of class Appointment.
     */
    @Test
    public void testGetPatient() {
        System.out.println("getPatient");
        Appointment instance = appointment;
        Patient expResult = patient;
        Patient result = instance.getPatient();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAppointmentNumber method, of class Appointment.
     */
    @Test
    public void testGetAppointmentNumber() {
        System.out.println("getAppointmentNumber");
        Appointment instance = appointment;
        String expResult = appointment.getAppointmentNumber();
        String result = instance.getAppointmentNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDoctor method, of class Appointment.
     */
    @Test
    public void testGetDoctor() {
        System.out.println("getDoctor");
        Appointment instance = appointment;
        Doctor expResult = doctor;
        Doctor result = instance.getDoctor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTreatment method, of class Appointment.
     */
    @Test
    public void testGetTreatment() {
        System.out.println("getTreatment");
        Appointment instance = appointment;
        Treatment expResult = treatment;
        Treatment result = instance.getTreatment();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDutySchedule method, of class Appointment.
     */
    @Test
    public void testSetDutySchedule() {
        System.out.println("setDutySchedule");
        DutySchedule timeSlot = new DutySchedule(2, "JAN", 2022, new Time(1000, 1200));
        Appointment instance = appointment;
        instance.setDutySchedule(timeSlot);
        assertEquals(timeSlot, instance.getDutySchedule());
    }

    /**
     * Test of setDoctor method, of class Appointment.
     */
    @Test
    public void testSetDoctor() {
        System.out.println("setDoctor");
        Doctor doctor = new Doctor("Muhammad Ali", 77, "M");
        Appointment instance = appointment;
        instance.setDoctor(doctor);
        assertEquals(doctor, instance.getDoctor());
    }

    /**
     * Test of setTreatment method, of class Appointment.
     */
    @Test
    public void testSetTreatment() {
        System.out.println("setTreatment");
        Treatment treatment = new Treatment("Covid Test", "Room J0009", 100);
        Appointment instance = appointment;
        instance.setTreatment(treatment);
        assertEquals(treatment, instance.getTreatment());
    }

    /**
     * Test of setPatient method, of class Appointment.
     */
    @Test
    public void testSetPatient() {
        System.out.println("setPatient");
        Patient p = new Patient("GOH KAR MAY", "2202011", "0101112345", "030903042294", 19, 'F');
        Appointment instance = appointment;
        instance.setPatient(p);
        assertEquals(p, instance.getPatient());
    }

    /**
     * Test of toString method, of class Appointment.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Appointment instance = appointment;
        String expResult = String.format("%-14s   %-15s (%-5s)   %-15s   %27s %s (%s)", appointment.getAppointmentNumber(), patient.getName(), patient.getStudentID(), doctor.getName(), timeSlot, treatment.getTreatment(), treatment.getVenue());
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of appointmentNoGenerator method, of class Appointment.
     */
    @Test
    public void testAppointmentNoGenerator() {
        System.out.println("appointmentNoGenerator");
        Appointment instance = appointment;
        String expResult = appointment.getAppointmentNumber();
        String result = instance.getAppointmentNumber();
        assertEquals(expResult, result);
    }

}
