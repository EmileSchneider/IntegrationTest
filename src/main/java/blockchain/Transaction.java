package blockchain;

public class Transaction {
	
	String sender;
	String recipient;
	int amount;	
	
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String transaction_string() {
		return sender + " sends " + Integer.toString(amount) + " to " + recipient;
	}

	public Transaction(String sender, String recipient, int amount) {
		this.sender = sender;
		this.recipient = recipient;
		this.amount = amount;
	}
	
}
