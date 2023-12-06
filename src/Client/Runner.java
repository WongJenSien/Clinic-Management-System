/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;


import java.util.Scanner;

public class Runner {
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String correctUsername = "Jennie";
        String correctPassword = "Abc123";
        String userName;
        String password;

        do {
            System.out.println("-----------------");
            System.out.println("| Patient Login |");
            System.out.println("-----------------");
            System.out.println("Username: ");
            userName = sc.nextLine();

            System.out.println("Password: ");
            password = sc.nextLine();

            if (userName.equals(correctUsername) && password.equals(correctPassword)) {
                System.out.println("Login Successful!");
                break; // Exit the loop if login is successful
            } else {
                System.out.println("Incorrect Username and Password. Please try again.");
            }
        } while (true); // Infinite loop, will break out when login is successful
    }
    
}
