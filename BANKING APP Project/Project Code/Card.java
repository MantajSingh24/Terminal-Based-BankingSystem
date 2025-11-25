import java.util.*;

class Card implements TransactionOperations {
    private String customerName;
    private String expiryDate;
    private int cardNumber;
    private int pin;
    private int balance;
    private List<Transaction> transactionHistory;

    public Card(String customerName, String expiryDate, int cardNumber, int pin, int balance) {
        this.customerName = customerName;
        this.expiryDate = expiryDate;
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public int getPIN() {
        return pin;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public void deposit(int amount) {
        balance += amount;
        recordTransaction("Deposit", amount);
    }

    @Override
    public void withdraw(int amount) throws InsufficientFundsException {
        if (balance < amount) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        }
        balance -= amount;
        recordTransaction("Withdrawal", amount);
    }

    @Override
    public void recordTransaction(String type, int amount) {
        Transaction transaction = new Transaction(type, amount, new Date());
        transactionHistory.add(transaction);
    }

    public void printTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }
        System.out.println("Transaction History:");
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}
