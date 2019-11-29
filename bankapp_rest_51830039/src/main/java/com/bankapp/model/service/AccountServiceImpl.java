package com.bankapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.AccountTransaction;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.repo.AccountRepository;
import com.bankapp.model.repo.AccountTransactionRepository;
import com.bankapp.model.repo.CustomerRepository;
import com.bankapp.model.repo.TransactionLogRepository;
import com.bankapp.model.service.exceptions.AccountNotFoundException;
import com.bankapp.model.service.exceptions.CustomerNotFoundException;
import com.bankapp.model.service.exceptions.NotSufficientFundException;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountTransactionRepository accountTransactionRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private TransactionLogRepository transactionLogRepository;

	@Override
	public void blockAccount(Long accountNumber) {

	}
	@Override
	public List<Account> getAllAccounts() {
		
		return accountRepository.findAll();
	}

	@Override
	public Account createAccount(Account account) {
		accountRepository.save(account);
		customerRepository.save(account.getCustomer());
		return account;
	}

	@Override
	public void deposit(Long accountNumber, double amount) {
		Account account = accountRepository.findById(accountNumber)
				.orElseThrow(AccountNotFoundException::new);
		account.setBalance(account.getBalance() + amount);
		/*AccountTransaction accountTransaction=new AccountTransaction("deposit", amount);
		account.addAccountTransaction(accountTransaction);*/
		accountRepository.save(account);
		TransactionLog log=new TransactionLog
				(accountNumber, null, "depoist", 
						amount,account.getCustomer().getName(), "done");
		transactionLogRepository.save(log);
		/*TransactionLog log=new TransactionLog
				(accountNumber, null, "depoist", amount, "gunika", "done");
		transactionLogRepository.save(log);
		accountTransactionRepository.save(accountTransaction);*/
	}

	@Override
	public void withdraw(Long accountNumber, double amount) {
		Account account = accountRepository.findById(accountNumber)
				.orElseThrow(AccountNotFoundException::new);
		// min bal should be 1000 in any case
		if (account.getBalance() - amount < 1000)
			throw new NotSufficientFundException();
		account.setBalance(account.getBalance() - amount);
		accountRepository.save(account);
		
		TransactionLog log=new TransactionLog(accountNumber, null, "withdraw", 
				amount,account.getCustomer().getName(), "done");
		transactionLogRepository.save(log);
		
	}

	
	@Override
	public void transfer(Long fromAccount, Long toAccount, double amount) {
		Account account = accountRepository.findById(fromAccount)
				.orElseThrow(AccountNotFoundException::new);
		if (account.getBalance() - amount < 1000)
			throw new NotSufficientFundException();
		account.setBalance(account.getBalance() - amount);
		accountRepository.save(account);
		Account account1=accountRepository.findById(toAccount)
				.orElseThrow(AccountNotFoundException::new);
		account1.setBalance(account1.getBalance() + amount);
		accountRepository.save(account1);
		TransactionLog log=new TransactionLog(fromAccount, 
				toAccount, "transfer", amount, account.getCustomer().getName(), "done");
		transactionLogRepository.save(log);
	}
	@Override
	public Account addAccount(Account account) {
		// TODO Auto-generated method stub
		return accountRepository.save(account);
	}
	@Override
	public Customer getCustomerById(Long id) {
		// TODO Auto-generated method stub
		return customerRepository.findById(id).orElseThrow(AccountNotFoundException::new);
	}
	@Override
	public Account getAccountById(Long id) {
		// TODO Auto-generated method stub
		return accountRepository.findById(id).orElseThrow(AccountNotFoundException::new);
	}
	@Override
	public void deleteCustomer(Long id) {
		// TODO Auto-generated method stub
	accountRepository.deleteById(id);
	
	}

	
}




