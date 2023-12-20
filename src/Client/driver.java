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
    public static Appointment[] appointment = new Appointment[5];
    public static Patient[] patient = new Patient[5];
    public static Doctor[] doctor = new Doctor[5];
    public static Treatment[] treatment = new Treatment[5];

    public static void main(String[] args) {
        // TODO code application logic here
        preInfo();

        Patient user = patient[0];
        String[] modifyList = {"1. Doctor", "2. Appointment Date and Time", "3. Treatment", "4. End"};
        String answer;

//        Doctor selectedDoc = selectDoctor(appointment[2].getDoctor());
//        System.out.println(selectedDoc);
        Appointment selectedApp = new Appointment();
        Appointment currentApp = new Appointment();

        selectedApp = selectAppointment(user);
        currentApp = selectedApp;

        Doctor newDoc = selectedApp.getDoctor();
        DutySchedule newSchedule = selectedApp.getDutySchedule();
        Treatment newTreatment = selectedApp.getTreatment();

        do {

            answer = selectModify(modifyList);

            switch (answer) {
                case "1":
                    System.out.println("\n");
                    newDoc = selectDoctor(selectedApp.getDoctor());
                    break;
                case "2":
                    newSchedule = selectDateTime(selectedApp.getDutySchedule());

                    break;
                case "3":
                    newTreatment = selectTreatment(selectedApp.getTreatment());
                    break;
            }
        } while (!answer.equals("4"));

        System.out.println("\nCurrent Information");
        System.out.println("-------------------");
        System.out.println(currentApp + "\n");

        System.out.println("\nModified Information");
        System.out.println("--------------------");
        selectedApp.setDoctor(newDoc);
        selectedApp.setDutySchedule(newSchedule);
        selectedApp.setTreatment(newTreatment);
        System.out.println(selectedApp);
    }

    public static String input(int index) {
        String selection = sc.nextLine();

        if (selection.isEmpty()) {
            return "Error: Selection cannot be Empty.";
        }

        for (int a = 0; a < selection.length(); a++) {
            if (!Character.isDigit(selection.charAt(a))) {
                return "Error: Invalid Selection.";
            }
        }

        if (Integer.parseInt(selection) > index || Integer.parseInt(selection) <= 0) {
            return "Error: Invalid Selection.";
        }

        return selection;
    }

    public static String selectModify(String[] modifyList) {

        String answer;
        do {
            System.out.println("\nWhat would you like to modify ?\n");
            for (String list : modifyList) {
                System.out.println(list);
            }

            System.out.print("\nEnter a selection: ");
            answer = input(modifyList.length);

            if (answer.contains("Error")) {
                System.out.println("\n" + answer + " Please Try Again\n");
            }

        } while (answer.contains("Error"));

        return answer;
    }

    public static Doctor selectDoctor(Doctor currentDoc) {

        String answer;
        int numOfDoc = 0;
        Doctor selectedDoc = currentDoc;
        Doctor[] newList = new Doctor[doctor.length - 1];

        do {
            System.out.println("Doctor List");
            System.out.println("-----------");

            for (int a = 0; a < doctor.length; a++) {
                if (doctor[a] != currentDoc) {
                    System.out.println(String.format("%2d. %s", numOfDoc + 1, doctor[a].getName()));
                    newList[numOfDoc] = doctor[a];
                    numOfDoc++;
                }

            }
            System.out.println(String.format("%2d. %s", doctor.length, "Back"));

            System.out.print("\nSelect an Doctor: ");
            answer = input(doctor.length);
            System.out.println("");

            if (answer.contains("Error")) {
                System.out.println(answer + " Please Try Again\n");
            }
        } while (answer.contains("Error"));

        if (Integer.parseInt(answer) != doctor.length) {
            selectedDoc = newList[Integer.parseInt(answer) - 1];
            System.out.println("Modify Successfull...");
            System.out.println(String.format("Doctor: %s -> %s\n", currentDoc.getName(), selectedDoc.getName()));
        }
        return selectedDoc;
    }

    public static Appointment selectAppointment(Patient user) {
        String answer;
        int numOfAp;
        do {
            System.out.println("\nAppointment List");
            numOfAp = 0;
            for (int a = 0; a < appointment.length; a++) {
                if (appointment[a].getPatient().equals(user)) {
                    System.out.println(String.format("%2d. %s", numOfAp + 1, appointment[a]));
                    numOfAp++;
                }
            }

            System.out.print("\nSelect an Appointment to modify: ");
            answer = input(numOfAp);
            System.out.println("");
            if (answer.contains("Error")) {
                System.out.println(answer + " Please Try Again\n");
            }

        } while (answer.contains("Error"));
        numOfAp = 0;
        for (int a = 0; a < appointment.length; a++) {
            if (appointment[a].getPatient().equals(user)) {
                if (numOfAp == Integer.parseInt(answer) - 1) {
                    return appointment[a];
                }
                numOfAp++;
            }
        }

        return new Appointment();

    }

    public static DutySchedule selectDateTime(DutySchedule currentDateTime) {

        int day = 0, years = 0, selection;
        String month = "";
        boolean result = true;
        String num;

        Appointment[] array = appointment;
        Time[] bookedTimeSlot = new Time[time.length];
        Time[] validTimeSlot = new Time[time.length];

        DutySchedule duty = currentDateTime;
        Time selectedTime = new Time();

        int index;

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
                System.out.print("Enter Date ( Enter 'BACK' to cancel ): ");

                String date = sc.nextLine();

                num = "";
                int repeat = 1;

                if (date.toUpperCase().equals("BACK")) {
                    return currentDateTime;
                }

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
                    for (int a = 0; a < num.length(); a++) {
                        if (!Character.isDigit(num.charAt(a))) {
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
        System.out.println("\n\nModify Successfully...");
        System.out.println(String.format("Appointment Date: %s -> %s\n\n", currentDateTime, duty));

        sc.nextLine();
        return duty;
    }

    public static Treatment selectTreatment(Treatment currentTreat) {

        Treatment[] newList = new Treatment[treatment.length];
        int numOfTreat = 0;
        String answer;

        for (int a = 0; a < treatment.length; a++) {
            if (!treatment[a].equals(currentTreat)) {
                newList[numOfTreat] = treatment[a];
                numOfTreat++;
            }
        }
        do {
            System.out.println("\n\nTreatment List");
            System.out.println("--------------");
            for (int a = 0; a < numOfTreat; a++) {
                System.out.println(String.format("%2d. %s", a + 1, newList[a]));
            }
            System.out.println(String.format("%2d. %s", treatment.length, "Back"));

            System.out.print("\nSelect an Treatment: ");
            answer = input(treatment.length);

            System.out.println("");
            if (answer.contains("Error")) {
                System.out.println(answer + " Please Try Again\n");
            }
        } while (answer.contains("ERROR"));

        if (Integer.parseInt(answer) != treatment.length) {
            System.out.println("\nModify Successfull..");
            System.out.println(String.format("Treatment: %s (%s) -> %s (%s)", currentTreat.getTreatment(), currentTreat.getVenue(), newList[Integer.parseInt(answer) - 1].getTreatment(), newList[Integer.parseInt(answer) - 1].getVenue()));
            currentTreat = newList[Integer.parseInt(answer) - 1];
        }

        return currentTreat;
    }

    public static void preInfo() {
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

        treatment[0] = new Treatment("Blood Test", "Room B1000", 150);
        treatment[1] = new Treatment("Covid Test", "Room J0009", 100);
        treatment[2] = new Treatment("X-ray", "Room Y00008", 250);
        treatment[3] = new Treatment("Body Check Up", "Room Z0002", 150);
        treatment[4] = new Treatment("Physiotherapy", "Room R00002", 300);

        appointment[0] = new Appointment(timeSlot[0], patient[0], doctor[0], treatment[0]);
        appointment[1] = new Appointment(timeSlot[1], patient[0], doctor[1], treatment[0]);
        appointment[2] = new Appointment(timeSlot[2], patient[2], doctor[2], treatment[0]);
        appointment[3] = new Appointment(timeSlot[3], patient[3], doctor[1], treatment[0]);
        appointment[4] = new Appointment(timeSlot[4], patient[0], doctor[1], treatment[0]);

    }
}
