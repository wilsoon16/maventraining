package org.tokopedia.training;

public class Payment {

	public float paymentProcessing(float amount, float discount, float memberFee) {
		float subtotal = 0;

		subtotal = amount + memberFee - (amount * discount/100);
		if (subtotal > 100) {
			subtotal -= 10;
		}

		
		return subtotal;
	}

}
