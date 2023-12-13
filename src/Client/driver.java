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
import Entity.Treatment;
import java.util.*;

/**
 *
 * @author jensienwong
 */
public class driver {

    /**
     * @param args the command line arguments
     */
    public static Scanner sc = new Scanner(System.in);
    public static Time[] time = new Time[5];
    public static DutySchedule[] timeSlot = new DutySchedule[5];
    public static Appointment[] appointment = new Appointment[100];
    public static Patient[] patient = new Patient[5];
    public static Doctor[] doctor = new Doctor[5];
    public static Treatment[] treatment = new Treatment[5];

    public static void main(String[] args) {
        // TODO code application logic here
        preInfo();

        int day = 0, years = 0, selection;
        String month = "";
        boolean result = true;
        String num;

        Appointment[] array = appointment;
        Time[] bookedTimeSlot = new Time[time.length];
        Time[] validTimeSlot = new Time[time.length];

        Patient user = patient[0];
        DutySchedule duty = new DutySchedule();
        Time selectedTime = new Time();
        Treatment selectedTreatment = new Treatment();
        Doctor selectedDoctor = new Doctor();

        int index;

        // Input Date
        do {
            for (int a = 0; a < time.length; a++) {
                bookedTimeSlot[a] = null;
                validTimeSlot[a] = null;
            }
            do {

                // Display error message
                if (result) {
                    System.out.println("\n\nExample");
                    System.out.println("+--------------------------------------+");
                    System.out.println("|        Enter Date: 1 JAN 2022        |");
                    System.out.println("+--------------------------------------+\n\n");
                } else {
                    System.out.println("Invalid Date Please Enter Again\n");
                }

                //Capture Date Input
                System.out.print("Enter Date : ");

                String date = sc.nextLine();

                num = "";
                int repeat = 1;

                //Define the Date, Month and Years
                if (!date.isEmpty()) {

                    for (int a = 0; a < date.length(); a++) {

                        if (date.charAt(a) == ' ') {
                            switch (repeat) {
                                case 1:
                                    day = Integer.parseInt(num);
                                    num = "";
                                    repeat++;
                                    break;
                                case 2:
                                    month = num;
                                    num = "";
                                    repeat++;
                                    break;
                            }
                        } else {
                            if (repeat == 1) {
                                if (Character.isDigit(date.charAt(a))) {
                                    num += date.charAt(a);
                                } else {
                                    num = "0";
                                }

                            } else if (repeat == 2) {
                                num += date.charAt(a);
                                month = num;
                            } else {
                                num += date.charAt(a);
                            }

                        }
                    }
                    for(int a = 0 ; a < num.length() ; a++){
                    if(!Character.isDigit(num.charAt(a))){
                        num = "0";
                    }
                    }

                    years = Integer.parseInt(num);
                    month = month.toUpperCase();

                    // Check Date Validation
                    duty = new DutySchedule(day, month, years);
                    result = duty.checkValidDate();
                } else {
                    result = false;
                }
                //True == Valid Date
                //Fasel == Invalid Date
            } while (!result);
            System.out.println("\n");

            // Show Valid Date
            // check Date 
            index = 0;
            for (int a = 0; a < array.length; a++) {
                if (array[a] == null) {
                    break;
                }
                int apDay = array[a].getDutySchedule().getDay();
                String apMonth = array[a].getDutySchedule().getMonth();
                int apYear = array[a].getDutySchedule().getYears();

                if (apDay == day && apMonth.equals(month) && apYear == years) {
                    //same day
                    for (int b = 0; b < time.length; b++) {
                        if (time[b].equals(array[a].getDutySchedule().getTimeSlot())) {
                            bookedTimeSlot[b] = time[b];

                        }
                    }

                }
            }
            index = 0;

            for (int b = 0; b < time.length; b++) {
                if (bookedTimeSlot[b] != null) {
                    index++;
                }
            }

            if (index == time.length) {
                System.out.println("Time Slot in the day is full.");
                System.out.print("Press Enter to Continue...");
                sc.nextLine();
                index = 0;
            } else {
                index = 0;

                for (int a = 0; a < time.length; a++) {
                    if (bookedTimeSlot[a] == null) {
                        validTimeSlot[index] = time[a];
                        index++;
                    }
                }
                do {

                    for (int a = 0; a < index; a++) {
                        if (validTimeSlot[a] != null) {
                            System.out.println(String.format("%2d. %s", a + 1, validTimeSlot[a]));
                        }
                    }

                    System.out.print("\nSelect a Time Slot : ");
                    selection = sc.nextInt();

                    if (selection > index || selection < 0) {
                        System.out.println("Please enter a valid number...\n");
                    }

                } while (selection > index || selection < 0);

                selectedTime = validTimeSlot[selection - 1];
            }

        } while (index == 0);
        duty = new DutySchedule(day, month, years, selectedTime);

        //Retrieve All the Treatment and Store into allTreatment
        System.out.println("\n\n=======================================================");
        System.out.println("|No. |Medical Service Name      |Venue       |Price   |");
        System.out.println("=======================================================");

        do {
            //Select Select Treatment
            for (int a = 0; a < treatment.length; a++) {
                System.out.println(String.format("%2d. %s", a + 1, treatment[a]));
            }
            System.out.print("\nEnter your selection : ");
            selection = sc.nextInt();

            if (selection > treatment.length || selection < 0) {
                System.out.println("Please enter a valid number...\n");
            }

        } while (selection > treatment.length || selection < 0);

        selectedTreatment = treatment[selection - 1];
        System.out.println("\n\n");
        do {
            //Select Select Treatment
            for (int a = 0; a < doctor.length; a++) {
                System.out.println(String.format("%2d. %s", a + 1, doctor[a].getName()));
            }
            System.out.print("\nEnter your selection : ");
            selection = sc.nextInt();

            if (selection > doctor.length || selection < 0) {
                System.out.println("Please enter a valid number...\n");
            }

        } while (selection > doctor.length || selection < 0);
        selectedDoctor = doctor[selection - 1];

        System.out.println("\n\nAppointment Information");
        System.out.println("------------------------");
        System.out.println("User: " + user.getName() + " (" + user.getStudentID() + ")");
        System.out.println("Date: " + duty.getDay() + " " + duty.getMonth() + " " + duty.getYears() + " (" + duty.getTimeSlot() + ")");
        System.out.println("Doctor: " + selectedDoctor.getName());
        System.out.println("Treatment: " + selectedTreatment.getTreatment() + " (" + selectedTreatment.getVenue() + ")");

        System.out.print("\nConfirm Apppintment Information ? ( Y = yes ) :");
        String answer = sc.next();

        if (answer.equals("Y") || answer.equals("y")) {
            for (int a = 0; a < appointment.length; a++) {
                if (appointment[a] == null) {
                    appointment[a] = new Appointment(duty, user, selectedDoctor, selectedTreatment);
                    System.out.println("\nNew Appointment Added Successfully");
                    break;
                }
            }
        } else {
            System.out.println("\nNew Appointment Added Failed");
        }

        System.out.println("\n\nView Appointment");
        System.out.println("----------------");
        for (int a = 0; a < appointment.length; a++) {
            if (appointment[a] != null && appointment[a].getPatient().getStudentID().equals(user.getStudentID())) {
                System.out.println(appointment[a]);
            }
        }

    }

