package sq_ch13_ex1;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class TransferRequest {
	private long senderAccountId;
	private long receiverAccountId;
	private BigDecimal amount;
}
