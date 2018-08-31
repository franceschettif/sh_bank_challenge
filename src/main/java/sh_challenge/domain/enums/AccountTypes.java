package sh_challenge.domain.enums;

/**
 * Account Types Catalog
 * */
public enum AccountTypes {

	  //@formatter:off
	  //STARTER DAEMONS
	  SAVINGS_ACCOUNT(1, "Savings"),
	  //CENSUS DAEMONS
	  CHECKING_ACCOUNT(2, "Checking"); 
	  //@formatter:on

	  private Integer code;
	  private String description;

	  private AccountTypes(Integer code, String description) {
	    this.code = code;
	    this.description = description;
	  }

	  public Integer getCode() {
	    return code;
	  }

	  public String getDescription() {
	    return description;
	  }

	  /**
	   * Get the service type by string code
	   * 
	   * @param code
	   *          the service type code
	   * @return the service type with the code requested. If no service type found, return the default type (SCHED)
	   */
	  public static AccountTypes getAccountType(Integer code) {
	    for (AccountTypes type : values()) {
	      if (type.getCode().equals(code))
	        return type;
	    }
	    return null;
	  }
}
