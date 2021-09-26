package org.tokopedia.training;

public class CreditCard extends Payment {
	
	
	public float paymentProcessing(float amount, float discount, float memberFee){
		float subtotal = 0;
		subtotal = amount + (amount * 2 / 100) + memberFee  - (amount * discount/100);
		
		if(subtotal >100) {
			//minus 10 if total Billing > 100$
			subtotal-=10;
		}
		return subtotal;
		
	}
}
