/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author jensienwong
 */
public class Treatment {

    private String treatment;
    private Medicine medicine;
    private String venue;
    private double price;

    public Treatment() {
    }

    public Treatment(String treatment, Medicine medicine, String venue, double price) {
        this.treatment = treatment;
        this.medicine = medicine;
        this.venue = venue;
        this.price = price;
    }

    //Setter
    public void setMedicalServices(String treatment) {
        this.treatment = treatment;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //Getter
    public String getTreatment() {
        return treatment;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public String getVenue() {
        return venue;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return String.format("%-26s %-22s %-12s %.2f",treatment, medicine.getMedicine(), venue, price);
    }
}
