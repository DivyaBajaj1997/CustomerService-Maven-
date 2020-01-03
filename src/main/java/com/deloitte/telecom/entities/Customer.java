package com.deloitte.telecom.entities;

public class Customer {
	
//data members
private String mobileNo;
private String name;
private String accountType;
private double balance;

//member functions
public String getMobileNo() {
	return mobileNo;
}
public void setMobileNo(String mobileNo) {
	this.mobileNo = mobileNo;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAccountType() {
	return accountType;
}
public void setAccountType(String accountType) {
	this.accountType = accountType;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}

//constructor
public Customer(String mobileNo, String name, String accountType, double balance) {
	this.mobileNo = mobileNo;
	this.name = name;
	this.accountType = accountType;
	this.balance = balance;
}

@Override
public String toString() {
		return "Customer [mobileNo=" + mobileNo + ", name=" + name + ", accountType=" + accountType + ", balance="
				+ balance + "]";
}
//hasCode function 
@Override
public int hashCode() {
	return mobileNo.hashCode();
}

//equals function
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null || ! (obj instanceof Customer))
		return false;
	Customer cust = (Customer)obj;
	return (this.mobileNo.equals(cust.mobileNo));
}

}
