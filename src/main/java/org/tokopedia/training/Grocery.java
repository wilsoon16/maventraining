package org.tokopedia.training;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Grocery {

	int quantity;
	int item;
	int price;
	static Map<String, Float> vegetablePrice = new HashMap<>();
	static Map<String, Integer> vegetableQuantity = new HashMap<>();
	Map<String, Integer> purchasedVegetable = new HashMap<>();
	
	public static void setVegetableData() {
		LocalDate localDate = LocalDate.now();
		DayOfWeek dayOfWeek = DayOfWeek.from(localDate);

		// qty and price will change according to current day
		float indexOfDay = dayOfWeek.getValue();
		Grocery.setVegetablePrice(indexOfDay);
		Grocery.setVegetableQuantity(indexOfDay);
	}

	public static void setVegetablePrice(Float indexOfDay) {
		// price change everyday
		// price will increase according to index of day % ex: monday price 1% is
		// higher, tueday 2% higher, etc

		vegetablePrice.put("Carrot", 30 + (30 * indexOfDay / 100));
		vegetablePrice.put("Onion", 20 + (20 * indexOfDay / 100));
		vegetablePrice.put("Cabbage", 10 + (10 * indexOfDay / 100));
		vegetablePrice.put("Pumpkin", 10 + (10 * indexOfDay / 100));
		vegetablePrice.put("Sweet Potato", 10 + (10 * indexOfDay / 100));

	}

	public static void setVegetableQuantity(Float indexOfDay) {

		// quantiy will change accroding to day

		vegetableQuantity.put("Carrot", 100 * Math.round(indexOfDay));
		vegetableQuantity.put("Onion", 100 * Math.round(indexOfDay));
		vegetableQuantity.put("Cabbage", 500 * Math.round(indexOfDay));
		vegetableQuantity.put("Pumpkin", 200 * Math.round(indexOfDay));

	}

	public void orderVegetable(String vegetable, int qty) {
		// function for reserve order at grocery

		if (vegetableQuantity.containsKey(vegetable)) {
			this.purchasedVegetable.put(vegetable, qty);
		} else {
			System.out.println("Your requested item : " + vegetable + " not available");
		}
	}

	public float getTotalPrice() {
		// get overall price based on available quantity and current price

		float total = 0;
		for (Map.Entry<String, Integer> entry : getOrderList().entrySet()) {

			int purchasedQty = this.purchasedVegetable.get(entry.getKey());
			int totalStock = vegetableQuantity.get(entry.getKey());
			float currItemPrice = this.getVegetablePrice(entry.getKey());

			// check if quantity is still available
			if (totalStock >= purchasedQty) {

				total += currItemPrice * purchasedQty;
				// reduce total vegetable quantity
				vegetableQuantity.put(entry.getKey(), getVegetableQuantity(entry.getKey()) - purchasedQty);
				System.out.println("You have purchased: " + purchasedQty + " " + entry.getKey() + "." + " Total "
						+ entry.getKey() + " Price: " + currItemPrice * purchasedQty + '$');
				// check if pruchase order more than available stock then get all available item
			} else if (purchasedQty >= totalStock && totalStock != 0) {

				total += currItemPrice * totalStock;
				System.out.println("Your order request " + entry.getKey() + ":" + purchasedQty
						+ " exceeded available item, you only get item according current available stock: "
						+ totalStock);
				// reduce total vegetable quantity
				vegetableQuantity.put(entry.getKey(), getVegetableQuantity(entry.getKey()) - totalStock);
				System.out.println("You have purchased: " + totalStock + " " + entry.getKey() + "." + " Total "
						+ entry.getKey() + " Price: " + currItemPrice * totalStock + '$');
			} else {
				System.out.println("Item currently not available");
			}
		}

		return total;
	}

	public Map<String, Integer> getOrderList() {
		return this.purchasedVegetable;
	}

	public static Float getVegetablePrice(String key) {
		return vegetablePrice.get(key);
	}

	public static Integer getVegetableQuantity(String key) {
		return vegetableQuantity.get(key);
	}

}
