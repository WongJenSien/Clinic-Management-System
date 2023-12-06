/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author KimJun
 */
public class Medicine {

    private String medicine;
    private double price;
    private int store;
    private String detail;

    public Medicine() {
    }

    public Medicine(String medicine, double price, int store, String detail) {
        this.medicine = medicine;
        this.price = price;
        this.store = store;
        this.detail = detail;
    }

    //Getter
    public String getMedicine() {
        return medicine;
    }

    public double getPrice() {
        return price;
    }

    public int getStore() {
        return store;
    }

    public String getDetail() {
        return detail;
    }

    //setter
    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStore(int store) {
        this.store = store;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    //ToString
    public String toString() {
        return String.format("Medicine: %s \n Price: %.2f \n Store : %d \n Detail : %s", medicine, price, store, detail);
    }

}
