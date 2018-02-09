package com.advanz101.error.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Arpit A
 */
public class ValidationError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<FieldMessage> fieldErrors = new ArrayList<>();

	public ValidationError() {

	}

	public void addFieldError(String field, String message) {
		FieldMessage error = new FieldMessage(field, message);
		fieldErrors.add(error);
	}

	public List<FieldMessage> getFieldErrors() {
		return fieldErrors;
	}
}
