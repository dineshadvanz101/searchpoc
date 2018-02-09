package com.advanz101.error.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * 
 *
 */
public class ApiErrorMessage {

	@JsonProperty(value = "user_error_message")
	private final UserErrorMessage userErrorMessage;
	@JsonProperty(value = "system_error_message")
	private final SystemErrorMessage systemErrorMessage;
	
	
	


	/**
	 * 
	 * @param systemErrorMessage
	 * @param userErrorMessage
	 */
	public ApiErrorMessage(SystemErrorMessage systemErrorMessage, UserErrorMessage userErrorMessage) {
		this(systemErrorMessage, userErrorMessage, null);
	}

	/**
	 * 
	 * @param systemErrorMessage
	 * @param userErrorMessage
	 * @param errors
	 */
	public ApiErrorMessage(SystemErrorMessage systemErrorMessage, UserErrorMessage userErrorMessage, List<String> errors) {
		this.systemErrorMessage = systemErrorMessage;
		this.userErrorMessage = userErrorMessage;
		
		
	}
	
	public ApiErrorMessage(SystemErrorMessage systemErrorMessage, UserErrorMessage userErrorMessage, List<String> errors, List<String> userMessages) {
		this.systemErrorMessage = systemErrorMessage;
		this.userErrorMessage = userErrorMessage;
			
	}

	public SystemErrorMessage getSystemErrorMessage() {
		return systemErrorMessage;
	}

	public UserErrorMessage getUserErrorMessage() {
		return userErrorMessage;
	}

	

}
