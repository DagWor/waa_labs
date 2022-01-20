package bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private RestOperations restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) {
		String serverUrl = "http://localhost:8080/accounts";
		// add an account
		restTemplate.postForLocation(serverUrl, new AccountDTO("12345","John Doe", 0.0));
		// add an account
		restTemplate.postForLocation(serverUrl, new AccountDTO("98752","Bob Jones", 0.0));
        // get account
		AccountDTO accountDTO= restTemplate.getForObject(serverUrl +"/98752", AccountDTO.class );
		System.out.println("--------------------Account information from Bob Jones----------------------");
		System.out.println(accountDTO);
		//delete an account
		restTemplate.delete(serverUrl +"/12345");
		// deposit money to account
		accountDTO.setAccountHolder("James Bond");
		restTemplate.postForLocation(serverUrl +"/deposit?accountNumber="+accountDTO.getAccountNumber()+"&amount=1000.00", accountDTO);
		AccountDTO accountDTO1= restTemplate.getForObject(serverUrl +"/98752", AccountDTO.class );
		System.out.println("Account after depositing $1000.00");
		System.out.println(accountDTO1);

		// withdraw money to account
		accountDTO.setAccountHolder("James Bond");
		restTemplate.postForLocation(serverUrl +"/withdraw?accountNumber="+accountDTO.getAccountNumber()+"&amount=500.00", accountDTO);
		AccountDTO accountDTO2= restTemplate.getForObject(serverUrl +"/98752", AccountDTO.class );
		System.out.println("Account after withdrawing $500.00");
		System.out.println(accountDTO2);

	}

	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
