package com.sample.bankAccount;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import com.sample.bankAccount.entity.Statement;
import com.sample.bankAccount.entity.Transaction;

public class ConsoleStatementPrinterTest {

	private StatementPrinter statementPrinter;
	private Console console;
	private InOrder inOrder;
	
	@Before
	public void setup() {
		console = mock(Console.class);
		inOrder = inOrder(console);
		statementPrinter = new ConsoleStatementPrinter(console);
	}
	
	@Test
	public void print_statement() {
		statementPrinter.printStatements(Arrays.asList(
				new Statement(new Transaction(200, Utils.getDate(18, 04, 2017)), 300)));
		inOrder.verify(console).println("DATE | AMOUNT | BALANCE");
		inOrder.verify(console).println("18/04/2017 | 200.0 | 300.0");
	}
}
