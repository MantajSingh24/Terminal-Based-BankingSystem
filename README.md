# Royal Bank of Acadia – Terminal-Based Banking System

> This project is a real-time, **terminal-based banking system** created for the **Software Engineering 1** course at Acadia University. The system supports essential banking operations such as deposits, withdrawals, transfers, and transaction history, all through a secure, text-based interface.
>
> The system is designed with **PIN authentication**, real-time updates, **modular Java classes**, and robust error handling to simulate a simplified but realistic banking experience. (Based on our official project documentation)

---

## 🎮 How to Run

> The program runs by executing `BankManagementSystem.java` in any Java text editor or IDE.
>
> **Steps:**
> 1.  Install **Java 8 or higher**
> 2.  Open the project folder in VS Code, IntelliJ, Eclipse, or any IDE
> 3.  Run the main file:
>
>     ```java
>     BankManagementSystem.java
>     ```

---

## 🏦 Banking Features

> * **Deposit:** Add money to your account. Balance updates instantly, and the transaction is recorded.
> * **Withdraw:** Withdraw only if the balance is sufficient. Real-time balance update.
> * **Fund Transfer:** Transfer money to another valid account. Both sender and receiver balances update instantly.
> * **View Balance:** Check your current available balance.
> * **View Transaction History:** Shows multiple past transactions, including type, amount, and timestamp. (Screenshots in the report show multiple entries displayed clearly (page 15–16)).

---

## 🔐 Security Features

> * **PIN-based authentication**
> * **Account lockout** after 4 incorrect login attempts (As shown in the report’s terminal screenshots (page 14))
> * Incorrect card or recipient validation
> * **Error handling** for:
>     * Invalid inputs
>     * Insufficient funds
>     * Wrong card number, expiry date, or PIN
> * Secure transaction processing

---

## ⚙️ System Design (Java Classes)

> The system employs a modular design using the following core classes:
>
> * **`BankManagementSystem.java`:** Main interface, controls login, menu, and user interaction.
> * **`BankSystem.java`:** Backend logic, validates card details, balances, and handles transfers.
> * **`Card.java`:** Stores card number, PIN, balance, and transaction list.
> * **`Transaction.java`:** Stores transaction type, amount, and date/time.

---

## 🧪 Testing Highlights

> Comprehensive testing ensured stability and security:
>
> * **Unit Testing:** Valid deposits, withdrawals, transfers, and custom exceptions (e.g., `InsufficientFundsException`).
> * **Integration Testing:** Interaction between `BankSystem` and `Card`.
> * **Edge Case Testing:** Invalid card number, wrong PIN, insufficient balance, wrong recipient account.
> * **Security Testing:** Account lockout functionality.
> * **User Testing:** Ensured simple interface and smooth experience.

---

## 🏆 Results & Lessons Learned

> ### Results
> * All core features successfully implemented.
> * Real-time balance updates working smoothly.
> * Strong security with PIN & lockouts.
> * Clear feedback messages for all user actions.
>
> ### Lessons Learned
> * Proper planning (use-case diagrams) saves time.
> * Security is crucial in finance apps.
> * Error handling improves reliability.
> * Testing every feature prevents issues later.
> * Modular design makes future upgrades easy.

---

## 👥 Team

> * Mantaj Singh
> * Shivam Sangwan
> * Neer Patel
