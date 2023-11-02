package sq_ch13_ex1.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Account {
	private long id;
	private String name;
	private BigDecimal amount;
	
}
