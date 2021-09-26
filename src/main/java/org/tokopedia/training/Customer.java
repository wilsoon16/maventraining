package org.tokopedia.training;

public class Customer {

	private String memberStatus;
	private float discountRate;
	private int memberFee;

	Customer() {
		this.memberStatus = "non member";
		this.discountRate = 0;
		this.memberFee = 0;
	}

	Customer(String memberStatus) {
		this.memberStatus = memberStatus;
	}

	public float getDicountRateMember() {
		this.discountRate = 0;

		if (this.memberStatus == "new" || this.memberStatus == "existing") {
			this.discountRate = 5;
		}

		return discountRate;
	}
	
	public String getMemberStatus() {

		return this.memberStatus;
	}

	public int getMemberFee() {

		int memberFee = 0;

		if (this.memberStatus == "new") {
			memberFee = 100;
		}

		return memberFee;
	}

}
