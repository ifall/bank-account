package com.sample.bankAccount;

import java.util.List;

import com.sample.bankAccount.entity.Statement;

public interface TransactionHolder {

	public void record(double amount);
	
	public List<Statement> generateStatements();
}
