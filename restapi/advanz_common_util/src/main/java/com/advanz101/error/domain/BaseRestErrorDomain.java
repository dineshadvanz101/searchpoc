/**
 *
 */
package com.advanz101.error.domain;

import java.util.List;

import com.advanz101.error.exception.RestErrorsEnum;
import com.advanz101.response.Metadata;

/**
 * @author 
 *
 */
public class BaseRestErrorDomain {

	private final String httpStatusCode;
	private final String applicationCode;
	private final String userMessage;
	private final List<FieldMessage> fieldMessages;
	private final String systemMessage;
	private final Metadata metadata;
	/**
	 *
	 * @param httpStatusCode
	 * @param applicationCode
	 * @param userMessage
	 * @param fieldMessages
	 * @param systemMessage
	 * @param metadata
	 */
	public BaseRestErrorDomain(String httpStatusCode, String applicationCode, String userMessage,List<FieldMessage> fieldMessages, String systemMessage,
			Metadata metadata) {
		super();
		if(metadata == null) {
			metadata = new Metadata();
			metadata.setHttpStatus(Integer.valueOf(RestErrorsEnum.INTERNAL_SERVER_ERROR.getHttpStatusCode()));
			metadata.setResultCount(0);
			metadata.setVersion("1.0");
		}

		this.httpStatusCode = httpStatusCode;
		this.applicationCode = applicationCode;
		this.userMessage = userMessage;
		this.fieldMessages = fieldMessages;
		this.systemMessage = systemMessage;
		this.metadata = metadata;
	}

	/**
	 *
	 * @param httpStatusCode
	 * @param userMessage
	 * @param metadata
	 */
	public BaseRestErrorDomain(String httpStatusCode, String userMessage,Metadata metadata) {
		this(httpStatusCode,null,userMessage,null,null,metadata);
	}

	/**
	 *
	 * @param applicationCode
	 * @param systemMessage
	 */
	public BaseRestErrorDomain(String applicationCode, String systemMessage) {
		this(null,applicationCode,null,null,systemMessage,null);
	}


	/*public BaseRestErrorDomain(String httpStatusCode, String applicationCode, String userMessage, String systemMessage,
			List errors, Metadata metadata) {
		super();
		if(metadata == null) {
			metadata = new Metadata();
			metadata.setHttpStatus(Integer.valueOf(RestErrorsEnum.INTERNAL_SERVER_ERROR.getHttpStatusCode()));
		}

		this.httpStatusCode = httpStatusCode;
		this.applicationCode = applicationCode;
		this.userMessage = userMessage;
		this.systemMessage = systemMessage;

		this.errors = errors;
		this.metadata = metadata;
	}
*/
	/**
	 * @return the httpStatusCode
	 */
	public String getHttpStatusCode() {
		return httpStatusCode;
	}

	/**
	 * @return the applicationCode
	 */
	public String getApplicationCode() {
		return applicationCode;
	}

	/**
	 * @return the userMessage
	 */
	public String getUserMessage() {
		return userMessage;
	}

	/**
	 * @return the systemMessage
	 */
	public String getSystemMessage() {
		return systemMessage;
	}


	public Metadata getMetadata() {
		return metadata;
	}

	public List<FieldMessage> getFieldMessages() {
		return fieldMessages;
	}
	
	

}
