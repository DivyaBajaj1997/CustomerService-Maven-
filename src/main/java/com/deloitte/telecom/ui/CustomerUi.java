package com.deloitte.telecom.ui;

import java.util.Collection;
import java.util.Set;

import com.deloitte.telecom.dao.CustomerDaoImpl;
import com.deloitte.telecom.entities.Customer;
import com.deloitte.telecom.exceptions.CustomerNotFoundException;
import com.deloitte.telecom.exceptions.InvalidMobileNoException;
import com.deloitte.telecom.services.CustomerServicesImpl;
import com.deloitte.telecom.services.ICustomerServices;

public class CustomerUi {
	ICustomerServices c = new CustomerServicesImpl(new CustomerDaoImpl());

	public static void main(String[] args) {
		CustomerUi ui = new CustomerUi();
		ui.execute();
	}

	public void execute() {
		try {
			Customer c1 = new Customer("9999900000", "Divya", "Prepaid", 880.67);
			Customer c2 = new Customer("9999923445", "kavya", "Postpaid", 578.89);
			c.addAccount(c1);
			c.addAccount(c2);
			Set<Customer> set = c.allCustomers();
			print(set);
			System.out.println("\n");
			
	
			double amt = c.accountBalanceEnquiry("9999900000");
			System.out.println("The amount in the balance is " + amt);
			
			
			Customer cust = c.rechargeAccount("9999900000", 1000);
			System.out.println("\n");
			System.out.println("The account is recharged. The details are now as follows:");
			System.out.println("[MobileNo=" + cust.getMobileNo() + ", Name=" + cust.getName() + ", AccountType="
					+ cust.getAccountType() + ", Balance=" + cust.getBalance() + "]");
			
			
		} catch (CustomerNotFoundException e) {
			System.out.println("Customer not found");
		} catch (InvalidMobileNoException e) {
			System.out.println("Invalid Mobile No");
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("Something went wrong");
		}

	}

	public void print(Collection<Customer> c) {
		for (Customer cust : c) {
			System.out.println("[MobileNo=" + cust.getMobileNo() + ", Name=" + cust.getName() + ", AccountType="
					+ cust.getAccountType() + ", Balance=" + cust.getBalance() + "]");
		}
	}
}
