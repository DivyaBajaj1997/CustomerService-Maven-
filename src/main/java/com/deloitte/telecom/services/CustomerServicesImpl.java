package com.deloitte.telecom.services;

import java.util.Set;

import com.deloitte.telecom.dao.CustomerDaoImpl;
import com.deloitte.telecom.dao.ICustomerDao;
import com.deloitte.telecom.entities.Customer;
import com.deloitte.telecom.exceptions.InvalidMobileNoException;

public class CustomerServicesImpl implements ICustomerServices {

	private ICustomerDao dao = new CustomerDaoImpl();

	public ICustomerDao getCustomerDao() {
		return dao;
	}

	public CustomerServicesImpl(ICustomerDao customerDaoImp) {
		this.dao = customerDaoImp;
	}

	public void validateMobileNo(String mobileNo) {
		if (mobileNo == null || mobileNo.length() != 10) {
			throw new InvalidMobileNoException("Invalid Mobile Number");
		}
	}
	@Override
	public double accountBalanceEnquiry(String mobileNo) {
		validateMobileNo(mobileNo);
		return dao.accountBalanceEnquiry(mobileNo);
	}

	@Override
	public Customer rechargeAccount(String mobileNo, double bal) {
		validateMobileNo(mobileNo);
		return dao.rechargeAccount(mobileNo, bal);
	}

	@Override
	public Customer addAccount(Customer c) {
		validateMobileNo(c.getMobileNo());
		return dao.addAccount(c);
	}

	@Override
	public Set<Customer> allCustomers() {
		return dao.allCustomers();
	}

	@Override
	public Customer getAccountDetails(String mobileNo) {
		return dao.getAccountDetails(mobileNo);
		
	}

}
