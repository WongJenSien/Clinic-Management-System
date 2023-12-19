/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Client;

import adt_LXC.ArrayListLXC;
import adt_LXC.ListInterfaceLXC;
import entity.Treatment;
import java.util.Scanner;

/**
 *
 * @author jensienwong
 */
public class driver {

    public static driver clientProgram = new driver();
    // private static ListInterfaceTJX<Medicine> medicineList = new medicineIPM<>();
    private static ListInterfaceLXC<Treatment> treatmentList = new ArrayListLXC<>();
    public static boolean validation = true;
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initializeCollection();
        // clientProgram.mainMenu();

        int index = 5;

        Treatment[] t = new Treatment[index];
        t[0] = new Treatment("Blood Test", "Room B1000", 150, "hi this is a blood test");
        t[1] = new Treatment("Covid Test", "Room J0009", 100, "this s a covid test");
        t[2] = new Treatment("X-ray", "Room Y00008", 250, "this is x-ray");
        t[3] = new Treatment("Medical Check Up", "Room Z0002", 150, "this is medical body check up");
        t[4] = new Treatment("Physiotherapy", "Room R00002", 300, "this is physiotheraphy");

        for (int a = 0; a < t.length; a++) {

            treatmentList.add(t[a]);
        }

        clientProgram.alertAddTreatment();
        clientProgram.addTreatment();;
        // clientProgram.medicalHeader();
        // clientProgram.displayTreatment();

    }

    private static void initializeCollection() {
    }

    private void mainMenu() {
    }

    public void alertAddTreatment(){
        System.out.println("hi, please add your new treatment into list");
    }

    public void treatmentMenu() {
        int select = 0;

        System.out.println("============================================");
        System.out.println("\t\tTreatment Service");
        System.out.println("=============================================");
        System.out.println("1.Display Treatment Service List");
        System.out.println("2.Add the new Treatment Service");
        System.out.println("3.Update the Treatment Service");
        System.out.println("4.Remove the Treatment Service");
        System.out.println("5. Exit");

        try {
            System.out.println("\nPlease Choose a function:");
            select = sc.nextInt();
            System.out.println("\n");

        } catch (Exception e) {
            System.out.println("Invalid input!! Please insert the number(1-5 only) from the function selection above.");
            System.out.println("Please click any key to continue");
            System.out.println("\n");
            treatmentMenu();
        }

        switch (select) {
            case 1:
                sc.nextLine();
                displayTreatment();
                System.out.println("Press enter back to menu");
                System.out.println("\n");
                sc.nextLine();
                break;
            case 2:
                addTreatment();
                break;
            case 3:
                updateTreatment();
                break;
            case 4:
                removeTreatment();
                break;
            case 5:
                System.out.println("Thanks You");
                mainMenu();
                break;
        }
        treatmentMenu();
    }

    public static void medicalHeader() {
        System.out.println("====================================================================================");
        System.out.println("|No.   |Treatment Service Name      |Venue       |Price   |Description             |");
        System.out.println("===================================================================================");
    }

    public void displayTreatment() {
        medicalHeader();
        for (int a = 1; a <= treatmentList.getNumberOfEntries(); a++) {
            System.out.println(" " + a + ".     " + treatmentList.getEntry(a));
        }

        // TreatmentMenu();
    }

    public void addTreatment() {

        String addTreatment = insertTreatment();
        // Medicine addMedicine = insertMedicine();
        String addVenue = insertVenue();
        double addPrice = insertPrice();
        String addDesc = insertDesc();
        Treatment addTreatmentService = new Treatment(addTreatment, addVenue, addPrice, addDesc);
        treatmentList.add(addTreatmentService);
        System.out.println("\n Treatment added successfully!\n");
       displayTreatment();
    }

    public String insertTreatment() {
        String insertTreatment;
        sc.nextLine();
        do {

            System.out.println("Insert Treatment service name:");
            insertTreatment = sc.nextLine();

        } while (!validation);
        return insertTreatment;
    }

    public String insertDesc() {
        String insertDesc;
        sc.nextLine();
        do {

            System.out.println("Insert Treatment service description:");
            insertDesc = sc.nextLine();

        } while (!validation);
        return insertDesc;
    }

    public String insertVenue() {
        String[] insertVenue = { "Room b123", "Room678", "Room345", "Room809", "Room165" };
        int selection;

        do {
            for (int d = 0; d < insertVenue.length; d++) {
                System.out.println(String.format("%d. %s", d + 1, insertVenue[d]));
            }

            System.out.println("Select a Venue: ");
            selection = sc.nextInt();
            // System.out.println("Selection: " + selection);
            if (selection >= insertVenue.length || selection <= 0) {
                System.out.println("Please select a valid number");
                validation = false;
            }

        } while (!validation);
        return insertVenue[selection - 1];
    }

    public double insertPrice() {
        double insertPrice;
        do {
            System.out.println("Insert the treatment price: ");
            insertPrice = sc.nextDouble();

            if (insertPrice <= 0) {
                validation = false;
                System.out.println("Price cannot below zero, please enter again! ");
            }
        } while (!validation);
        return insertPrice;
    }

    public void updateTreatment() {

        String[] updateMenu = { "Treatment Name", "Venue", "Price", "Description", "Back" };
        int choice;

        // display update menu
        System.out.println("\n");
        displayTreatment();
        System.out.println("\n Please select a treatment you want to modify: ");
        choice = sc.nextInt();
        if (choice > treatmentList.getNumberOfEntries()) {
            System.out.println("Unable to modify, please try again!!\n");
            updateTreatment();
        }

        // Save the modify treatment data into "modifyTreatment"
        Treatment modifyTreatment = new Treatment();
        modifyTreatment = treatmentList.getEntry(choice);
        int modifyPosition = choice;

        // Display the modify treatment value
        medicalHeader();
        System.out.println(" " + choice + ".     " + modifyTreatment);
        System.out.println("\n");

        // To display the menu
        do {

            for (int r = 0; r < updateMenu.length; r++) {
                System.out.println(String.format("%2d.%s", r + 1, updateMenu[r]));
            }
            System.out.println("\n Please select a number you want to modify: ");
            choice = sc.nextInt();

        } while (choice > updateMenu.length || choice <= 0);

        switch (choice) {
            case 1:
                modifyTreatment.setTreatmentServices(insertTreatment());
                break;
            case 2:
                modifyTreatment.setDescription(insertDesc());
            case 3:
                modifyTreatment.setVenue(insertVenue());
                break;
            case 4:
                modifyTreatment.setPrice(insertPrice());
                break;
            case 5:
                treatmentMenu();
            default:
                System.out.print("Please Enter A Valid Selection : ");
                updateTreatment();
                break;
        }

        treatmentList.replace(modifyPosition, modifyTreatment);

        System.out.println("\n Updated Treatment Successfully!!\n");
        treatmentMenu();

    }

    public void removeTreatment() {
        char confirmation;
        do {
            medicalHeader();

            for (int x = 1; x <= treatmentList.getNumberOfEntries(); x++) {
                System.out.println(" " + x + ". " + treatmentList.getEntry(x));
            }

            int removeTreatment;

            do {
                // Display the message only if the flag is true

                System.out.println("Please select a treatment you want to remove: ");
                removeTreatment = sc.nextInt();

                // Validate input range
                if (removeTreatment < 1 || removeTreatment > treatmentList.getNumberOfEntries()) {
                    System.out.println("Invalid selection. Please enter a valid option.");
                }

            } while (removeTreatment < 1 || removeTreatment > treatmentList.getNumberOfEntries());

            System.out.println(treatmentList.getEntry(removeTreatment));
            System.out.println("Press y to delete the treatment: ");
            confirmation = sc.next().toUpperCase().charAt(0);

            if (confirmation == 'Y') {

                treatmentList.remove(removeTreatment);
                displayTreatment();

            } else {
                displayTreatment();
            }
        } while (confirmation == 'N');

    }

}
