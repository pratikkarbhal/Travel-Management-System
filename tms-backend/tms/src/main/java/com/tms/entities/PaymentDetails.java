package com.tms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PAYMENT_DETAILS")
public class PaymentDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PAYMENT_ID")
	private int paymentId;
	
	@Column(name = "PAYMENT_MODE")
    private String paymentMode;
	
	@Column(name = "BANK_NAME")
    private String bankName;
	
	@Column(name = "CARD_NO")
    private long cardNo;
	
	@Column(name = "NET_AMOUNT")
    private double netAmount;
	
	@Column(name = "PAYMENT_STATUS")
    private String paymentStatus;
	
	@Column(name = "USER_ID")
    private int userId;
	
	//Defining Constructor
	public PaymentDetails() {}

	public PaymentDetails(int paymentId, String paymentMode, String bankName, long cardNo, double netAmount,
			String paymentStatus, int userId, Package pack) {
		super();
		this.paymentId = paymentId;
		this.paymentMode = paymentMode;
		this.bankName = bankName;
		this.cardNo = cardNo;
		this.netAmount = netAmount;
		this.paymentStatus = paymentStatus;
		this.userId = userId;
	}

	// Getters and setters
	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public long getCardNo() {
		return cardNo;
	}

	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}

	public double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	//ToString

	@Override
	public String toString() {
		return "PaymentDetails [paymentId=" + paymentId + ", paymentMode=" + paymentMode + ", bankName=" + bankName
				+ ", cardNo=" + cardNo + ", netAmount=" + netAmount + ", paymentStatus=" + paymentStatus + ", userId="
				+ userId + ", ]";
	}

	
}
