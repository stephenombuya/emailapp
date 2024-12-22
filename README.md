# **EmailApp Project Documentation**

### **Project Overview**
The **EmailApp** is a simple Java application designed to simulate the creation and management of an email system for a company. It allows for the generation of company email addresses based on user input, random password creation, mailbox management, and alternate email handling. The app is aimed at providing an easy way to create and manage email accounts with some customization options such as department selection, password generation, and mailbox capacity setting.


### **Limitations and Future Improvements**
  - **Scanner Resource Leak**: Currently, the Scanner is closed inside the setDepartment() method. In a larger application, managing resources efficiently would be important. A better practice would be to pass the Scanner object into methods or handle its closure more gracefully.

  - **Password Security**: The generated password is currently visible to the user. For a real application, password management should involve secure hashing and storage, not exposing the password in plain text.

  - **User Input Validation**: There is no input validation in the setDepartment() method. Input validation should be added to handle invalid or unexpected user inputs gracefully.


### **Conclusion**
The **EmailApp** demonstrates how to handle basic email system features, including user creation, department management, password generation, and email address formatting. While simple, this application is a good starting point for understanding object-oriented principles in Java and can be expanded to handle more complex functionality in a real-world application.
