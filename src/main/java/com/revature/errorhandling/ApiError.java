package com.revature.errorhandling;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ApiError {
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	
	private int status;
	
	private String error;
	
	private String message;
	private String debugMessage;
	
	List<ApiSubError> subErrors = new ArrayList<>();
	
	
	
	public void addSubError(ApiSubError error) {
		this.subErrors.add(error);
	}



	public ApiError() {
		super();
		this.timestamp = LocalDateTime.now();
	}



	public ApiError(HttpStatus status) {
		super();
		this.status = status.value();
		this.error = status.getReasonPhrase();
	}
	
	public ApiError(HttpStatus status, Throwable ex) {
		this(status);
		this.message = "NO message available";
		this.debugMessage = ex.getLocalizedMessage();
	}
	
	public ApiError(HttpStatus status, String message, Throwable ex) {
		this(status ,ex);
		this.message = message;
	}
	
	
	
}
