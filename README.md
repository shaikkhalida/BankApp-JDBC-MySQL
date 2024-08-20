# BankingSystem-JDBC-MySQL

## Overview
**BankingSystem-JDBC-MySQL** is a simple Java-based banking system that allows users to perform basic bank operations such as opening accounts, depositing money, withdrawing money, and deleting accounts. This project uses JDBC (Java Database Connectivity) to interact with a MySQL database, storing account information and handling transactions.

## Features
- **Open a New Account**: Allows users to create a new bank account with an initial balance.
- **Deposit Money**: Enables users to deposit money into an existing account.
- **Withdraw Money**: Allows users to withdraw money from an existing account.
- **Delete Account**: Provides functionality to delete an existing account from the database.
- **Display Account Details**: Displays the details of a specific account, including the account holder's name and current balance.

## Technologies Used
- **Java**: The core programming language used for building the application.
- **JDBC**: Java Database Connectivity is used for database interaction.
- **MySQL**: A relational database used to store account details.

## Installation and Setup
### Prerequisites
- **Java Development Kit (JDK)**: Ensure that JDK is installed on your machine.
- **MySQL Server**: Set up a MySQL server and create a database for the banking system.
- **MySQL Connector/J**: Download the MySQL JDBC driver (Connector/J) and add it to your project.

### Steps to Run the Project
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/BankingSystem-JDBC-MySQL.git
   cd BankingSystem-JDBC-MySQL

2. **Set Up the MySQL Database**:
   - Create a database named `bank_db`.
   - Create a table called `Accounts` using the following SQL script:
     ```sql
     CREATE TABLE Accounts (
         accountNumber INT PRIMARY KEY AUTO_INCREMENT,
         accountHolderName VARCHAR(255) NOT NULL,
         balance DOUBLE NOT NULL
     );
     ```
   - Insert some initial data if desired.

3. **Compile and Run the Java Program**:
   - Compile the Java files:
     ```bash
     javac -cp .:mysql-connector-java-8.0.33.jar BankAccount.java BankOperations.java Main.java
     ```
   - Run the main class:
     ```bash
     java -cp .:mysql-connector-java-8.0.33.jar Main
     ```

4. **Interact with the Application**:
   - Follow the on-screen instructions to perform banking operations.

## Usage
- **Open a New Account**: Choose option 1, enter the account holder's name, and specify the initial balance.
- **Deposit Money**: Choose option 2, enter the account number, and the amount to deposit.
- **Withdraw Money**: Choose option 3, enter the account number, and the amount to withdraw.
- **Delete Account**: Choose option 5, enter the account number to delete.
- **Exit**: Choose option 6 to exit the application.
