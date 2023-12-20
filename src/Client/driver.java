package Client;

import adt_TJX.ListInterfaceTJX;
import adt_TJX.medicineIPM;
import Entity.Medicine;
import java.util.Scanner;


/**
 *
 * @author Tai Jun Xian
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
        
        clientProgram.updateMedicine();
    }
    
    //Display Medicine List
    private void displayAllMedicine() {
        System.out.printf("\n\nID.   %-17s %9s %8s \n", "Title", "Price", "Quantity");
        for (int i = 1; i <= medicineList.getNumberOfEntries(); i++) {
            Medicine allMedicine = medicineList.getEntry(i);
            String medicine = allMedicine.getMedicine();
            double price = allMedicine.getPrice();
            int Store = allMedicine.getStore();
            System.out.printf(" %d.   %-16s  RM %6.2f  %5d\n", i, medicine, price, Store);
        }
        
    }
    
    //Update Medicine Function
    private void updateMedicine() {
        int id = 0;
        boolean correction = true;
        do {
            displayAllMedicine();
            System.out.print("\nWhich Medicine you want edit ?(Exit:0) :");
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println(ANSI_RED + "Error : Selection cannot be empty. Please enter a valid integer." + ANSI_RESET + ANSI_RESET);
            } else if ("0".equals(input)) {
                updateMedicine();
            } else {
                try {
                    // Try to parse the input as an integer
                    id = Integer.parseInt(input);

                    if (id > medicineList.getNumberOfEntries() || id < 1) {
                        System.out.println(ANSI_RED + "Error: Selection cannot be other than the medicine ID list. Please enter a valid ID number." + ANSI_RESET);
                    }

                    for (int i = 1; i <= medicineList.getNumberOfEntries(); i++) {
                        if (id == i) {
                            Medicine showMedicine = medicineList.getEntry(i);
                            String medicine = showMedicine.getMedicine();
                            double price = showMedicine.getPrice();
                            int store = showMedicine.getStore();
                            String detail = showMedicine.getDetail();
                            System.out.printf("\n\nMedicien : %s \nPrice    :RM %3.2f\nQuantity : %d \nDetail   : %s\n", medicine, price, store, detail);

                            OUTER:
                            do {
                                System.out.println("\n1. Medicine");
                                System.out.println("2. Price");
                                System.out.println("3. Detail");
                                System.out.print("Which information you want to update?(Exit:0) : ");
                                String selection = sc.nextLine().trim();

                                if (selection.isEmpty()) {
                                    System.out.println(ANSI_RED + "Error : Selection cannot be empty. Please enter a valid integer." + ANSI_RESET + ANSI_RESET);
                                    correction = false;
                                } else if ("0".equals(selection)) {
                                    break;
                                } else {
                                    try {
                                        
                                        int num = Integer.parseInt(selection);
                                        
                                        switch (num) {
                                            case 1 -> {
                                                do {
                                                    System.out.print("\nEnter new medicine name : ");
                                                    String newMedicine = sc.nextLine();
                                                    if (String.valueOf(newMedicine).isEmpty()) {
                                                        System.out.println(ANSI_RED + "Error : Cannot enter empty input. Please enter a valid input." + ANSI_RESET);
                                                        correction = false;
                                                    } else {
                                                        medicineList.replace(i, new Medicine(newMedicine, price, store, detail));
                                                        correction = true;
                                                    }

                                                } while (correction == false);
                                                break OUTER;
                                            }
                                            case 2 -> {
                                                do {
                                                    try {
                                                        System.out.print("\nEnter new medicine price : RM");
                                                        String priceInput = sc.nextLine().trim();

                                                        if (priceInput.isEmpty()) {
                                                            System.out.println(ANSI_RED + "Error : Cannot enter empty input. Please enter a valid input." + ANSI_RESET + ANSI_RESET);
                                                            correction = false;
                                                        } else {
                                                            double newprice = Double.parseDouble(priceInput);

                                                            if (newprice < 1) {
                                                                System.out.println(ANSI_RED + "Error : The price cannot be less than 1. Please enter a correct value." + ANSI_RESET);
                                                                correction = false;
                                                            } else {
                                                                medicineList.replace(i, new Medicine(medicine, newprice, store, detail));
                                                                correction = true;
                                                            }
                                                        }

                                                    } catch (NumberFormatException e) {
                                                        // Handle the case where the input is not a valid double
                                                        System.out.println(ANSI_RED + "Error: Invalid input. Please enter a valid price." + ANSI_RESET);
                                                        correction = false;
                                                    }
                                                } while (correction == false);
                                                break OUTER;
                                            }
                                            case 3 -> {
                                                do {
                                                    System.out.print("\nEnter new medicine detail : ");
                                                    String newDetail = sc.nextLine();
                                                    if (String.valueOf(newDetail).isEmpty()) {
                                                        System.out.println(ANSI_RED + "Error : Cannot enter empty input. Please enter a valid input." + ANSI_RESET);
                                                        correction = false;
                                                    } else {
                                                        medicineList.replace(i, new Medicine(medicine, price, store, newDetail));
                                                        correction = true;
                                                    }
                                                } while (correction == false);
                                                break OUTER;
                                            }
                                            default ->{
                                                System.out.println(ANSI_RED + "Error: Selection cannot be other than the display list. Please enter a valid selection number." + ANSI_RESET);
                                                correction = false;
                                            }
                                        }
                                    } catch (NumberFormatException e) {
                                        // Handle the case where the input is not a valid integer
                                        System.out.println(ANSI_RED + "Error: Invalid input. Please enter a valid selection number." + ANSI_RESET);
                                        correction = false;
                                    }
                                }
                            } while (correction == false);
                        }
                    }
                } catch (NumberFormatException e) {
                    // Handle the case where the input is not a valid integer
                    System.out.println(ANSI_RED + "Error: Invalid input. Please enter a valid medicine ID." + ANSI_RESET);
                }
            }
        } while (true);
    }

//    //Add Medicine Store Function
//    private void addStoreMedicine() {
//        int id = 0;
//        
//        do {
//            displayAllMedicine();
//            System.out.print("\nWhich Medicine you want add quantity ?(Exit:0): ");
//            String input = sc.nextLine().trim();
//
//            // Check if the input is not empty
//            if (input.isEmpty()) {
//                System.out.println(ANSI_RED  +  "Error : Selection cannot be empty. Please enter a valid integer." + ANSI_RESET + ANSI_RESET );
//            } else if ("0".equals(input)) {
//                addStoreMedicine();
//            } else {
//                try {
//                    // Try to parse the input as an integer
//                    id = Integer.parseInt(input);
//
//                    if (id > medicineList.getNumberOfEntries() || id < medicineList.getNumberOfEntries()) {
//                        System.out.println(ANSI_RED + "Error: Selection cannot be other than the medicine ID list. Please enter a valid ID number." + ANSI_RESET);
//                    }
// 
//                    
//                    for (int i = 1; i <= medicineList.getNumberOfEntries(); i++) {
//                        if (id == i) {
//                            Medicine showMedicine = medicineList.getEntry(i);
//                            String medicine = showMedicine.getMedicine();
//                            double price = showMedicine.getPrice();
//                            int store = showMedicine.getStore();
//                            String detail = showMedicine.getDetail();
//                            System.out.printf("Medicien : %s \nPrice    : RM %3.2f \nQuantity    : %d \n", medicine, price, store );
//
//                            do {
//                                System.out.print("\nHow much quantity you want to add ?(Exit:0): ");
//                                input = sc.nextLine().trim();
//
//                                // Check if the input is not empty
//                                if (input.isEmpty()) {
//                                    System.out.println(ANSI_RED + "Error : Cannot enter empty input. Please enter a valid input." + ANSI_RESET + ANSI_RESET);
//                                } else if ("0".equals(input)) {
//                                    addStoreMedicine();
//                                    for (int j = 0; j < 75; j++){
//                                            System.out.print("-");
//                                    }
//                                } else {
//                                    try {
//                                        // Try to parse the input as an integer
//                                        int num = Integer.parseInt(input);
//                                        store += num;
//                                        
//                                        if (store < 0) {
//                                            System.out.println(ANSI_RED + "Error : The total quantity cannot be less than 0. Please enter a correct value." + ANSI_RESET);
//                                            store -= num;
//                                        } else {
//                                            medicineList.replace(i, new Medicine(medicine, price, store, detail));
//
//                                            System.out.printf("\nCompleted Added . Now %s quantity is %d .", medicine, store);
//                                            displayAllMedicine();
//                                            for (int j = 0; j < 75; j++) {
//                                                System.out.print("-");
//                                            }
//                                            break;
//                                        }
//
//                                    } catch (NumberFormatException e) {
//                                        // Handle the case where the input is not a valid integer
//                                        System.out.println(ANSI_RED + "Error: Invalid input. Please enter a valid quantity." + ANSI_RESET);
//                                    }
//                                }
//                            } while (true);
//
//                            
//                        }
//                    }
//                } catch (NumberFormatException e) {
//                    // Handle the case where the input is not a valid integer
//                    System.out.println(ANSI_RED + "Error: Invalid input. Please enter a valid medicine ID." + ANSI_RESET);
//                }
//            }
//        } while (true);
//       
//    }
//    
//    //Add Function
//    private void addMedicine() {
//        int i;
//        for (i = 1; i <= medicineList.getNumberOfEntries(); i++) {
//        }
//        String name = "";
//        Double price = 0.0;    
//        int store = 0;
//        String detail = "";
//        boolean stop = true;
//        
//        do {
//            System.out.print("\nEnter the medicine name: ");
//            name = sc.nextLine().trim();
//
//            if (name.isEmpty()) {
//                System.out.println(ANSI_RED + "Error: Medicine name cannot be empty. Please enter a valid medicine name." + ANSI_RESET);
//            }
//        } while (name.isEmpty());
//        
//        do {
//            // Prompt user for input
//            System.out.print("\nEnter the medicine price: ");
//            String input = sc.nextLine().trim();
//
//            if (input.isEmpty()) {
//                System.out.println(ANSI_RED + "Error: Medicine price cannot be empty. Please enter a valid price." + ANSI_RESET);
//            } else {
//                try {
//                    price = Double.valueOf(input);
//                    // Exit the loop if input is a valid double
//                    if (price >= 1.0) {
//                        // Exit the loop if input is valid
//                        break;
//                    } else {
//                        throw new NumberFormatException();
//                    }
//                } catch (NumberFormatException e) {
//                    System.out.println(ANSI_RED + "Error: Invalid input. Please enter a valid numeric value for the price and not less than 1." + ANSI_RESET);
//                }
//            }
//           
//        } while (true);
//        
//        do {
//            System.out.print("\nEnter Store Number (not less than 10): ");
//            String input = sc.nextLine().trim();
//
//            // Check if the input is not empty
//            if (input.isEmpty()) {
//                System.out.println(ANSI_RED + "Error : Medicine Store cannot be empty. Please enter a valid input." + ANSI_RESET);
//            } else {
//                try {
//                    // Try to parse the input as an integer
//                    store = Integer.parseInt(input);
//
//                    // Check if the store is less than 10
//                    if (store < 10) {
//                        System.out.println(ANSI_RED + "Error : Medicine Store cannot less than 10. Please enter a store number greater than or equal to 10." + ANSI_RESET);
//                    } else {
//                        // Exit the loop if input is valid
//                        break;
//                    }
//                } catch (NumberFormatException e) {
//                    // Handle the case where the input is not a valid integer
//                    System.out.println(ANSI_RED + "Error: Invalid input. Please enter a valid integer." + ANSI_RESET);
//                }
//            }
//        } while (true);
//        
//        do {
//            System.out.print("\nEnter Medicine Detail: ");
//            String input = sc.nextLine().trim();
//
//            // Check if the input is not empty
//            if (input.isEmpty()) {
//                System.out.println(ANSI_RED + "Detail cannot be empty. Please enter a valid numeric." + ANSI_RESET);
//            } else {
//                // Exit the loop if input is valid
//                detail = input;
//                break;
//            }
//        } while (true);
//
//        System.out.printf("\nMedicien Name   : %s \nMedicien Price  : RM %3.2f \nMedicien Store  : %d \nMedicien Detail : %s\n",
//                name, price, store, detail);
//
//        do{
//        System.out.print("\nIt is the information is you want added ? (Y/N) :");
//        Character confirm = sc.next().toUpperCase().charAt(0);
//        System.out.print("\n");
//        
//        
//        switch (confirm) {
//            case 'Y' -> {
//                Medicine medinice = new Medicine(name, price, store, detail);
//                medicineList.add(medinice);
//                System.out.println("Completed Added");
//                System.out.print("\n");
//                displayAllMedicine();
//                return;
//            }
//            case 'N' -> {
//                displayAllMedicine();
//                return;
//            }
//            default -> System.out.println(ANSI_RED + "Error: Invalid input. Please enter Y = Yes Or N = No." + ANSI_RESET);
//        }
//        }while(true);
//    }
//    
//    /**
//     *
//     * Medicine Module Prepared By Tai Jun Xian (TJX)
//     *
//     *
//     */
//    //Doctor Medicine Main Page
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

