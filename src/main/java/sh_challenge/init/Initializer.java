package sh_challenge.init;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import sh_challenge.domain.model.result.OperationResult;
import sh_challenge.service.CheckingAccountService;
import sh_challenge.service.SavingsAccountService;

@Service
public class Initializer {

	@Autowired
	private CheckingAccountService checkingAccountService;
	@Autowired
	private SavingsAccountService savingsAccountService;
	
	public OperationResult start(String[] args) {
		
		OperationResult result = new OperationResult();
		
		if (args == null || args.length < 4) {
		      result.setErrorMessage("Main parameters error");
		      result.setSuccess(false);
		      return result;
		    }
		
		Float sumToBeTransfered = checkIfArgsIsANumber(args[3]);
		
		switch (args[1].toUpperCase()) {
		case "CHECKING":
			result = checkingAccountService.moneyTransfer(args[0], args[2],
					sumToBeTransfered);
			break;
		case "SAVINGS":
			result = savingsAccountService.calculateAndUpdateInterestByAccountId(args[0]);
			break;
		default:
			result.setErrorMessage("Error in String[] args regarding initialAccountType");
			result.setSuccess(false);
			break;
		}
		
		System.out.println("Operation success: " + result.getSuccess());
		if(!StringUtils.isEmpty(result.getErrorMessage()))
			System.out.println("Operation ERROR: " + result.getErrorMessage());

		return result;
	}

	public Float checkIfArgsIsANumber(String arg) {
		try {
			return Float.parseFloat(arg);
		}catch (Exception e){
			throw new NumberFormatException();
		}
	}
	
	
	public void setCheckingAccountService(CheckingAccountService checkingAccountService) {
		this.checkingAccountService = checkingAccountService;
	}

	public void setSavingsAccountService(SavingsAccountService savingsAccountService) {
		this.savingsAccountService = savingsAccountService;
	}
	
}
