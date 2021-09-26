package org.tokopedia.training;

import java.sql.Date;
import java.util.Calendar;
import java.time.*;
import java.time.DayOfWeek;

/**
 * Hello world!
 *
 */
public class App {

	public static void firstOrderScenario() {

		Grocery monthlyGrocery = new Grocery();

		// vegetable type and qty (all available)
		monthlyGrocery.orderVegetable("Carrot", 200);

		monthlyGrocery.orderVegetable("Pumpkin", 300);

		// getTotalBasketPrice
		float totalCartPrice = monthlyGrocery.getTotalPrice();
		System.out.println("Total Overall Vegetable Price: " + totalCartPrice + '$');

		// recognizing customer type (existing member)
		Customer wilson = new Customer("existing");
		System.out.println("Member Status: " + wilson.getMemberStatus());
		System.out.println("Member Discount rate: " + wilson.getDicountRateMember() + "%");
		System.out.println("Member Fee Price : " + wilson.getMemberFee() + "$");

		// payment process with (credit card)
		Payment credit = new CreditCard();

		float subtotal =  credit.paymentProcessing(totalCartPrice, wilson.getDicountRateMember(), wilson.getMemberFee());
		System.out.println("Succefully purchase and total billing:" + subtotal+'$');
	}

	public static void secondOrderSenario() {

		Grocery monthlyGrocery = new Grocery();

		// vegetable type and qty
		monthlyGrocery.orderVegetable("Carrot", 200);
		// order not available item (bayam not available at vegetable list)
		monthlyGrocery.orderVegetable("Bayam", 3);
		// order exceeded available qty
		monthlyGrocery.orderVegetable("Pumpkin", 300);

		// getTotalBasketPrice
		float totalCartPrice = monthlyGrocery.getTotalPrice();
		System.out.println("Total Overall Vegetable Price: " + totalCartPrice + '$');

		// recognizing customer type
		Customer wilson = new Customer("new");
		System.out.println("Member Status: " + wilson.getMemberStatus());
		System.out.println("Member Discount rate: " + wilson.getDicountRateMember() + "%");
		System.out.println("Member Fee Price : " + wilson.getMemberFee() + "$");

		// payment process gopay
		Payment gopay = new Payment();

		float subtotal = gopay.paymentProcessing(totalCartPrice, wilson.getDicountRateMember(), wilson.getMemberFee());
		System.out.println("Succefully purchase and total billing:" + subtotal+'$');

	}

	public static void thirdOrderSenario() {

		Grocery monthlyGrocery = new Grocery();

		// order exceeded available qty (only get all available qty)
		monthlyGrocery.orderVegetable("Carrot", 200000);

		// order exceeded available qty (only get all available qty)
		monthlyGrocery.orderVegetable("Pumpkin", 300000);

		// getTotalBasketPrice
		float totalCartPrice = monthlyGrocery.getTotalPrice();
		System.out.println("Total Overall Vegetable Price: " + totalCartPrice + '$');

		// recognizing customer type
		Customer wilson = new Customer("new");
		System.out.println("Member Status: " + wilson.getMemberStatus());
		System.out.println("Member Discount rate: " + wilson.getDicountRateMember() + "%");
		System.out.println("Member Fee Price : " + wilson.getMemberFee() + "$");

		// payment process
		Payment gopay = new Payment();

		float subtotal = gopay.paymentProcessing(totalCartPrice, wilson.getDicountRateMember(), wilson.getMemberFee());
		System.out.println("Succefully purchase and total billing:" + subtotal+'$');
	}

	public static void fourthOrderSenario() {

		Grocery monthlyGrocery = new Grocery();

		// quantity is empty because of prev customer buy all products
		monthlyGrocery.orderVegetable("Carrot", 20);

		// quantity is empty because of prev customer buy all products
		monthlyGrocery.orderVegetable("Pumpkin", 30);

		// getTotalBasketPrice
		float totalCartPrice = monthlyGrocery.getTotalPrice();
		System.out.println("Total Overall Vegetable Price: " + totalCartPrice + '$');

		// recognizing customer type
		Customer wilson = new Customer("new");
		System.out.println("Member Status: " + wilson.getMemberStatus());
		System.out.println("Member Discount rate: " + wilson.getDicountRateMember() + "%");
		System.out.println("Member Fee Price : " + wilson.getMemberFee() + "$");

		// payment process gopay
		Payment gopay = new Payment();

		float subtotal = gopay.paymentProcessing(totalCartPrice, wilson.getDicountRateMember(), wilson.getMemberFee());
		System.out.println("Succefully purchase and total billing:" + subtotal+'$');

	}



	public static void main(String[] args) {
		// Find the day from the local date
		Grocery.setVegetableData();

		firstOrderScenario();
		System.out.println("---------------------------------------------------------" + "\n" + "\n");
		secondOrderSenario();
		System.out.println("---------------------------------------------------------" + "\n" + "\n");
		thirdOrderSenario();
		System.out.println("---------------------------------------------------------" + "\n" + "\n");
		fourthOrderSenario();

	}
}
