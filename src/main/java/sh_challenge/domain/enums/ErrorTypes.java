package sh_challenge.domain.enums;

/**
 * Error Types Catalog
 * */
public enum ErrorTypes {

	  //@formatter:off
	  ACCOUNT_NON_EXISTANT(1, "Account non existant in our system"),
	  BALANCE_OVERDRAFT_LIMIT_REACHED(2, "Balance overdraft limit reached for this account"),
	  NOT_APPROPRIATE_ACCOUNT (3, "Account is not enabled for such a feature"),
	  INSUFFICIENT_FUNDS (4, "Funds from Starting Account are not sufficient to transfer the required sum");
	  //@formatter:on

	  private Integer code;
	  private String description;

	  private ErrorTypes(Integer code, String description) {
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
	  public static ErrorTypes getErrorType(Integer code) {
	    for (ErrorTypes type : values()) {
	      if (type.getCode().equals(code))
	        return type;
	    }
	    return null;
	  }
}
