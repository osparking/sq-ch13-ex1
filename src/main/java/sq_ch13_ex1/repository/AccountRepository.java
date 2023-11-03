package sq_ch13_ex1.repository;

import java.math.BigDecimal;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import sq_ch13_ex1.model.Account;

@Repository
@AllArgsConstructor
public class AccountRepository {
	private final JdbcTemplate jdbcTemplate;
	
	public Account findAccountById(long id) {
		String sql = "select * from account where id=?";
		return jdbcTemplate.queryForObject(sql, new AccountRowMapper(), id);
	}
	
	public void changeAmount(long id, BigDecimal amount) {
		String sql = "update account set amount=? where id=?";
		jdbcTemplate.update(sql, id, amount);
	}
}
