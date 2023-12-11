/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author jensienwong
 */
public class Treatment {

    private String treatment;
    private String description;
    private String venue;
    private double price;


    public Treatment() {
    }

    public Treatment(String treatment, String venue, double price,String description) {
        this.treatment = treatment;
        this.description = description;
        this.venue = venue;
        this.price = price;
    }

    //Setter
    public void setTreatmentServices(String treatment) {
        this.treatment = treatment;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String description(){
        return description;
    }

    public String getVenue() {
        return venue;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return String.format("%-26s %-12s %.2f %-20s",treatment, venue, price, description);
    }
}
