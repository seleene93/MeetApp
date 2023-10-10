package com.meetapp.springboot.backend.apirest.auth.models;

public class ErrorDto {
	
	private boolean hasErrors;
	
	private String error;
	
	private Long errorCode;

	public boolean isHasErrors() {
		return hasErrors;
	}

	public void setHasErrors(boolean hasErrors) {
		this.hasErrors = hasErrors;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Long getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Long errorCode) {
		this.errorCode = errorCode;
	}
}
