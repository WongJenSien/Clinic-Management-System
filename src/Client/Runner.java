/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import adt_patience.LinkedList;
import adt_patience.ListInterface;
import entity.Patient;
import java.util.Scanner;

public class Runner {
    
    public static Runner clientProgram = new Runner();
    
    private static ListInterface<Patient> patientList = new LinkedList<>();
    public static int patientPosition;
    Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        initializeCollection();
        clientProgram.mainMenu();
    }
     private static void initializeCollection() {
         int index = 5;
         Patient[] p = new Patient[index];

        p[0] = new Patient("YUE YI CHEN", "2201001", "0121235678", "010903041901", 21, 'M');
        p[1] = new Patient("GOH KAR MAY", "2202011", "0101112345", "030903042294", 19, 'F');
        p[2] = new Patient("IVY NG KAH YIN", "2203111", "0172514318", "980615040882", 24, 'F');
        p[3] = new Patient("CHOO QING YAO", "2204212", "01112345678", "020218140991", 20, 'M');
        p[4] = new Patient("YE WEN", "2205212", "0121235678", "010903041901", 21, 'M');

     }
     
     public void mainMenu() {
         userLogIn();
     }
     
     public void userLogIn() {

        boolean found = false;
        int foundIndex = -1;
        sc.nextLine();
        do {

            System.out.println("LOGIN\n============");
            System.out.print("Please enter your studentID : ");
            String id = sc.nextLine();

            //search record
            for (int index = 1; index <= patientList.getNumberOfEntries(); index++) {
                if (id.equals(patientList.getEntry(index).getStudentID())) {
                    found = true;
                    foundIndex = index;
                    break;
                } else {
                    found = false;
                }
            }

            //Register
            if (!found) {
                String name, studentID, phoneNum, icNum;
                char gender;
                int age;
                System.out.print("Register New User\n=================\n ");
                System.out.print("Enter Name: ");
                name = sc.nextLine();
                System.out.print("Enter Student ID: ");
                studentID = sc.nextLine();
                System.out.print("Enter Phone No.: ");
                phoneNum = sc.nextLine();
                System.out.print("Enter Ic No.: ");
                icNum = sc.nextLine();
                System.out.print("Enter Age: ");
                age = sc.nextInt();
                System.out.print("Gender (M/F) : ");
                gender = sc.next().charAt(0);

                Patient p = new Patient(name, studentID, phoneNum, icNum, age, gender);
                patientList.add(p);

                System.out.println("Successfull register!Please login again\n\n\n");
                sc.nextLine();

            }
        } while (!found);
        System.out.println("\n\n\nSuccessful Login!\n");

        patientPosition = foundIndex;

        
        //check id exist in the patient list
        // if yes proceed else register
    }
}
