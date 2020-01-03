package com.deloitte.telecom.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.deloitte.telecom.entities.Customer;
import com.deloitte.telecom.exceptions.AccountAlreadyExist;
import com.deloitte.telecom.exceptions.CustomerNotFoundException;

public class CustomerDaoImpl implements ICustomerDao {
	private Map<String, Customer> store = new HashMap<>();

	public Map<String, Customer> getStore() {
		return store;
	}

	@Override
	public double accountBalanceEnquiry(String mobileNo) {
		Customer c = store.get(mobileNo);
		if (c == null) {
			throw new CustomerNotFoundException("Customer Not Found");
		}
		return c.getBalance();
	}

	@Override
	public Customer rechargeAccount(String mobileNo, double amt) {
		Customer c = store.get(mobileNo);
		if (c == null) {
			throw new CustomerNotFoundException("Customer Not Found");
		}
		c.setBalance(c.getBalance() + amt);
		return c;
	}

	@Override
	public Set<Customer> allCustomers() {
		Collection<Customer> c = store.values();
		Set<Customer> set = new HashSet<>(c);
		return set;

	}

	@Override
	public Customer addAccount(Customer cust) {
		Customer c = store.get(cust.getMobileNo());
		if (c != null) {
			throw new AccountAlreadyExist("An account is already linked with this mobile no");
		}
		store.put(cust.getMobileNo(), cust);
		return cust;
	}
	
	@Override
	public Customer getAccountDetails(String mobileNo) {
		Customer c = store.get(mobileNo);
		if (c == null) {
			throw new CustomerNotFoundException("Customer Not Found");
		}
		return c;
	}

}
