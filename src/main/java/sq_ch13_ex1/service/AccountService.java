package sq_ch13_ex1.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import sq_ch13_ex1.model.Account;
import sq_ch13_ex1.repository.AccountRepository;

@Service
@AllArgsConstructor
public class AccountService {
	private final AccountRepository repository;
	
	@Transactional
	public void transferMoney(long idSrc, long idDst, BigDecimal amount) {
		// 두 계정 정보를 읽어온다.
		var acntSrc = repository.findAccountById(idSrc);
		var acntDst = repository.findAccountById(idDst);
		
		// 새 금액을 계산한다.
		var amtSrc = acntSrc.getAmount().subtract(amount);
		var amtDst = acntDst.getAmount().add(amount);
		
		// 두 계정의 금액을 변경한다.
		repository.changeAmount(acntSrc.getId(), amtSrc);
		repository.changeAmount(acntDst.getId(), amtDst);
	}
	
	public List<Account> getAllAccounts() {
		return repository.allAccounts();
	}

}
