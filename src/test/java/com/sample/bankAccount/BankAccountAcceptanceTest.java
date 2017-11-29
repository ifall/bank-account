package com.sample.bankAccount;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

public class BankAccountAcceptanceTest {

	private BankAccount bankAccount;
	private Console console;
	private SysDate sysDate;
	private InOrder inOrder;
	
	@Before
	public void setup() {
		console = mock(Console.class);
		sysDate = mock(SysDate.class);
		inOrder = inOrder(console);
		bankAccount = new BankAccount(new ListTransactionHolder(sysDate), new ConsoleStatementPrinter(console));
	}
	
	@Test
	public void run_acceptance_test() {
		when(sysDate.now())
		.thenReturn(Utils.getDate(12, 03, 2017))
		.thenReturn(Utils.getDate(15, 03, 2017))
		.thenReturn(Utils.getDate(18, 03, 2017));
		
		bankAccount.deposit(200);
		bankAccount.withdraw(100);
		bankAccount.deposit(150);
		
		bankAccount.print();
		
		inOrder.verify(console).println("DATE | AMOUNT | BALANCE");
        inOrder.verify(console).println("18/03/2017 | 150.0 | 250.0");
        inOrder.verify(console).println("15/03/2017 | -100.0 | 100.0");
        inOrder.verify(console).println("12/03/2017 | 200.0 | 200.0");
	}
}
