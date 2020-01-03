package com.deloitte.telecom.services;

import java.util.Map;
import org.junit.*;
import com.deloitte.telecom.dao.CustomerDaoImpl;
import com.deloitte.telecom.entities.Customer;
import com.deloitte.telecom.exceptions.CustomerNotFoundException;
import com.deloitte.telecom.exceptions.InvalidMobileNoException;

public class CustomerServiceImplTest {
	@Test
	public void testCreateCustomer_1() {
		CustomerServicesImpl service = new CustomerServicesImpl(new CustomerDaoImpl());
		String mobileNo = "1234567890";
		double balance = 1000;
		String name = "Kavya";
		String accountType = "Postpaid";
		Customer c = new Customer(mobileNo, name, accountType, balance);
		Customer customer = service.addAccount(c);
		Assert.assertNotNull(customer);
		double resultBalance = customer.getBalance();
		Assert.assertEquals(balance, resultBalance, 0);
		Assert.assertEquals(name, customer.getName());
		Map<String, Customer> store = service.getCustomerDao().getStore();
		Customer expected = store.get(mobileNo);
		Assert.assertNotNull(expected);
		Assert.assertEquals(expected, expected);
	}
	
	@Test(expected = InvalidMobileNoException.class)
	public void testCreateCustomer_2() {
		CustomerServicesImpl service = new CustomerServicesImpl(new CustomerDaoImpl());
		String mobileNo = "";
		double balance = 1000;
		String name = "Kavya";
		String accountType = "Postpaid";
		Customer c = new Customer(mobileNo, name, accountType, balance);
		Customer customer = service.addAccount(c);
		Assert.assertNotNull(customer);
		double resultBalance = customer.getBalance();
		Assert.assertEquals(balance, resultBalance, 0);
		Assert.assertEquals(name, customer.getName());
		Map<String, Customer> store = service.getCustomerDao().getStore();
		Customer expected = store.get(mobileNo);
		Assert.assertNotNull(expected);
		Assert.assertEquals(expected, expected);
	}
	
	@Test
	public void testFindCustomerById() {
		CustomerServicesImpl service = new CustomerServicesImpl(new CustomerDaoImpl());
		String mobileNo = "1234567890";
		double balance = 1000;
		String name = "Kavya";
		String accountType = "Postpaid";
		Customer c = new Customer(mobileNo, name, accountType, balance);
		Customer customer = service.addAccount(c);
		Map<String, Customer> store = service.getCustomerDao().getStore();
		store.put(mobileNo,customer);
		Customer result = service.getAccountDetails(mobileNo);
		Assert.assertEquals(customer, result);
	}
}
