/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Client;

import Entity.Appointment;
import Entity.Doctor;
import Entity.DutySchedule;
import Entity.Patient;
import Entity.Time;
import java.util.*;

/**
 *
 * @author jensienwong
 */
public class driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        Time[] time = new Time[5];
        DutySchedule[] timeSlot = new DutySchedule[5];
        Appointment[] appointment = new Appointment[5];
        Patient[] patient = new Patient[5];
        Doctor[] doctor = new Doctor[5];

        time[0] = new Time(800, 1000);
        time[1] = new Time(1000, 1200);
        time[2] = new Time(1200, 1400);
        time[3] = new Time(1400, 1600);
        time[4] = new Time(1600, 1800);

        timeSlot[0] = new DutySchedule(1, "JAN", 2022, time[0]);
        timeSlot[1] = new DutySchedule(1, "JAN", 2022, time[1]);
        timeSlot[2] = new DutySchedule(1, "JAN", 2022, time[2]);
        timeSlot[3] = new DutySchedule(1, "JAN", 2022, time[3]);
        timeSlot[4] = new DutySchedule(1, "JAN", 2022, time[4]);

        patient[0] = new Patient("YUE YI CHEN", "2201001", "0121235678", "010903041901", 21, 'M');
        patient[1] = new Patient("GOH KAR MAY", "2202011", "0101112345", "030903042294", 19, 'F');
        patient[2] = new Patient("IVY NG KAH YIN", "2203111", "0172514318", "980615040882", 24, 'F');
        patient[3] = new Patient("CHOO QING YAO", "2204212", "01112345678", "020218140991", 20, 'M');
        patient[4] = new Patient("YE WEN", "2205212", "0121235678", "010903041901", 21, 'M');

        doctor[0] = new Doctor("Bryan Ng", 45, "M");
        doctor[1] = new Doctor("Muhammad Ali", 77, "M");
        doctor[2] = new Doctor("James Tan", 23, "M");
        doctor[3] = new Doctor("John", 50, "M");
        doctor[4] = new Doctor("Fatimah", 30, "F");

        appointment[0] = new Appointment(timeSlot[0], patient[0], doctor[0]);
        appointment[1] = new Appointment(timeSlot[1], patient[1], doctor[1]);
        appointment[2] = new Appointment(timeSlot[2], patient[2], doctor[1]);
        appointment[3] = new Appointment(timeSlot[3], patient[3], doctor[1]);
        appointment[4] = new Appointment(timeSlot[4], patient[4], doctor[1]);

//        String selection;
//        int number;
//
//        do {
//            do {
//                number = 0;
//
//                System.out.println("View Doctor Schedule");
//                System.out.println("--------------------");
//
//                for (Doctor d : doctor) {
//                    String str = String.format("%d. %s", number + 1, d.getName());
//                    System.out.println(str);
//                    number++;
//                }
//                System.out.print("\nEnter a Number: ");
//                selection = sc.nextLine();
//
//               if(selection.equals("")){
//                    selection = "-1";
//                }
//
//                for (int a = 0; a < selection.length(); a++) {
//                    if (!Character.isDigit(selection.charAt(a))) {
//                        selection = "-1";
//                    }
//                }
//
//                if (Integer.parseInt(selection) > number || Integer.parseInt(selection) <= 0) {
//                    System.out.println("Please Enter a valid number\n");
//                }
//
//            } while (Integer.parseInt(selection) > number || Integer.parseInt(selection) <= 0);
//
//            
//            
//            
//            String docName = doctor[Integer.parseInt(selection) - 1].getName();
//            System.out.println("\n");
//            int numOfRecord = 0;
//            System.out.println(String.format("%2s %-15s  %-25s   %-15s   %-27s", "ID", "Appointment No", "Patient Name", "Docter", "Date & Time"));
//            System.out.println(String.format("%2s %-15s  %-25s   %-15s   %-27s", "--", "--------------", "-------------------------", "---------------", "---------------------------"));
//            for (Appointment ap : appointment) {
//                if (ap.getDoctor().getName() == docName) {
//                    System.out.println(String.format("%2s ", numOfRecord+1) + ap.toString());
//                    numOfRecord++;
//                }
//            }
//            if(numOfRecord == 0){
//                System.out.println("\nNo Record Found.");
//            }else{
//                System.out.println("\nNumber Of Record: " + numOfRecord);
//            }
//            
//
//            System.out.println("\n\nEnter 0 to Exit");
//            selection = sc.nextLine();
//            System.out.println("\n\n");
//
//        } while (!selection.equals("0"));
    }
}
