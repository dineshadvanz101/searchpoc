package com.advanz101.error.exception;

import java.util.List;

import com.advanz101.error.domain.FieldMessage;
import com.advanz101.response.Metadata;

/**
 *
 * @author 
 * @param <T>
 *
 */
public class ApplicationException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private final String applicationCode;
	private final transient Metadata metadata;
	private final String userMessage ;
	private List<FieldMessage> fieldMessages;
	private String systemErrorMessage;

	/**
	 *
	 * @param applicationCode
	 * @param metadata
	 */
	public ApplicationException(String applicationCode, Metadata metadata) {
		super();
		this.applicationCode = applicationCode;
		this.metadata = metadata;
		this.userMessage = null;
	}

	public ApplicationException(String applicationCode, Metadata metadata, String userMessage, List<FieldMessage> fieldMessages) {
		super();
		this.applicationCode = applicationCode;
		this.metadata = metadata;
		this.userMessage = userMessage;
		this.fieldMessages = fieldMessages;
	}

	public String getApplicationCode() {
		return applicationCode;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public List<FieldMessage> getFieldMessages() {
		return fieldMessages;
	}

	public void setFieldMessages(List<FieldMessage> fieldMessages) {
		this.fieldMessages = fieldMessages;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public String getSystemErrorMessage() {
		return systemErrorMessage;
	}

	public void setSystemErrorMessage(String systemErrorMessage) {
		this.systemErrorMessage = systemErrorMessage;
	}

	
	
	
}
