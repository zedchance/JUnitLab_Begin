package csc131.junit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

class GiftCardTest
{
	@Test
	void getIssuingStore()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getIssuingStore()", issuingStore, card.getIssuingStore());
	}
	
	@Test
	void getBalance()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getBalance()", balance, card.getBalance(), 0.001);
	}
	
	@Test
	void deduct()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("deduct()", "Invalid Transaction", card.deduct(-1));
		assertEquals("deduct()", "Remaining Balance:  50.00", card.deduct(50));
		assertEquals("deduct()", "Amount Due:  25.00", card.deduct(75));
	}
	
	@Test
	void constructorIncorrectIDLow()
	{
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(-1, 100.00);});
	}
	
	@Test
	void constructorIncorrectIDHigh()
	{
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(10000, 100.00);});
	}
	
	@Test
	void negativeBalance()
	{
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(1, -1);});
	}
}
