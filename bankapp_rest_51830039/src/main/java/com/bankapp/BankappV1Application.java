package com.bankapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.entities.User;
import com.bankapp.model.repo.AccountRepository;
import com.bankapp.model.repo.AccountTransactionRepository;
import com.bankapp.model.repo.CustomerRepository;
import com.bankapp.model.repo.TransactionLogRepository;
import com.bankapp.model.repo.UserRepository;
import com.bankapp.model.service.AccountService;
@EnableTransactionManagement
@EntityScan(basePackages="com.bankapp.model.entities")
@SpringBootApplication(scanBasePackages="com.bankapp")
public class BankappV1Application implements CommandLineRunner {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountTransactionRepository accountTransactionRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TransactionLogRepository transactionLogRepository;

	public static void main(String[] args) {
		SpringApplication.run(BankappV1Application.class, args);

	}
	
	@Autowired
	private AccountService accountService;
	

	@Override
	public void run(String... args) throws Exception {
		
		/*accountService.deposit(2L, 100);*/
		
		
		/*
		Account account=accountRepository.findById(1L).orElseThrow(RuntimeException::new);
		accountRepository.delete(account);*/
		
		/*Customer customer=new Customer("amir", "a@gmail.com", "5454545545", "delhi", "delhi", "india");
		Customer customer2=new Customer("ravi", "ravi@gmail.com", "54598545545", "noida", "UP", "india");
		Customer customer3=new Customer("karthick", "k@gmail.com",
				"5974545545", "banglore", "Karnataka", "india");
		
		Account account=new Account(2000.0, customer, false);
		Account account2=new Account(1000.0, customer2, false);
		Account account3=new Account(2500.0, customer3, false);
		
		customer.setAccount(account);
		customer2.setAccount(account2);
		customer3.setAccount(account3);
		
		accountRepository.save(account);
		accountRepository.save(account2);
		accountRepository.save(account3);*/
		
		

		/*User user1=new User("sai", "sai", "sai@.com", "5454989855", "delhi", 
				new String[]{"ROLE_ADMIN","ROLE_MGR","ROLE_CLERK"}, true);
		
		User user2=new User("kalai", "kalai", "kalai@.com", "5454987655", "bangalore", 
				new String[]{"ROLE_MGR","ROLE_CLERK"}, true);
		
		User user3=new User("saran", "saran", "saran@.com", "5454788955", "chennai", 
				new String[]{"ROLE_CLERK"}, true);

		User user4=new User("vel", "vel", "vel@.com", "54545898455", "trichy", 
				new String[]{"ROLE_CLERK"}, true);
		
		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		userRepository.save(user4);
		*/
		
	}

}
