    public static void preInfo() {
        time[0] = new Time(800, 1000);
        time[1] = new Time(1000, 1200);
        time[2] = new Time(1200, 1400);
        time[3] = new Time(1400, 1600);
        time[4] = new Time(1600, 1800);

        timeSlot[0] = new DutySchedule(1, "JAN", 2022, time[0]);
        timeSlot[1] = new DutySchedule(2, "JAN", 2022, time[1]);
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

        treatment[0] = new Treatment("Blood Test", "Room B1000", 150);
        treatment[1] = new Treatment("Covid Test", "Room J0009", 100);
        treatment[2] = new Treatment("X-ray", "Room Y00008", 250);
        treatment[3] = new Treatment("Body Check Up", "Room Z0002", 150);
        treatment[4] = new Treatment("Physiotherapy", "Room R00002", 300);

        appointment[0] = new Appointment(timeSlot[0], patient[0], doctor[0], treatment[0]);
        appointment[1] = new Appointment(timeSlot[1], patient[1], doctor[1], treatment[0]);
        appointment[2] = new Appointment(timeSlot[2], patient[2], doctor[1], treatment[0]);
        appointment[3] = new Appointment(timeSlot[3], patient[3], doctor[1], treatment[0]);
        appointment[4] = new Appointment(timeSlot[4], patient[4], doctor[1], treatment[0]);

    }
}
