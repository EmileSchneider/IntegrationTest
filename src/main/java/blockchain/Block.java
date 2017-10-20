package blockchain;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class Block {

	int ID;
	int nonce;
	ArrayList<Transaction> transaction_list = new ArrayList<>();
	String previous_hash;
	String hash; //the hash which contains the proof of work
	
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}

	public int getNonce() {
		return nonce;
	}
	public void setNonce(int nonce) {
		this.nonce = nonce;
	}

	public ArrayList<Transaction> getTransaction_list() {
		return transaction_list;
	}
	public void setTransaction_list(ArrayList<Transaction> transaction_list) {
		this.transaction_list = transaction_list;
	}

	public String getPrevious_hash() {
		return previous_hash;
	}
	public void setPrevious_hash(String previous_hash) {
		this.previous_hash = previous_hash;
	}

	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}

	public void add_transaction(Transaction trans) {
		this.transaction_list.add(trans);
	}

	
	private String transaction_list_strings() {
		String ret_str = "";
		for(Transaction t : transaction_list) {
			ret_str.concat(t.transaction_string()); 
		}
		return ret_str;
	}
	
	public boolean is_hash_valid(String hash) {
		return hash.substring(0, 1) == "0";
	}
	public static String hash(String input) {
		
		 return Hashing.sha256().hashString(input, StandardCharsets.UTF_8).toString();	
		 
	}
	
//	
//	//to modify!!!
//	private String hash(String input) {
//		return "0000" + hash;
//	}
//	private boolean is_hash_valid(String hash) {
//		if(hash.substring(0, 4) == "0000") {
//			return true;
//		} else {
//			return false;
//		}
//	}
//	public void mine_block() {
//		
//		String ts = transaction_list_strings();
//		
//		String block_string = Integer.toString(ID) + " " + Integer.toString(nonce) + " " + ts + " " + previous_hash + " " + hash;
//		
//		int i = 0;
//		while(is_hash_valid(hash(block_string + i)) == false) {
//			i++;
//		}
//		
//		this.hash = hash(block_string + i);
//		this.nonce = i;
//	}
}

