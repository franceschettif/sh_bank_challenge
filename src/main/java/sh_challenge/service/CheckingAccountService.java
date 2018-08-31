package sh_challenge.service;

import sh_challenge.domain.model.result.OperationResult;

/**
 * Interface containing all methods needed to interact with Checking Account
 */
public interface CheckingAccountService extends BankAccountsService {

	/**
	 * Method to transfer a sum of money between accounts
	 * 
	 * @param fromAccountId
	 *            bank account from which withdraw money
	 * @param toAccountId
	 *            bank account on which deposit money
	 * @param sumToTransfer
	 *            money sum to transfer from one account to the other
	 * @return OperationResult obj containing both operation outcome and eventual
	 *         error message
	 */
	
	public OperationResult moneyTransfer(String fromAccountId, String toAccountId, Float sumToTransfer);
}
