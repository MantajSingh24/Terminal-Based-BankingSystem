interface TransactionOperations {
    void deposit(int amount);
    void withdraw(int amount) throws InsufficientFundsException;
    void recordTransaction(String type, int amount);
}

