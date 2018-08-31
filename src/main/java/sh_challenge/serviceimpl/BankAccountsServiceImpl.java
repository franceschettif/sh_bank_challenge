package sh_challenge.serviceimpl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import sh_challenge.domain.model.db.BankAccounts;
import sh_challenge.domain.model.result.OperationResult;
import sh_challenge.service.BankAccountsService;

@Service
@Scope("prototype")
public class BankAccountsServiceImpl implements BankAccountsService {

	@Override
	public void updateBalanceByAccountId(String accountId, Float balance) {
		// Here should be implemented a Data Access Layer in order to retrieve data from the Database
	}

	@Override
	public BankAccounts getBankAccountByAccountId(String accountId) {
		// Here should be implemented a Data Access Layer in order to retrieve data from the Database
		return null;
	}

	
	@Override
	public OperationResult widhtrawMoneyFromAccount(String accountId, Float sumToWithdrawl) {
		// Here should be implemented the logic for money withdrawal from within the account chosen
		return null;
	}
	
	public OperationResult populateResult(Boolean success, String errorMessage) {
		OperationResult result = new OperationResult();
		result.setSuccess(success);
		if (errorMessage!=null)
			result.setErrorMessage(errorMessage);

		return result;
	}

}
