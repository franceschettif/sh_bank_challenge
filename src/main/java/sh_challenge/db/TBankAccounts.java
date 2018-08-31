package sh_challenge.db;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity class mapping DB table BANK_ACCOUNTS.
 */
@Entity
@Table(name = "BANK_ACCOUNTS")
@XmlRootElement
public class TBankAccounts implements Serializable{
	private static final long serialVersionUID = -1236195676675107601L;
	
	@Id
	@GeneratedValue
	@Basic(optional=false)
	@Column(name="ID")
	private Long id;
	
	@Basic(optional=false)
	@Column(name="OWNER_ID")
	private Long ownerId;
	
	@Basic(optional=false)
	@Column(name="ACCOUNT_ID")
	private String accountId;
	
	@Basic(optional=false)
	@Column(name="ACCOUNT_TYPE")
	private Integer accountType;
	
	@Basic(optional=false)
	@Column(name="ACCOUNT_BALANCE")
	private Float accountBalance;
	
	@Column(name="ACCOUNT_OVERDRAFT_LIMIT")
	private Float accountOverdraftLimit;
	
	@Column(name="ACCOUNT_INTEREST")
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

	@Override
	  public int hashCode() {
	    int hash = 0;
	    hash += (id != null ? id.hashCode() : 0);
	    return hash;
	  }

	  @Override
	  public boolean equals(Object object) {
	    if (!(object instanceof TBankAccounts)) {
	      return false;
	    }
	    TBankAccounts other = (TBankAccounts) object;
	    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
	      return false;
	    }
	    return true;
	  }


}
