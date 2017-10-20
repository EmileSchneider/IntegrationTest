package blockchain;

import java.util.ArrayList;

public class Blockchain {

	ArrayList<Block> bch = new ArrayList<>();
	Block current_block = new Block();
	
	public ArrayList<Block> getBch() {
		return bch;
	}

	public void setBch(ArrayList<Block> bch) {
		this.bch = bch;
	}

	public Block getCurrent_block() {
		return current_block;
	}

	public void setCurrent_block(Block current_block) {
		this.current_block = current_block;
	}

	public boolean is_transaction_valid(Transaction trans) {
		/*
		 * Parameters: Transaction;
		 * Return: boolean;
		 * 
		 * if the sender of the transaction has enough funds to pay, return true else, return false;
		 */
		String sender = trans.getSender();
		int amount = trans.getAmount();
		
	
		/*
		 * this part iterates through every block and every transaction of the block, 
		 * 
		 * then it adds the amount the current transaction sender has ever recived to the negative of the current transaction 
		 * amount. 
		 * 
		 * if the sum is bigger than 0 that means that the sender has enough funds to do the transaction and therefore the transaction
		 * is valid.
		 */
		
		amount *= 1;
		
		for(Block b : bch) {
			System.out.println(b);
			for(Transaction t : b.getTransaction_list()) {
				System.out.println(t);
				if(t.getRecipient().equals(sender)) {
					amount += t.getAmount();
				}
				if(amount >= 0) {
					return true;
				}	
			}
		} 
		return false;
	}

	public boolean is_block_valid(Block b) {
		if(b.getID() <= bch.size()) {
			return false;
		}
		if(b.getPrevious_hash() != bch.get(bch.size() - 1).getHash()) {
			return false;
		}
		if(this.is_valid_proof(b.getHash()) == false) {
			return false;
		}
		return true;
	}

	public boolean is_valid_proof(String hash) {
		if(hash.substring(0, 1) == "0") {
			return true;
		}
		return false;
	}

	public void add_transaction(Transaction trans) {
		if(is_transaction_valid(trans)) {
			current_block.add_transaction(trans);			
		}
	}
	
	public void add_block(Block b) {
		if(is_block_valid(b)) {
			bch.add(b);
		}
	}

	public void new_block() {
		current_block = new Block();
	}
	
	public Blockchain() {
		
		/*
		 * creation of the genesis block, the first one in the chain
		 */
		Block genesis_block = new Block();
		genesis_block.setID(0);
		genesis_block.setPrevious_hash("0");
		
		Transaction gift_from_god = new Transaction("God", "Emile", 50);
		genesis_block.add_transaction(gift_from_god);
		
		//genesis_block.mine_block();
		
		new_block();
		
	}
	
}	
