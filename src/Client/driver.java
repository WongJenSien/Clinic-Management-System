package Client;

import adt_TJX.ListInterfaceTJX;
import adt_TJX.medicineIPM;
import Entity.Medicine;
import java.util.Scanner;


/**
 *
 * @author jensienwong
 */
public class driver {

    public static driver clientProgram = new driver();
    private static final ListInterfaceTJX<Medicine> medicineList = new medicineIPM<>(); 
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    Scanner sc = new Scanner(System.in);
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        int index = 5;
       
        Medicine[] m = new Medicine[index];
        m[0] = new Medicine("Painkiller", 10.5, 10, "Pain relievers are medicines that reduce or relieve headaches,\n sore muscles, arthritis, or other aches and pains. \nThere are many different pain medicines, and each one has advantages and risks. \nSome types of pain respond better to certain medicines than others.\n");
        m[1] = new Medicine("Antibiotics ", 11.5, 10, "Antibiotics are medicines that fight infections caused by bacteria\n in humans and animals by either killing the bacteria or \n making it difficult for the bacteria to grow and multiply. Bacteria are germs.");
        m[2] = new Medicine("Antipyretics", 9.5, 10, "Antipyretics block or reverse fever's cytokine-mediated rise in\n core temperature, but do not affect body temperature in the afebrile state. \nThey are to be distinguished from hypothermia agents (cryogens),\n which are capable of lowering core temperature even in the absence of fever.\n");
        m[3] = new Medicine("Vitamins", 12.5, 10, "Some vitamins help you resist infections and keep your nerves healthy,\n while others may help your body get energy from food or help your blood clot properly.");
        m[4] = new Medicine("Morphine", 8, 10, "Morphine is used to relieve severe pain, such as pain caused by a major trauma or\n surgery, labour pain in childbirth or cancer pain.");

        for (Medicine m1 : m) {
            medicineList.add(m1);
        }
        
        clientProgram.addMedicine();
    }
    
    //Display Medicine List
    private void displayAllMedicine() {
        System.out.printf("ID.   %-17s %9s %8s \n", "Title", "Price", "Store");
        for (int i = 1; i <= medicineList.getNumberOfEntries(); i++) {
            Medicine allMedicine = medicineList.getEntry(i);
            String medicine = allMedicine.getMedicine();
            double price = allMedicine.getPrice();
            int Store = allMedicine.getStore();
            System.out.printf(" %d.   %-16s  RM %6.2f  %5d\n", i, medicine, price, Store);
        }
        System.out.println("\n");
    }

    //Add Function
    private void addMedicine() {
        int i;
        for (i = 1; i <= medicineList.getNumberOfEntries(); i++) {
        }
        String name = "";
        Double price = 0.0;    
        int store = 0;
        String detail = "";
        
        do {
            System.out.print("\nEnter the medicine name: ");
            name = sc.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println(ANSI_RED + "Error: Medicine name cannot be empty. Please enter a valid medicine name." + ANSI_RESET);
            }
        } while (name.isEmpty());
        
        do {
            // Prompt user for input
            System.out.print("\nEnter the medicine price: ");
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println(ANSI_RED + "Error: Medicine price cannot be empty. Please enter a valid price." + ANSI_RESET);
            } else {
                try {
                    price = Double.valueOf(input);
                    // Exit the loop if input is a valid double
                    if (price >= 1.0) {
                        // Exit the loop if input is valid
                        break;
                    } else {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException e) {
                    System.out.println(ANSI_RED + "Error: Invalid input. Please enter a valid numeric value for the price and not less than 1." + ANSI_RESET);
                }
            }
           
        } while (true);
        
        do {
            System.out.print("\nEnter Store Number (not less than 10): ");
            String input = sc.nextLine().trim();

            // Check if the input is not empty
            if (input.isEmpty()) {
                System.out.println(ANSI_RED + "Error : Medicine Store cannot be empty. Please enter a valid input." + ANSI_RESET);
            } else {
                try {
                    // Try to parse the input as an integer
                    store = Integer.parseInt(input);

                    // Check if the store is less than 10
                    if (store < 10) {
                        System.out.println(ANSI_RED + "Error : Medicine Store cannot less than 10. Please enter a store number greater than or equal to 10." + ANSI_RESET);
                    } else {
                        // Exit the loop if input is valid
                        break;
                    }
                } catch (NumberFormatException e) {
                    // Handle the case where the input is not a valid integer
                    System.out.println(ANSI_RED + "Error: Invalid input. Please enter a valid integer." + ANSI_RESET);
                }
            }
        } while (true);
        
        do {
            System.out.print("\nEnter Medicine Detail: ");
            String input = sc.nextLine().trim();

            // Check if the input is not empty
            if (input.isEmpty()) {
                System.out.println(ANSI_RED + "Detail cannot be empty. Please enter a valid numeric." + ANSI_RESET);
            } else {
                // Exit the loop if input is valid
                detail = input;
                break;
            }
        } while (true);

        System.out.printf("\nMedicien Name   : %s \nMedicien Price  : RM %3.2f \nMedicien Store  : %d \nMedicien Detail : %s\n",
                name, price, store, detail);

        System.out.print("\nIt is the information is you want added ? (Y/N) :");
        Character confirm = sc.next().toUpperCase().charAt(0);
        System.out.print("\n");
        
        switch (confirm) {
            case 'Y' -> {
                Medicine medinice = new Medicine(name, price, store, detail);
                medicineList.add(medinice);
                System.out.println("Completed Added");
                System.out.print("\n");
                displayAllMedicine();
            }
            case 'N' -> displayAllMedicine();
            default -> System.out.println(ANSI_RED + "Please enter Y = Yes Or N = No." + ANSI_RESET);
        }
    }
    
    /**
     *
     * Medicine Module Prepared By Tai Jun Xian (TJX)
     *
     *
     */
    //Doctor Medicine Main Page
