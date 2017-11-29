package com.sample.bankAccount;

public class BankAccount {
	
	private final TransactionHolder transactionHolder;
	private final StatementPrinter statementPrinter;
	
	public BankAccount(TransactionHolder transactionHolder, StatementPrinter statementPrinter) {
		this.transactionHolder = transactionHolder;
		this.statementPrinter = statementPrinter;
	}

	public void deposit(double amount) {
		transactionHolder.record(amount);
	}
	
	public void withdraw(double amount) {
		transactionHolder.record(-amount);
	}
	
	public void print() {
		statementPrinter.printStatements(transactionHolder.generateStatements());
	}
}
