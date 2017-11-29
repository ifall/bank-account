package com.sample.bankAccount;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sample.bankAccount.entity.Statement;
import com.sample.bankAccount.entity.Transaction;

public class ListTransactionHolderTest {

	private TransactionHolder transactionHolder;
	private SysDate sysdate;
	
	@Before
	public void setup() {
		sysdate = mock(SysDate.class);
		transactionHolder = new ListTransactionHolder(sysdate);
	}
	
	@Test
	public void statement_with_three_transactions() {
		when(sysdate.now()).thenReturn(Utils.getDate(12, 8, 2017))
		.thenReturn(Utils.getDate(15, 8, 2017))
		.thenReturn(Utils.getDate(18, 8, 2017));
		transactionHolder.record(400);
		transactionHolder.record(-300);
		transactionHolder.record(100);
		List<Statement> statements = transactionHolder.generateStatements();
		
		assertThat(statements, equalTo(Arrays.asList(
				new Statement(new Transaction(100, Utils.getDate(18, 8, 2017)), 200),
				new Statement(new Transaction(-300, Utils.getDate(15, 8, 2017)), 100),
				new Statement(new Transaction(400, Utils.getDate(12, 8, 2017)), 400))));
	}
}
