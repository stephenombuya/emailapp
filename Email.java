package emailapp;

import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String department;
    private int mailboxCapacity = 500;  // Default mailbox capacity
    private int defaultPasswordLength = 10;  // Default password length
    private String alternateEmail;
    private static final String COMPANY_SUFFIX = "anycompany.com";  // Company domain suffix
    private static final String PASSWORD_SET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ#1234567890@#$%";  // Allowed characters for password

    // Constructor to initialize the first and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Ask for department and assign it
        this.department = setDepartment();

        // Generate a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        // Generate email address
        this.email = generateEmail();
    }

    // Ask for the department code
    private String setDepartment() {
        System.out.println("New worker: " + firstName + ", Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter the department code:");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        in.close();  // Close the scanner after usage to avoid resource leakage
        switch (depChoice) {
            case 1: return "sales";
            case 2: return "dev";
            case 3: return "acct";
            default: return "";
        }
    }

    // Generate a random password
    private String randomPassword(int length) {
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * PASSWORD_SET.length());
            password[i] = PASSWORD_SET.charAt(rand);
        }
        return new String(password);
    }

    // Generate the email address based on user details and department
    private String generateEmail() {
        return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + COMPANY_SUFFIX;
    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    // Change the password
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    // Get mailbox capacity
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    // Get alternate email
    public String getAlternateEmail() {
        return alternateEmail;  // Return the actual alternate email
    }

    // Get password (it's better not to expose the password directly)
    public String getPassword() {
        return "Password is private";  // Avoid exposing the password
    }

    // Display the information of the user
    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
               "\nCOMPANY EMAIL: " + email +
               "\nMAILBOX CAPACITY: " + mailboxCapacity + "MB" +
               "\nALTERNATE EMAIL: " + (alternateEmail != null ? alternateEmail : "Not Set");
    }
}
