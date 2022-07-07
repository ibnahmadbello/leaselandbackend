package com.arab.leaseland.entity;

public class RRRequest {

	private String serviceTypeId;
	private long orderId;
	private String amount;
	private String payerName;
	private String payerEmail;
	private String payerPhone;
	private String description;
	
	public RRRequest(String serviceTypeId, String amount, long orderId, String payerName, String payerEmail,
			String payerPhone, String description) {
		super();
		this.serviceTypeId = serviceTypeId;
		this.amount = amount;
		this.orderId = orderId;
		this.payerName = payerName;
		this.payerEmail = payerEmail;
		this.payerPhone = payerPhone;
		this.description = description;
	}

	public String getServiceTypeId() {
		return serviceTypeId;
	}

	public void setServiceTypeId(String serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPayerName() {
		return payerName;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	public String getPayerEmail() {
		return payerEmail;
	}

	public void setPayerEmail(String payerEmail) {
		this.payerEmail = payerEmail;
	}

	public String getPayerPhone() {
		return payerPhone;
	}

	public void setPayerPhone(String payerPhone) {
		this.payerPhone = payerPhone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

}
