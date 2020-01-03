package com.deloitte.telecom.services;

import java.util.Set;

import com.deloitte.telecom.dao.ICustomerDao;
import com.deloitte.telecom.entities.Customer;

public interface ICustomerServices {
	double accountBalanceEnquiry(String mobileNo);

	Customer rechargeAccount(String mobileNo, double bal);

	Customer addAccount(Customer c);

	Set<Customer> allCustomers();
	
	public Customer getAccountDetails(String mobileNo);
}
