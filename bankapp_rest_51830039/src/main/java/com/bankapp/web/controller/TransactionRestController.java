package com.bankapp.web.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.DepositWithdrawbean;
import com.bankapp.model.entities.TransferBean;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.CustomerService;
import com.bankapp.model.service.TransactionLogService;

@RestController
@RequestMapping(path = "/aip")
public class TransactionRestController {

	private TransactionLogService transactionlogService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private CustomerService customerService;

	@Autowired
	public TransactionRestController(AccountService accountService, CustomerService customerService) {

		this.accountService = accountService;
		this.customerService = customerService;
	}

	@PostMapping(path = "/deposit")
	public ResponseEntity<Account> deposit(@RequestBody DepositWithdrawbean depositWithdrawbean, Principal principal) {
		accountService.deposit(depositWithdrawbean.getAccountNumber(), depositWithdrawbean.getAmount());
		return new ResponseEntity<Account>(HttpStatus.OK);
	}
	
	@PostMapping(path = "/withdraw")
	public ResponseEntity<Account> withdraw(@RequestBody DepositWithdrawbean depositWithdrawbean, Principal principal) {
		accountService.withdraw(depositWithdrawbean.getAccountNumber(), depositWithdrawbean.getAmount());
		return new ResponseEntity<Account>(HttpStatus.OK);
	}
	
	@PostMapping(path = "/transfer")
	public ResponseEntity<Account> transfer(@RequestBody TransferBean transferBean, Principal principal) {
		accountService.transfer(transferBean.getFromAccount(),transferBean.getToAccount(),transferBean.getAmount());
		return new ResponseEntity<Account>(HttpStatus.OK);
	}

}