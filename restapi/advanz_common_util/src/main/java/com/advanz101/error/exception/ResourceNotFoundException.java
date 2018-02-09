package com.advanz101.error.exception;

import java.util.List;

import com.advanz101.error.domain.FieldMessage;
import com.advanz101.response.Metadata;

/**
 *
 * @author SharmD01
 *
 */
public class ResourceNotFoundException extends ApplicationException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *
	 * @param applicationCode
	 * @param metadata
	 */
	public ResourceNotFoundException(String applicationCode, Metadata metadata) {
		super(applicationCode,metadata);
	}
	
	public ResourceNotFoundException(String applicationCode, Metadata metadata, String userMessages, List<FieldMessage> fieldMessages) {
		super(applicationCode,metadata,userMessages,fieldMessages);
	}

	public ResourceNotFoundException(String applicationCode, Metadata metadata, String userMessages) {
		super(applicationCode,metadata,userMessages,null);
	}

}
