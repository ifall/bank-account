package com.sample.bankAccount;

import java.util.List;

import com.sample.bankAccount.entity.Statement;

public interface StatementPrinter {

	public void printStatements(List<Statement> statements);

}
