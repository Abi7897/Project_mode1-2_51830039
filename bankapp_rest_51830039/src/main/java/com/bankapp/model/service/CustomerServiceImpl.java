package com.bankapp.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.entities.Customer;
import com.bankapp.model.repo.CustomerRepository;
import com.bankapp.model.service.exceptions.CustomerNotFoundException;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	private  CustomerRepository dao;
	
@Autowired
	public CustomerServiceImpl(CustomerRepository dao) {
		
		this.dao = dao;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Customer> findCustomerById(int id) {
		// TODO Auto-generated method stub
		return dao.findById((long) id);
	}

	@Override
	public Optional<Customer> findCustomerByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCustomer(Long id) {
		dao.deleteById((long) id);
		 
	}

	@Override
	public Customer updateCustomer(int id, Customer customer) {
		
		Customer customerToBeUpdate=dao.findById((long) id).
				orElseThrow(CustomerNotFoundException::new);
		customerToBeUpdate.setPhone(customer.getPhone());
		return dao.save(customerToBeUpdate);
	}

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return dao.save(customer);
	}

}
