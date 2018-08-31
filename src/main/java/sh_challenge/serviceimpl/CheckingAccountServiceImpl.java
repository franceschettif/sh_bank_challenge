package sh_challenge.serviceimpl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import sh_challenge.domain.enums.AccountTypes;
import sh_challenge.domain.enums.ErrorTypes;
import sh_challenge.domain.model.db.BankAccounts;
import sh_challenge.domain.model.result.OperationResult;
import sh_challenge.service.CheckingAccountService;

@Service
@Scope("prototype")
public class CheckingAccountServiceImpl extends BankAccountsServiceImpl implements CheckingAccountService {

	@Override
	public OperationResult moneyTransfer(String fromAccountId, String toAccountId, Float sumToTransfer) {
		try {
			BankAccounts fromAccount = getBankAccountByAccountId(fromAccountId);
			BankAccounts toAccount = getBankAccountByAccountId(toAccountId);

			if (fromAccount != null && toAccount != null) {

				if ((AccountTypes.CHECKING_ACCOUNT.getCode() != fromAccount.getAccountType())
						|| (AccountTypes.CHECKING_ACCOUNT.getCode() != toAccount.getAccountType())) {
					return populateResult(false, ErrorTypes.NOT_APPROPRIATE_ACCOUNT.getDescription());
				}
 
				Float fromAccountBalance = fromAccount.getAccountBalance();
				Float residualAccountBalance = fromAccountBalance - sumToTransfer;

				// overdraft is considered as a negative floating-point number
				if (Float.compare(residualAccountBalance, fromAccount.getAccountOverdraftLimit()) > 0) {
					updateBalanceByAccountId(fromAccountId, (fromAccountBalance - sumToTransfer));
					updateBalanceByAccountId(fromAccountId, (toAccount.getAccountBalance() + sumToTransfer));
					return populateResult(true, null);
				} else {
					return populateResult(false, ErrorTypes.INSUFFICIENT_FUNDS.getDescription());
				}
			} else {
				return populateResult(false, ErrorTypes.ACCOUNT_NON_EXISTANT.getDescription());
			}
		} catch (Exception e) {
			return populateResult(false, e.getMessage());
		}
	}

}
