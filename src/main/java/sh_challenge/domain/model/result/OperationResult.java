package sh_challenge.domain.model.result;

import java.io.Serializable;

public class OperationResult implements Serializable{
	private static final long serialVersionUID = -5913348133205747409L;

	private Boolean success;
	private String errorMessage;
	
	
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
		
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
