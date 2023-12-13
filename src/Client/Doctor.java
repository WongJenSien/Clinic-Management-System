/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

/**
 *
 * @author wongh
 */
public class Doctor {
    String name;
    String specialization;
    int doctorNumber;
    boolean isActive;
    
    public Doctor(String name, String specialization, int doctorNumber, boolean isActive) {
         this.name = name;
        this.specialization = specialization;
        this.doctorNumber = doctorNumber;
        this.isActive = isActive;
    }

  @Override
    public String toString() {
        String status = isActive ? "Active" : "Inactive";
        return "Doctor #" + doctorNumber + ": " + name + " (" + specialization + ") - Status: " + status;
    }
}
