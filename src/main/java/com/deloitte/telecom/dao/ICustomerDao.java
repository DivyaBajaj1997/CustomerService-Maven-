package com.deloitte.telecom.dao;

import java.util.Map;
import java.util.Set;

import com.deloitte.telecom.entities.Customer;

public interface ICustomerDao {
	double accountBalanceEnquiry(String mobileNo);

	Customer rechargeAccount(String mobileNo, double bal);

	Customer addAccount(Customer c);

	Set<Customer> allCustomers();

	Map<String, Customer> getStore();
	
	public Customer getAccountDetails(String mobileNo);
}
