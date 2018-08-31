import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.util.StringUtils;

import sh_challenge.domain.enums.ErrorTypes;
import sh_challenge.domain.model.db.BankAccounts;
import sh_challenge.domain.model.result.OperationResult;
import sh_challenge.init.Initializer;
import sh_challenge.service.BankAccountsService;
import sh_challenge.service.CheckingAccountService;
import sh_challenge.service.SavingsAccountService;

public class InitializerTest {

	@Mock
	private CheckingAccountService checkingAccountService;
	@Mock
	private SavingsAccountService savingsAccountService;
	@Mock
	private BankAccountsService bankAccountsService;

	private Initializer initializer;

	public void init() {
		initializer = new Initializer();
		initializer.setCheckingAccountService(checkingAccountService);
		initializer.setSavingsAccountService(savingsAccountService);

		try {
			// Mockito.when(checkingAccountService.getBankAccountByAccountId(Mockito.anyString())).thenReturn(buildBankAccount());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Before
	public void beforeBase() {
		MockitoAnnotations.initMocks(this);

		init();
	}

	@Test
	public void verifyInitialParamsAreKo() {
		OperationResult result = new OperationResult();
		result.setSuccess(false);
		
		initializer.start(null);

		if (result.getSuccess())
			Assert.fail();

		Mockito.verifyZeroInteractions(savingsAccountService);
		Mockito.verifyZeroInteractions(checkingAccountService);
	}

	@Test
	public void executeMoneyTransferSuccessTest() {
		OperationResult result = new OperationResult();
		result.setSuccess(true);
		Mockito.when(checkingAccountService.moneyTransfer(Mockito.anyString(), Mockito.anyString(), Mockito.anyFloat()))
				.thenReturn(result);
		initializer.start(buildStringArgs("test", "CHECKING", "test", "1.5"));

		if (!result.getSuccess())
			org.junit.Assert.fail();

		Mockito.verifyZeroInteractions(savingsAccountService);
		
	}

	@Test
	public void executeMoneyTransferFailTest() {
		OperationResult result = new OperationResult();
		result.setSuccess(false);
		Mockito.when(checkingAccountService.moneyTransfer(Mockito.anyString(), Mockito.anyString(), Mockito.anyFloat()))
				.thenReturn(result);
		initializer.start(buildStringArgs("test", "CHECKING", "test", "1.5"));

		if (result.getSuccess())
			org.junit.Assert.fail();

		Mockito.verifyZeroInteractions(savingsAccountService);
	}

	@Test
	public void executeInterestSuccessTest() {
		OperationResult result = new OperationResult();
		result.setSuccess(true);

		Mockito.when(savingsAccountService.calculateAndUpdateInterestByAccountId(Mockito.anyString()))
				.thenReturn(result);
		initializer.start(buildStringArgs("test", "SAVINGS", "test", "1.5"));

		if (!result.getSuccess())
			org.junit.Assert.fail();

		Mockito.verifyZeroInteractions(checkingAccountService);
	}

	@Test
	public void executeInterestFailTest() {
		OperationResult result = new OperationResult();
		result.setSuccess(false);

		Mockito.when(savingsAccountService.calculateAndUpdateInterestByAccountId(Mockito.anyString()))
				.thenReturn(result);
		initializer.start(buildStringArgs("test", "SAVINGS", "test", "1.5"));

		if (result.getSuccess())
			org.junit.Assert.fail();

		Mockito.verifyZeroInteractions(checkingAccountService);
	}

	private String[] buildStringArgs(String arg1, String arg2, String arg3, String arg4) {
		String[] args = new String[4];
		args[0] = arg1;
		args[1] = arg2;
		args[2] = arg3;
		args[3] = arg4;
		return args;
	}

}
