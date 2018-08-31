package sh_challenge.domain.model.db;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class to render db retrieved obj
 * */
@XmlRootElement
public class BankAccounts implements Serializable{
	private static final long serialVersionUID = 7016714771010692230L;
	
	private Long id;
	private Long ownerId;
	private String accountId;
	private Integer accountType;
	private Float accountBalance; 
	private Float accountOverdraftLimit;
	private Float accountInterest;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public Integer getAccountType() {
		return accountType;
	}
	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}
	public Float getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Float accountBalance) {
		this.accountBalance = accountBalance;
	}
	public Float getAccountOverdraftLimit() {
		return accountOverdraftLimit;
	}
	public void setAccountOverdraftLimit(Float accountOverdraftLimit) {
		this.accountOverdraftLimit = accountOverdraftLimit;
	}

	public Float getAccountInterest() {
		return accountInterest;
	}
	public void setAccountInterest(Float accountInterest) {
		this.accountInterest = accountInterest;
	}
}
