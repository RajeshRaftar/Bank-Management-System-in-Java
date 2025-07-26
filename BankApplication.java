import java.util.Scanner;

public class BankApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserManager userManager = new UserManager();

        System.out.println("=== Welcome to Java Bank ===");
        System.out.print("Enter username : ");
        String username = sc.nextLine();

        BankAccount account = userManager.loadUser(username);
        account.showMenu();
        userManager.saveUser(account);

        System.out.println("Thanks for using Java Bank!");

    }
}
