import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {
        BankAccount obj1 = new BankAccount("Mrs. Flanagan", "X1234");
        obj1.showMenu();
    }
}

class BankAccount {
    int balance;
    int previousTrans;
    String customerName;
    String customerId;

    BankAccount(String cname, String cid) {
        customerName = cname;
        customerId = cid;
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTrans = amount;
        }
    }

    void withDraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTrans = -amount;
        }
    }

    void getPreviousTrans() {
        if (previousTrans > 0) {
            System.out.println(("Deposited: " + previousTrans));
        } else if (previousTrans < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTrans));
        } else {
            System.out.println("No transaction occured");
        }

    }

    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is " + customerId);
        System.out.println("\n");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");

        do {
            System.out.println("=================");
            System.out.println("Enter an Option");
            System.out.println("=================");
            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch (option) {
                case 'A':
                    System.out.println("---------");
                    System.out.println("Balance = " + balance);
                    System.out.println("---------");
                    System.out.println("\n");
                    break;
                case 'B':
                    System.out.println("---------");
                    System.out.println("Enter an amount to deposit");
                    System.out.println("---------");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;
                case 'C':
                    System.out.println("---------");
                    System.out.println("Enter an amount to withdraw");
                    System.out.println("---------");
                    int amount2 = scanner.nextInt();
                    withDraw(amount2);
                    System.out.println("\n");
                    break;
                case 'D':
                    System.out.println("---------");
                    getPreviousTrans();
                    System.out.println("---------");
                    System.out.println("\n");
                    break;
                case 'E':
                    System.out.println("************************");
                    System.out.println("\n");
                    break;

                default:
                    System.out.println("Invalid option, please enter again");
            }
        } while (option != 'E');
        System.out.println("Thank you for using our services!");
    }
}