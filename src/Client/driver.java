/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Client;

import adt_TJX.ListInterfaceTJX;
import adt_TJX.medicineIPM;
import adt_LXC.ArrayListLXC;
import adt_LXC.ListInterfaceLXC;
import entity.Treatment;
import entity.Medicine;
import static java.lang.System.exit;
import java.util.Scanner;

/**
 *
 * @author jensienwong
 */
public class driver {

    public static driver clientProgram = new driver();
    private static ListInterfaceTJX<Medicine> medicineList = new medicineIPM<>();
    private static ListInterfaceLXC<Treatment> treatmentList = new ArrayListLXC<>();
    public static boolean validation = true;
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initializeCollection();
        // clientProgram.mainMenu();

        int index = 5;
        Medicine[] m = new Medicine[index];
        m[0] = new Medicine("Painkiller", 10.5, 10,
                "Pain relievers are medicines that reduce or relieve headaches,\n sore muscles, arthritis, or other aches and pains. \nThere are many different pain medicines, and each one has advantages and risks. \nSome types of pain respond better to certain medicines than others.\n");
        m[1] = new Medicine("Antibiotics ", 11.5, 10,
                "Antibiotics are medicines that fight infections caused by bacteria\n in humans and animals by either killing the bacteria or \n making it difficult for the bacteria to grow and multiply. Bacteria are germs.");
        m[2] = new Medicine("Antipyretics", 9.5, 10,
                "Antipyretics block or reverse fever's cytokine-mediated rise in\n core temperature, but do not affect body temperature in the afebrile state. \nThey are to be distinguished from hypothermia agents (cryogens),\n which are capable of lowering core temperature even in the absence of fever.\n");
        m[3] = new Medicine("Vitamins", 12.5, 10,
                "Some vitamins help you resist infections and keep your nerves healthy,\n while others may help your body get energy from food or help your blood clot properly.");
        m[4] = new Medicine("Morphine", 8, 10,
                "Morphine is used to relieve severe pain, such as pain caused by a major trauma or\n surgery, labour pain in childbirth or cancer pain.");

        Treatment[] t = new Treatment[index];
        t[0] = new Treatment("Blood Test", m[0], "Room B1000", 150);
        t[1] = new Treatment("Covid Test", m[1], "Room J0009", 100);
        t[2] = new Treatment("X-ray", m[2], "Room Y00008", 250);
        t[3] = new Treatment("Medical Check Up", m[3], "Room Z0002", 150);
        t[4] = new Treatment("Physiotherapy", m[4], "Room R00002", 300);

        for(int a= 0; a < t.length; a++){
            medicineList.add(m[a]);
            treatmentList.add(t[a]);
        }

        clientProgram.treatmentMenu();
        // clientProgram.medicalHeader();
        // clientProgram.displayTreatment();


    }

    private static void initializeCollection() {
    }

    private void mainMenu() {
    }

    public void treatmentMenu() {
        int select = 0;

        System.out.println("============================================");
        System.out.println("\t\tMedical Service");
        System.out.println("=============================================");
        System.out.println("1.Display Treatment Service List");
        System.out.println("2.Add the new Medical Service");
        System.out.println("3.Update the Medical Service");
        System.out.println("4.Remove the Medical Service");
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
        System.out.println("===============================================================================");
        System.out.println("|No.   |Medical Service Name      |Medicine             |Venue       |Price   |");
        System.out.println("===============================================================================");
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
        Medicine addMedicine = insertMedicine();
        String addVenue = insertVenue();
        double addPrice = insertPrice();
        Treatment addTreatmentService = new Treatment(addTreatment, addMedicine, addVenue, addPrice);
        treatmentList.add(addTreatmentService);
        System.out.println("\n Treatment added successfully!\n");
        treatmentMenu();
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

    public Medicine insertMedicine() {

        Medicine[] allMedicine = new Medicine[medicineList.getNumberOfEntries()];
        for (int a = 1; a <= allMedicine.length; a++) {
            allMedicine[a - 1] = medicineList.getEntry(a);
        }

        int selection;

        do {
            validation = true;
            for (int y = 0; y < allMedicine.length; y++) {
                System.out.println(String.format("%d. %s", y + 1, allMedicine[y].getMedicine()));
            }
            System.out.println("Select a Medicine : ");
            selection = sc.nextInt();
            System.out.println("\n");

            if (selection > allMedicine.length || selection <= 0) {
                System.out.println("Please select a valid number");
                validation = false;
            }
        } while (!validation);

        return allMedicine[selection - 1];
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

        String[] updateMenu = { "Treatment Name", "Medinice", "Venue", "Price", "Back" };
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
                modifyTreatment.setMedicalServices(insertTreatment());
                break;
            case 2:
                modifyTreatment.setMedicine(insertMedicine());
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
        medicalHeader();
        for (int x = 1; x <= treatmentList.getNumberOfEntries(); x++) {
            System.out.println(" " + x + ". " + treatmentList.getEntry(x));
        }
        System.out.println("Please select a treatment you want to remove: ");
        int removeTreatment = sc.nextInt();
        System.out.println(treatmentList.getEntry(removeTreatment));
        System.out.println("Press y to delete the treatment: ");
        char confirmation = sc.next().toUpperCase().charAt(0);

        if (confirmation == 'Y') {

            treatmentList.remove(removeTreatment);
            displayTreatment();
            System.out.println("\n");
        } else {
            displayTreatment();
            System.out.println("\n");
        }

        treatmentMenu();
    }

}
