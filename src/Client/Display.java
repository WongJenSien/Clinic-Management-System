/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

/**
 *
 * @author wongh
 */
public class Display {
    public void userProfile() {
        //Show User Profile
        System.out.println(patientList.getEntry(patientPosition));
        int selection;
        char answer = 0, choose = 0;
        do {
            do {

                System.out.println("1. Modify");
                System.out.println("2. Permenantly delete account");
                System.out.println("3. Back");
                System.out.print("Enter Your Selection : ");
                selection = sc.nextInt();

                switch (selection) {

                    case 1:
                        // MOdify
                        String name,
                         studentID,
                         phoneNum,
                         icNum;
                        String oldId = patientList.getEntry(patientPosition).getStudentID();
                        char gender;
                        int age;
                        sc.nextLine();
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
                        gender = sc.next().toUpperCase().charAt(0);

                        Patient p = new Patient(name, studentID, phoneNum, icNum, age, gender);
                        patientList.replace(patientPosition, p);
                        System.out.println("Do you want to back to profile?(Y=YES/N=NO)");
                        choose = sc.next().toUpperCase().charAt(0);

                        System.out.println(patientList.getEntry(patientPosition));

                        modifyAppointmentPatientId(patientList.getEntry(patientPosition), oldId);

                        break;

                    case 2:
                        //Delete
                        System.out.println("Are you sure to permenantly delete your account?(Y=YES/N=NO)");

                        answer = sc.next().toUpperCase().charAt(0);
                        if (answer == 'Y') {
                            int size = patientList.getNumberOfEntries();
                            Patient removePatient = patientList.getEntry(patientPosition);
                            patientList.remove(patientPosition);
                            //Delete Patient Appointment Record
                            deleteAppointmentPatient(removePatient);
                            if (patientList.getNumberOfEntries() < size) {
                                System.out.println("Successful remove");
                            }

                            mainMenu();
                        } else {
                            break;
                        }
                    case 3:
                        userMainMenu();
                        break;
                    default:

                }
            } while (choose == 'Y' && selection == 1);

        } while (selection != 1 && selection != 2);

    }
}
