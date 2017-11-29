package com.sample.bankAccount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sample.bankAccount.entity.Statement;
import com.sample.bankAccount.entity.Transaction;

public class ListTransactionHolder implements TransactionHolder {

	private final List<Transaction> transactions;
	private final SysDate sysdate;
	
	public ListTransactionHolder(SysDate sysdate) {
		this.transactions = new ArrayList<>();
		this.sysdate = sysdate;
	}
	
	@Override
	public void record(double amount) {
		transactions.add(new Transaction(amount, sysdate.now()));
	}

	@Override
	public List<Statement> generateStatements() {
		List<Statement> statements = new ArrayList<>();
		double balance = 0;
		for(Transaction transaction : transactions) {
			balance+=transaction.getAmount();
			statements.add(new Statement(transaction, balance));
		}
		Collections.sort(statements, (s1, s2)->s2.getTransaction().getDate().compareTo(s1.getTransaction().getDate()));
		return statements;
	}

}
