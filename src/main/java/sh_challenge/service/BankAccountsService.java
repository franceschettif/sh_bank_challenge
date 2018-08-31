package sh_challenge.service;

import sh_challenge.domain.model.db.BankAccounts;
import sh_challenge.domain.model.result.OperationResult;

/**
 * Interface containing all methods needed to interact with BankAccount class 
 * */
public interface BankAccountsService {

	/**
	 * Method to update an account balance by the account id
	 * @param accountId
	 * account to update
	 * */
	public void updateBalanceByAccountId(String accountId, Float balance);

	/**
	 * Method to retrieve a banck account obj by it's account id
	 * @param accountId
	 * account to retrieve
	 * @return <BankAccounts> obj
	 * */
	public BankAccounts getBankAccountByAccountId(String accountId);
	
	
	/**
	 * Method to withdraw money from an account
	 * @param accountId
	 * account used for withdrawal
	 * @param sumToWithdrawal
	 * sum needed to withdrawal
	 * @return <OperationResult> obj containing both operation outcome and eventual
	 *         error message
	 * */
	public OperationResult widhtrawMoneyFromAccount(String accountId, Float sumToWithdrawl);
	
}
