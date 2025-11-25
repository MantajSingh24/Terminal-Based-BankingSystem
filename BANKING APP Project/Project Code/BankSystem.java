import java.util.*;

class BankSystem {
    private Map<Integer, Card> cards;

    public BankSystem() {
        cards = new HashMap<>();
    }

    public void addCard(Card card) {
        cards.put(card.getCardNumber(), card);
    }

    public Card validateCard(int cardNumber, String expiryDate) throws InvalidCardException {
        Card card = cards.get(cardNumber);
        if (card == null || !card.getExpiryDate().equals(expiryDate)) {
            throw new InvalidCardException("Invalid card number or expiry date.");
        }
        return card;
    }

    public boolean validatePIN(Card card, int pin) {
        return card.getPIN() == pin;
    }

    public void transfer(Card sender, int recipientAccountNumber, int amount) throws InsufficientFundsException, InvalidCardException {
        if (!cards.containsKey(recipientAccountNumber)) {
            throw new InvalidCardException("Recipient account number not found.");
        }
        if (amount > sender.getBalance()) {
            throw new InsufficientFundsException("Insufficient funds for transfer.");
        }
        sender.withdraw(amount);
        cards.get(recipientAccountNumber).deposit(amount);
        System.out.println("Transfer successful. New balance: " + sender.getBalance());
    }
}
