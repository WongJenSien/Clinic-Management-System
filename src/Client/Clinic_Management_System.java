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

/**
 *
 * @author jensienwong
 */
public class Clinic_Management_System {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

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

        for (int a = 0; a < 5; a++) {

            if (appointment[a].getDoctor().getName() == "Muhammad Ali") {
                System.out.println(appointment[a].toString());
            }

        }

    }

//     public void doctorMainMenu() {
//        String[] menu = {"Doctor Module", "Schedule", "Treatment", "Medicine", "Exit"};
//        int selection;
//
//        // Display Menu
//        do {
//            for (int a = 0; a < menu.length; a++) {
//                System.out.println(String.format("%2d. %s", a + 1, menu[a]));
//            }
//            System.out.print("Enter Your Selection: ");
//            selection = sc.nextInt();
//        } while (selection > menu.length || selection <= 0);
//
//        // Take Action
//        switch (selection) {
//            case 1:
//                //Profile
//                doctorModule();
//                break;
//            case 2:
//                //Check Schedule
//                doctorSchedule();
//                break;
//            case 3:
//                //Check Treatment
//                treatmentMenu();
//                break;
//            case 4:
//                //Check Medicine
//                doctorMedicine();
//                break;
//            case 5:
//                //Exit
//                System.out.println("Exit");
//                mainMenu();
//                break;
//            default:
//                System.out.println("Invalid Selection Please Enter Again...");
//                System.out.println("Press Enter To Continue...");
//                sc.nextLine();
//                doctorMainMenu();
//        }
//
//    }
}
