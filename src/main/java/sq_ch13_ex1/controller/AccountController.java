package sq_ch13_ex1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import sq_ch13_ex1.TransferRequest;
import sq_ch13_ex1.model.Account;
import sq_ch13_ex1.service.AccountService;

@RestController
@AllArgsConstructor
public class AccountController {
	
	private final AccountService service;
	
	@PostMapping("/transfer")
	public void transferMoney(
			@RequestBody TransferRequest request
			) {
		service.transferMoney(
				request.getSenderAccountId(), 
				request.getReceiverAccountId(),
				request.getAmount());
	}
	
	@GetMapping("/accounts")
	public List<Account> getAllAccounts() {
		return service.getAllAccounts();
	}

}
