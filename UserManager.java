import java.io.*;
import java.util.Scanner;

public class UserManager {
    private static final String DATA_FOLDER = "data";

    public BankAccount loadUser(String username) {
        File userFile = new File(DATA_FOLDER + "/" + username + ".txt");
        String password = "";
        int balance = 0;
        int prevTransaction = 0;

        if (userFile.exists()) {
            try (Scanner fileSc = new Scanner(userFile)) {
                password = fileSc.nextLine(); // first line = password
                balance = Integer.parseInt(fileSc.nextLine());
                prevTransaction = Integer.parseInt(fileSc.nextLine());

                Scanner inputSc = new Scanner(System.in);
                System.out.print("Enter your password: ");
                String enteredPassword = inputSc.nextLine();


                if (!enteredPassword.equals(password)) {
                    System.out.println("Incorrect password. Access denied.");
                    System.exit(0);
                } else {
                    System.out.println("Password verified.");
                }
            } catch (Exception e) {
                System.out.println("Error reading user data.");
            }
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println("New user detected.");
            System.out.print("Set your password: ");
            password = sc.nextLine();
            System.out.println("Account created sucessfully.");

        }

        return new BankAccount(username, balance, prevTransaction, password);
    }

    public void saveUser(BankAccount account) {
        File dir = new File(DATA_FOLDER);
        if (!dir.exists()) dir.mkdir();

        try (PrintWriter writer = new PrintWriter(DATA_FOLDER + "/" + account.getCustomerID() + ".txt")) {
            writer.println(account.getPassword());
            writer.println(account.getBalance());
            writer.println(account.getPreviousTransaction());
        } catch (IOException e) {
            System.out.println("Error saving user data.");
        }
        
    }
}