//    private void doctorMedicine() {
//        int selection = 0;
//
//        do {
//            System.out.println("\n");
//            System.out.println("Welcome to Medicine");
//            System.out.println("1. Add Medicine ");
//            System.out.println("2. Check Medicien ");
//            System.out.println("3. Add Store Medicien ");
//            System.out.println("4. Update Medicien ");
//            System.out.println("5. Delete Medicien ");
//            System.out.println("6. Exit ");
//            System.out.println("\n");
//
//            System.out.print("Enter Your Selection (1~6): ");
//            selection = sc.nextInt();
//            System.out.println("\n");
//
//            switch (selection) {
//                case 1:
//                    addMedicine();
//
//                    break;
//                case 2:
//                    checkMedicine();
//
//                    break;
//                case 3:
//                    addStoreMedicine();
//                    break;
//                case 4:
//                    updateMedicine();
//
//                    break;
//                case 5:
//                    deleteMedicine();
//
//                    break;
//                default:
//                    System.out.println("Invalid Input Please Enter Again\n");
//
//            }
//        } while (selection >= 6 || selection <= 1);
//
//    }

//    //View Medicien Detail
//    private void checkMedicine() {
//
//        displayAllMedicine();
//        System.out.print("Please select a Medicien to check detail : ");
//        int num = sc.nextInt();
//
//        System.out.println("\n");
//
//        Medicine displayMedicine = medicineList.getEntry(num);
//        String choosed = displayMedicine.getMedicine();
//        System.out.printf("\nMedicien : %s \nPrice    : RM %3.2f \nStore    : %d \nDetail   : %s\n",
//                choosed, displayMedicine.getPrice(), displayMedicine.getStore(), displayMedicine.getDetail());
//
//        doctorMedicine();
//    }
//
//    //Add Medicine Store Function
//    private void addStoreMedicine() {
//        boolean correction = true;
//        displayAllMedicine();
//
//        System.out.println("\nWhich Medicine you want add store ?(Exit:0) :");
//        int selection = sc.nextInt();
//        System.out.print("\n");
//
//        if (selection > medicineList.getNumberOfEntries()) {
//            System.out.println("Selection error,please select again");
//            addStoreMedicine();
//        } else if (selection == 0) {
//            doctorMedicine();
//        }
//
//        for (int i = 1; i <= medicineList.getNumberOfEntries(); i++) {
//            if (selection == i) {
//                Medicine showMedicine = medicineList.getEntry(i);
//                String medicine = showMedicine.getMedicine();
//                double price = showMedicine.getPrice();
//                int store = showMedicine.getStore();
//                String detail = showMedicine.getDetail();
//                System.out.printf("Medicien : %s \nPrice    :RM %3.2f \nStore    : %d \n", medicine, price, store);
//
//                do {
//                    System.out.print("\n");
//                    System.out.print("How much amount you want to add ? : ");
//                    selection = sc.nextInt();
//                    if (String.valueOf(selection).isEmpty()) {
//                        System.out.println("Please enter amount. Thank You. : \n");
//                        correction = false;
//                    } else {
//                        store += selection;
//                        medicineList.replace(i, new Medicine(medicine, price, store, detail));
//                    }
//
//                } while (correction == false);
//
//                System.out.printf("\nCompleted Added . Now %s store is %d .\n", medicine, store);
//                System.out.println("\n");
//                doctorMedicine();
//            }
//        }
//    }
//
//    //Update Medicine Function
//    private void updateMedicine() {
//        boolean correction = true;
//        displayAllMedicine();
//
//        System.out.print("\nWhich Medicine you want update ?(Exit:0) :");
//        int selection = sc.nextInt();
//        System.out.print("\n");
//
//        if (selection > medicineList.getNumberOfEntries()) {
//            System.out.println("Selection error,please select again");
//            addStoreMedicine();
//        } else if (selection == 0) {
//            doctorMedicine();
//        }
//
//        for (int i = 1; i <= medicineList.getNumberOfEntries(); i++) {
//            if (selection == i) {
//                System.out.println(i);
//                Medicine showMedicine = medicineList.getEntry(i);
//                String medicine = showMedicine.getMedicine();
//                double price = showMedicine.getPrice();
//                int store = showMedicine.getStore();
//                String detail = showMedicine.getDetail();
//                System.out.printf("Medicien : %s \nPrice   :RM %3.2f\nStore    : %d \nDetail   : %s\n", medicine, price, store, detail);
//
//                do {
//                    System.out.println("\nWhich information you want to update? ");
//                    System.out.println("1. Medicine");
//                    System.out.println("2. Price");
//                    System.out.println("3. Detail\n");
//                    selection = sc.nextInt();
//                    sc.nextLine();
//
//                    switch (selection) {
//                        case 1:
//                            do {
//                                System.out.print("\nUpdate medicine name : ");
//                                medicine = sc.nextLine();
//                                if (String.valueOf(selection).isEmpty()) {
//                                    System.out.println("Please enter medicine name . Thank You. : \n");
//                                    correction = false;
//                                }
//                                medicineList.replace(i, new Medicine(medicine, price, store, detail));
//                                doctorMedicine();
//                            } while (correction == false);
//                            break;
//                        case 2:
//                            do {
//                                System.out.print("\nUpdate medicine price : RM");
//                                price = sc.nextDouble();
//                                if (String.valueOf(selection).isEmpty()) {
//                                    System.out.println("Please enter medicine price . Thank You. : \n");
//                                    correction = false;
//                                }
//                                medicineList.replace(i, new Medicine(medicine, price, store, detail));
//                                doctorMedicine();
//                            } while (correction == false);
//                            break;
//                        case 3:
//                            do {
//                                System.out.print("\nUpdate medicine detail : ");
//                                detail = sc.nextLine();
//                                if (String.valueOf(selection).isEmpty()) {
//                                    System.out.println("Please enter medicine detail . Thank You. : \n");
//                                    correction = false;
//                                }
//                                medicineList.replace(i, new Medicine(medicine, price, store, detail));
//                                doctorMedicine();
//                            } while (correction == false);
//                            break;
//                        default:
//                            System.out.println("\nInvalid Input Please Enter Again\n");
//                            doctorMedicine();
//                    }
//
//                } while (selection >= 3 || selection <= 1);
//            }
//        }
//    }
//
//    //Delete Medicine Function
//    private void deleteMedicine() {
//        displayAllMedicine();
//
//        System.out.println("\nWhich Medicine you want Delete medicine ?(Exit:0) :");
//        Integer selection = sc.nextInt();
//        if (selection > medicineList.getNumberOfEntries()) {
//            System.out.println("\nSelection error,please select again\n");
//            deleteMedicine();
//        } else if (selection == 0) {
//            doctorMedicine();
//        }
//
//        for (int i = 1; i <= medicineList.getNumberOfEntries(); i++) {
//            if (selection == i) {
//                Medicine showMedicine = medicineList.getEntry(i);
//                String medicine = showMedicine.getMedicine();
//                double price = showMedicine.getPrice();
//                int store = showMedicine.getStore();
//                System.out.printf("Medicien : %s \nPrice    :RM %3.2f \nStore    : %d \n", medicine, price, store);
//                System.out.print("\n");
//                System.out.print("Are you sure you want Delete this medicine ? (Y/N) : ");
//                Character confirm = sc.next().toUpperCase().charAt(0);
//                if (confirm == 'Y') {
//                    medicineList.remove(i);
//                    System.out.printf("\nCompleted Delete %s\n", medicine);
//                    displayAllMedicine();
//                    doctorMedicine();
//                } else {
//                    System.out.print("\nCancel Deleted \n");
//                    doctorMedicine();
//                }
//
//            }
//        }
//    }
}

