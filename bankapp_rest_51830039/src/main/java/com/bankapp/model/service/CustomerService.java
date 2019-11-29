package com.bankapp.model.service;

import java.util.List;
import java.util.Optional;

import com.bankapp.model.entities.Customer;


public interface CustomerService {
	public List<Customer> getAllCustomers();
	public Optional<Customer>findCustomerById(int id);
	public Optional<Customer>findCustomerByName(String name);
	
	public void deleteCustomer(Long id);
	public Customer updateCustomer(int id,Customer customer);
	public Customer addCustomer(Customer customer);
}
