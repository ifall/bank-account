package com.sample.bankAccount;

import java.text.SimpleDateFormat;
import java.util.List;

import com.sample.bankAccount.entity.Statement;
import com.sample.bankAccount.entity.Transaction;

public class ConsoleStatementPrinter implements StatementPrinter {

	private static final String SEP = " | "; 
	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
	private final Console console;
	
	public ConsoleStatementPrinter(Console console) {
		this.console = console;	
	}
	
	@Override
	public void printStatements(List<Statement> statements) {
		console.println("DATE" + SEP + "AMOUNT" + SEP + "BALANCE");
		for(Statement statement : statements) {
			Transaction transaction = statement.getTransaction();
			console.println(FORMAT.format(transaction.getDate()) + SEP
					+ transaction.getAmount() + SEP
					+ statement.getBalance());
		}
	}

}
