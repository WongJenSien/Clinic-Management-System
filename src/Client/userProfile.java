/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;



class userProfile {
     private String name;
    private String workId;
    private String phoneNumber;
    private String emailAddress;
    private String specialist;

    // Constructor
    public userProfile(String name, String workId, String phoneNumber, String emailAddress, String specialist) {
        this.name = name;
        this.workId = workId;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.specialist = specialist;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
         if (isValidName(name)) {
            this.name = name;
        } else {
            System.out.println("Invalid name. Please enter a valid name.");
        }
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        if (isValidWorkId(workId)) {
            this.workId = workId;
        } else {
            System.out.println("Invalid work ID. Please enter a valid work ID.");
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
       if (isValidPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Invalid phone number. Please enter a valid phone number.");
        }
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
         if (isValidEmailAddress(emailAddress)) {
            this.emailAddress = emailAddress;
        } else {
            System.out.println("Invalid email address. Please enter a valid email address.");
        }
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
         if (isValidSpecialist(specialist)) {
            this.specialist = specialist;
        } else {
            System.out.println("Invalid specialist. Please enter a valid specialist.");
        }
    }
    
    private boolean isValidName(String name) {
        // Add your validation criteria for name here
        return name != null && !name.trim().isEmpty();
    }

    private boolean isValidWorkId(String workId) {
        // Add your validation criteria for work ID here
        return workId != null && !workId.trim().isEmpty();
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        // Add your validation criteria for phone number here
        return phoneNumber != null && phoneNumber.matches("\\d{10}"); // Example: 10-digit phone number
    }

    private boolean isValidEmailAddress(String emailAddress) {
        // Add your validation criteria for email address here
        return emailAddress != null && emailAddress.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    }

    private boolean isValidSpecialist(String specialist) {
        // Add your validation criteria for specialist here
        return specialist != null && !specialist.trim().isEmpty();
    }
}
