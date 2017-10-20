package blockchain_tests;

import static org.junit.Assert.*;

import org.junit.Test;
import blockchain.*;

public class Blockchain_Integration_Test {

	Blockchain bc = new Blockchain();

	@Test
	public void test_genesis_block() {
		assertEquals(bc.getBch().size(), 0);
		assertEquals(bc.getCurrent_block().getID(), 0);
	}

	@Test
	public void test_valid_transaction() {
		Transaction trans = new Transaction("Emile", "Laz", 5);
		System.out.println(bc.is_transaction_valid(trans));
		bc.add_transaction(trans);
	}
	@Test
	public void test_transaction_overrun() {
		for(int i = 0; i < 20; i++) {
			Transaction trans = new Transaction("Emile", "Laz", 5);
			bc.add_transaction(trans);
		}
		for(int i = 0; i < 20; i++) {
			Transaction trans = new Transaction("Laz", "Emile", 5);
			bc.add_transaction(trans);
		}
		System.out.println(bc.getCurrent_block());
	}
}
