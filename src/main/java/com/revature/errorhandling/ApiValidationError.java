package com.revature.errorhandling;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ApiValidationError extends ApiSubError{
	
	private String object;
	private String field;
	private Object rejectedValue;
	private String message;
	
	public ApiValidationError(String object, String message) {
		this.object = object;
		this.message = message;
	}

	public ApiValidationError(String object, String field, String message) {
		this(object, message);
		this.message = message;
	}

	public ApiValidationError(String object, String field, Object rejectedValue, String message) {
		this(object, message, field);
		this.rejectedValue = rejectedValue;
	}
	
	
	
	
	
	
}
