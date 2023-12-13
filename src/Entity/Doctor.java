/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author jensienwong
 */
public class Doctor {

    private String name;
    private int age;
    private Treatment representative;
    private String gender;

    public Doctor() {
    }

    public Doctor(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Doctor(String name, int age, Treatment representative, String gender) {
        this.name = name;
        this.age = age;
        this.representative = representative;
        this.gender = gender;
    }

    //GETTER
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Treatment getRepresentative() {
        return representative;
    }

    public String getGender() {
        return gender;
    }

    //SETTER
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setRepresentative(Treatment representative) {
        this.representative = representative;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    //ToString
    public String toString() {
        return String.format("%20s %15d %10s", name, age, gender);
    }
//
//    public String toString() {
//        return String.format("%20s %15d %37s %10s %20s", name, age, representative.getTreatment(), gender, representative.getVenue());
//    }

}
