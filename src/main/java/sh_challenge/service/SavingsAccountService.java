package sh_challenge.service;

import sh_challenge.domain.model.result.OperationResult;

/**
 * Interface containing all methods needed to interact with Savings Account
 */
public interface SavingsAccountService extends BankAccountsService {

	/**
	 * Method to calculate Interest due on a specific bank account
	 * 
	 * @param accountId
	 *            account on which calculate the interest due
	 * @return <OperationResult> obj containing both operation outcome and eventual
	 *         error message
	 */
	
	public OperationResult calculateAndUpdateInterestByAccountId(String accountId);
}
