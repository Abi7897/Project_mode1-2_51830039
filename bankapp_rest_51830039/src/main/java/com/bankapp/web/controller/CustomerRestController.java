package com.bankapp.web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.AccountUpdate;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.entities.FormBean;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.CustomerService;
import com.bankapp.model.service.exceptions.CustomerNotFoundException;



@RestController
@RequestMapping(path="/api")
public class CustomerRestController {
	@Autowired
	private AccountService accountService;
	private CustomerService customerService;
	@Autowired
	public CustomerRestController(CustomerService customerService) {
		this.customerService = customerService;
	}
	@GetMapping(path="customer",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> getAllCustomers(){
		return new ResponseEntity<List<Customer>>( customerService.getAllCustomers(),HttpStatus.OK);
	}
	
	@GetMapping(path="customer/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getAnCustomer(@PathVariable(name="id")int id){
		Customer customer=customerService.findCustomerById(id).orElseThrow(CustomerNotFoundException::new);

		return new ResponseEntity<Customer>( customer,HttpStatus.OK);
	}

/*@PutMapping(path="customer/{id}",consumes=MediaType.APPLICATION_JSON_VALUE,
produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Customer> updateCustomer(@PathVariable(name="id")int id,
		@RequestBody Customer customer){
	
	return new ResponseEntity<Customer>( customerService.updateCustomer(id, customer),
			HttpStatus.OK);
}*/
@DeleteMapping(path="customer/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Void> deleteCustomer(@PathVariable(name="id")Long id){
	accountService.deleteCustomer(id);
	
	return new ResponseEntity<Void>( HttpStatus.NO_CONTENT);
}



@PutMapping(path="customer/{accountNumber}",consumes=MediaType.APPLICATION_JSON_VALUE,
produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Account> updateAccount(@PathVariable(name="accountNumber") Long accountNumber,
		@RequestBody AccountUpdate accountUpdate){
	Customer customer=accountService.getCustomerById(accountNumber);
	
	customer.setEmail(accountUpdate.getEmail());
	customer.setPhone(accountUpdate.getPhone());
	customer.setAddress(accountUpdate.getAddress());
	customer.setCity(accountUpdate.getCity());
	customer.setCountry(accountUpdate.getCountry());
	Account account=accountService.getAccountById(accountNumber);
	account.setBalance(accountUpdate.getBalance());
	account.setBlocked(accountUpdate.isBlocked());
	customer.setAccount(account);
	account.setCustomer(customer);
	return new ResponseEntity<Account>(accountService.createAccount(account),HttpStatus.OK);
	
}
@PostMapping(path="customer",consumes=MediaType.APPLICATION_JSON_VALUE,
produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Account> addAcc(@RequestBody FormBean formBean){
	Customer customer=new Customer(formBean.getName(),formBean.getEmail(),formBean.getPhone(),
			formBean.getAddress(),formBean.getCity(),formBean.getCountry());
	Account account=new Account(formBean.getBalance(),customer,formBean.isBlocked());
	customer.setAccount(account);
	
	return new ResponseEntity<Account>( accountService.addAccount(account),HttpStatus.CREATED);
}
}	
	
	/*@GetMapping(path="admin")
	public String homeAdmin(){
		return "hello to admin ";
	}
	
	@GetMapping(path="mgr")
	public String homeMgr(){
		return "hello to mgr ";
	}
	
	@GetMapping(path="emp")
	public String homeEmp(){
		return "hello to emp ";
	}
	
	@GetMapping(path="clerk")
	public String homeClerk(){
		return "hello to clerk ";
	}

*/

