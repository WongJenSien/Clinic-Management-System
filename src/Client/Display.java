/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import java.util.Scanner;

public class Display {
     public static void main(String[] args) {
        // Create a sample user profile
        userProfile userProfile = new userProfile("John Doe", "12345", "555-1234", "john.doe@example.com", "Software Engineer");

        // Display current profile information
        displayProfile(userProfile);

        // Allow user to modify profile information
        modifyProfile(userProfile);

        // Display updated profile information
        System.out.println("\nUpdated Profile Information:");
        displayProfile(userProfile);
    }

    private static void displayProfile(userProfile userProfile) {
        System.out.println("\nProfile Information:");
        System.out.println("1. Name: " + userProfile.getName());
        System.out.println("2. Work ID: " + userProfile.getWorkId());
        System.out.println("3. Phone Number: " + userProfile.getPhoneNumber());
        System.out.println("4. Email Address: " + userProfile.getEmailAddress());
        System.out.println("5. Specialist: " + userProfile.getSpecialist());
    }

    private static void modifyProfile(userProfile userProfile) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the option number to modify (or 0 to finish): ");
        int option = scanner.nextInt();
        while (option != 0) {
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    System.out.print("Enter new name: ");
                    userProfile.setName(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Enter new work ID: ");
                    userProfile.setWorkId(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Enter new phone number: ");
                    userProfile.setPhoneNumber(scanner.nextLine());
                    break;
                case 4:
                    System.out.print("Enter new email address: ");
                    userProfile.setEmailAddress(scanner.nextLine());
                    break;
                case 5:
                    System.out.print("Enter new specialist: ");
                    userProfile.setSpecialist(scanner.nextLine());
                    break;
                default:
                    System.out.println("Invalid option");
            }

            // Display current profile information
            displayProfile(userProfile);

            System.out.print("\nEnter the option number to modify (or 0 to finish): ");
            option = scanner.nextInt();
        }
    }
}
