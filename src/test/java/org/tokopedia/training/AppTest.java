package org.tokopedia.training;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void assertPriceDynamicEveryDay() {
		LocalDate localDate = LocalDate.of(2021, Month.SEPTEMBER, 26);
		DayOfWeek dayOfWeek = DayOfWeek.from(localDate);
		float indexOfDay = dayOfWeek.getValue();
		Grocery.setVegetablePrice(indexOfDay);

		Float getPriceSunday = Grocery.getVegetablePrice("Pumpkin");

		localDate = LocalDate.of(2021, Month.SEPTEMBER, 27);
		dayOfWeek = DayOfWeek.from(localDate);
		indexOfDay = dayOfWeek.getValue();
		Grocery.setVegetablePrice(indexOfDay);

		Float getPriceMonday = Grocery.getVegetablePrice("Pumpkin");

		assertNotEquals(getPriceSunday, getPriceMonday);
	}

	@Test
	public void assertQuantityDynamicEveryDay() {
		LocalDate localDate = LocalDate.of(2021, Month.SEPTEMBER, 26);
		DayOfWeek dayOfWeek = DayOfWeek.from(localDate);
		float indexOfDay = dayOfWeek.getValue();

		Grocery.setVegetableQuantity(indexOfDay);

		int getQtySunday = Grocery.getVegetableQuantity("Pumpkin");
		System.out.println(getQtySunday);
		
		localDate = LocalDate.of(2021, Month.SEPTEMBER, 27);
		dayOfWeek = DayOfWeek.from(localDate);
		indexOfDay = dayOfWeek.getValue();

		Grocery.setVegetableQuantity(indexOfDay);
		int getQtyMonday = Grocery.getVegetableQuantity("Pumpkin");
		System.out.println(getQtyMonday);

		assertNotEquals(getQtySunday, getQtyMonday);
	}

	@Test
	public void assertGetTotalPrice() {
		LocalDate localDate = LocalDate.of(2021, Month.SEPTEMBER, 26); //7
		DayOfWeek dayOfWeek = DayOfWeek.from(localDate);
		float indexOfDay = dayOfWeek.getValue();
	
		Grocery.setVegetablePrice(indexOfDay);

		Grocery.setVegetableQuantity(indexOfDay);
		Grocery monthlyGrocery = new Grocery();
		
		monthlyGrocery.orderVegetable("Carrot", 2);
		Float totalPrice = monthlyGrocery.getTotalPrice();
		Float comparedPrice = 64.2f;
		
		
		assertEquals(totalPrice,comparedPrice);
	}
	
	@Test
	public void assertOrderPriceExceedQty() {
		LocalDate localDate = LocalDate.of(2021, Month.SEPTEMBER, 26); //7
		DayOfWeek dayOfWeek = DayOfWeek.from(localDate);
		float indexOfDay = dayOfWeek.getValue();
	
		Grocery.setVegetablePrice(indexOfDay);

		Grocery.setVegetableQuantity(indexOfDay);
		Grocery monthlyGrocery = new Grocery();
		
		//total stock =700, price = 32.1
		monthlyGrocery.orderVegetable("Carrot", 200000000);
		Float totalPrice = monthlyGrocery.getTotalPrice();
		//700*32.1=22469.998
		Float comparedPrice = 22469.998f;
		
		assertEquals(totalPrice,comparedPrice);
		
	}
	
	
	@Test
	public void assertNewMemberDiscount() {
		Customer wilson = new Customer("new");
		Float memberDiscount = wilson.getDicountRateMember();
		Float expectedDiscount = 5f;
		assertEquals(memberDiscount,expectedDiscount);
		
	}
	
	@Test
	public void assertNewMemberFee() {
		Customer wilson = new Customer("new");
		int memberFee = wilson.getMemberFee();
		int expectedFee = 100;
		assertEquals(memberFee,expectedFee);
		
	}
	
	
	@Test
	public void assertExistingMemberDiscount() {
		Customer wilson = new Customer("existing");
		Float memberDiscount = wilson.getDicountRateMember();
		Float expectedDiscount = 5f;
		assertEquals(memberDiscount,expectedDiscount);
		
	}
	
	@Test
	public void assertExistingMemberFee() {
		Customer wilson = new Customer("existing");
		int memberFee = wilson.getMemberFee();
		int expectedFee = 0;
		assertEquals(memberFee,expectedFee);
		
	}
	
	
	@Test
	public void assertPaymentCreditCard() {
		Payment credit = new CreditCard();

		Float subtotal = credit.paymentProcessing(50, 0, 0);
		//2% *50 = 1, 1+50= 51;
		Float expectedTotalPrice = 51f;
		assertEquals(subtotal,expectedTotalPrice);
		
	}
	
	@Test
	public void assertOtherPayment() {
		Payment gopay = new Payment();

		Float subtotal = gopay.paymentProcessing(50, 0, 0);
		//2% *50 = 1, 1+50= 51;
		Float expectedTotalPrice = 50f;
		assertEquals(subtotal,expectedTotalPrice);
		
	}
	
	
	@Test
	public void assertPaymentMoreThan100() {
		Payment gopay = new Payment();

		Float subtotal = gopay.paymentProcessing(120, 0, 0);
		//deducted by 10 if > 100$;
		Float expectedTotalPrice = 110f;
		assertEquals(subtotal,expectedTotalPrice);
		
	}
}
