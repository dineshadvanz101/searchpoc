/**
 *
 */
package com.advanz101.error.exception;

import java.util.List;

import com.advanz101.error.domain.FieldMessage;
import com.advanz101.response.Metadata;

/**
 * @author 
 *
 */
public class InternalServerException extends ApplicationException {

	/**
	 *
	 */
	private static final long serialVersionUID = 5018979763055703549L;

	/**
	 *
	 * @param applicationCode
	 * @param metadata
	 */
	public InternalServerException(String applicationCode, Metadata metadata) {
		super(applicationCode,metadata);
	}
	
	public InternalServerException(String applicationCode, Metadata metadata, String userMessages, List<FieldMessage> fieldMessages) {
		super(applicationCode,metadata,userMessages,fieldMessages);
	}

	public InternalServerException(String applicationCode, Metadata metadata, String userMessages) {
		super(applicationCode,metadata,userMessages,null);
	}

}
