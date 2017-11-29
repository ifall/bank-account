package com.sample.bankAccount;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {

	private BankAccount bankAccount;
	private TransactionHolder transactionHolder;
	private StatementPrinter statementPrinter;
	
	@Before
	public void setup() {
		transactionHolder = mock(TransactionHolder.class);
		statementPrinter = mock(StatementPrinter.class);
		bankAccount = new BankAccount(transactionHolder, statementPrinter);
	}
	
	@Test
	public void save_money() {
		bankAccount.deposit(100);
		verify(transactionHolder).record(100);
	}
	
	@Test
	public void retrieve_money() {
		bankAccount.withdraw(200);
		verify(transactionHolder).record(-200);
	}
	
	@Test
	public void print_statement() {
		bankAccount.print();
		verify(transactionHolder).generateStatements();
		verify(statementPrinter).printStatements(any());
	}
}
