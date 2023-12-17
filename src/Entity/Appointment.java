/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author jensienwong
 */
public class Appointment {

    public String appointmentNumber;
    public Patient patient;
    public Doctor doctor;
    public DutySchedule timeSlot;
    public Treatment treatment;

    public static int number = 0;

    public Appointment() {
    }

    public Appointment(DutySchedule timeSlot, Patient p, Doctor d, Treatment treatment) {
        this.timeSlot = timeSlot;
        this.treatment = treatment;
        patient = p;
        doctor = d;
        appointmentNumber = appointmentNoGenerator();

    }

    //Getter
    public DutySchedule getDutySchedule() {
        return timeSlot;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getAppointmentNumber() {
        return appointmentNumber;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    //Setter
    public void setDutySchedule(DutySchedule timeSlot) {
        timeSlot = timeSlot;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public void setPatient(Patient p) {
        patient = p;
    }

    //toString
    public String toString() {
        return String.format("%-14s   %-15s (%-5s)   %-15s   %27s %s (%s)", appointmentNumber, patient.getName(), patient.getStudentID(), doctor.getName(), timeSlot, treatment.getTreatment(), treatment.getVenue());
    }

    //METHOD
    public String appointmentNoGenerator() {
        String appointmentNumber = String.format("%s%03d", "MS", number);
        number++;
        return appointmentNumber;
    }

}
