package sh_challenge.serviceimpl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import sh_challenge.domain.enums.AccountTypes;
import sh_challenge.domain.enums.ErrorTypes;
import sh_challenge.domain.model.db.BankAccounts;
import sh_challenge.domain.model.result.OperationResult;
import sh_challenge.service.SavingsAccountService;

@Service
@Scope("prototype")
public class SavingsAccountServiceImpl extends BankAccountsServiceImpl implements SavingsAccountService {

	@Override
	public OperationResult calculateAndUpdateInterestByAccountId(String accountId) {
		try {
			BankAccounts account = getBankAccountByAccountId(accountId);
			
			if(account!=null) {
				if (AccountTypes.SAVINGS_ACCOUNT.getCode() != account.getAccountType()) {
					return populateResult(false, ErrorTypes.NOT_APPROPRIATE_ACCOUNT.getDescription());
				}
				// interest are considered a one-time-only-operation
				Float accountBalance = account.getAccountBalance();
				Float accountInterestRate = account.getAccountInterest();
				Float totalDue =(accountBalance*accountInterestRate);
				
				updateBalanceByAccountId(accountId, (accountBalance+totalDue));
				return populateResult(true, null);
				
			}else {
				return populateResult(false, ErrorTypes.ACCOUNT_NON_EXISTANT.getDescription());
			}
		}catch(Exception e) {
			return populateResult(false, e.getMessage());
		}
		
	}

}
