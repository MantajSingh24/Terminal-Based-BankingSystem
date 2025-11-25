import java.util.InputMismatchException;
import java.util.Scanner;

public class BankManagementSystem {
    public static void main(String[] args) {
        BankSystem bankSystem = new BankSystem();

        // Hardcoded data
        Card card1 = new Card("Mantaj Singh", "11/25", 4565, 1111, 2100);
        Card card2 = new Card("Shivam Sangwan", "12/24", 9543, 2222, 1100);
        Card card3 = new Card("Neer Patel", "02/27", 5623, 3333, 4600);
        bankSystem.addCard(card1);
        bankSystem.addCard(card2);
        bankSystem.addCard(card3);

        Scanner scanner = new Scanner(System.in);

        try {
            int totalAttempts = 0;
            Card card = null;
            while (totalAttempts < 4) {
                System.out.println("Login to your account.");
                try {
                    System.out.print("Enter Card Number: ");
                    int cardNumber = scanner.nextInt();
                    System.out.print("Enter Expiry Date (MM/YY): ");
                    String expiryDate = scanner.next();
                    card = bankSystem.validateCard(cardNumber, expiryDate);
                    break; // Exit loop if card is validated
                } catch (InvalidCardException | InputMismatchException e) {
                    scanner.nextLine(); 
                    totalAttempts++;
                    if (totalAttempts < 4) {
                        System.out.println("Invalid card details or input. Please check your details and try again.");
                    } else {
                        System.out.println("Too many failed attempts. Your app is temporarily locked for security purposes. " +
                                           "Please mail to security@royalbankofacadia.com and answer some questions to unlock it right away.");
                        return; // Exit the program after the 4th failed attempt
                    }
                }
            }

            if (card != null) {
                int pinAttempts = 0;
                while (pinAttempts < 4) {
                    try {
                        System.out.print("Enter PIN: ");
                        int enteredPIN = scanner.nextInt();
                        if (bankSystem.validatePIN(card, enteredPIN)) {
                            System.out.println("\nWelcome to 'THE ROYAL BANK OF ACADIA Banking APP!");
                            
                            while (true) {
                                System.out.println("1. Deposit");
                                System.out.println("2. Withdraw");
                                System.out.println("3. Transfer");
                                System.out.println("4. View Balance");
                                System.out.println("5. View Transaction History");
                                System.out.println("6. Exit");
                                System.out.print("Enter your choice: ");

                                int choice = scanner.nextInt();
                                switch (choice) {
                                    case 1:
                                        System.out.print("Enter amount to deposit: ");
                                        int depositAmount = scanner.nextInt();
                                        card.deposit(depositAmount);
                                        break;
                                    case 2:
                                    System.out.print("Enter amount to withdraw: ");
                                    int withdrawAmount = scanner.nextInt();
                                    try {
                                        card.withdraw(withdrawAmount);
                                        System.out.println("Withdrawal successful. New balance: " + card.getBalance());
                                    } catch (InsufficientFundsException e) {
                                        System.out.println("Insufficient funds for withdrawal. Please try a different amount.");
                                        
                                    }
                                    break;
                                
                                    case 3:
                                        while (true) {
                                            try {
                                                System.out.print("Enter recipient's account number: ");
                                                int recipientAccountNumber = scanner.nextInt();
                                                System.out.print("Enter amount to transfer: ");
                                                int transferAmount = scanner.nextInt();
                                                bankSystem.transfer(card, recipientAccountNumber, transferAmount);
                                                
                                                break; // Successful transfer
                                            } catch (InputMismatchException e) {
                                                System.out.println("Invalid input. Please enter numeric values only.");
                                                scanner.nextLine(); // Clear buffer
                                            } catch (InvalidCardException e) {
                                                System.out.println("Invalid card details provided. Please check the details and try again.");
                                            } catch (InsufficientFundsException e) {
                                                System.out.println("Insufficient funds for transfer. Please try a different amount.");
                                            }
                                        }
                                        break;
                                    case 4:
                                        System.out.println("Current Balance: " + card.getBalance());
                                        break;
                                    case 5:
                                        card.printTransactionHistory();
                                        break;
                                    case 6:
                                        System.out.println("Closing the App");
                                        return; 
                                    default:
                                        System.out.println("Invalid choice. Please try again.");
                                }
                            }
                        } else {
                            throw new InputMismatchException("Incorrect PIN entered.");
                        }
                    } catch (InputMismatchException e) {
                        scanner.nextLine(); 
                        pinAttempts++;
                        if (pinAttempts >= 4) {
                            System.out.println("Too many failed attempts. Your app is temporarily locked for security purposes. " +
                                               "Please mail to security@royalbankofacadia.com and answer some questions to unlock it right away.");
                            return; // Exit the program after the 4th failed attempt
                        } else {
                            System.out.println("Incorrect PIN. Please try again with correct details.");
                        }
                    }
                }
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
