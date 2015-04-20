package ca.webvue.ecom.esales.entity;

import javax.persistence.Column;
import javax.persistence.Lob;

public class Log extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	public static final String LOG_CONTENT_ATTRIBUTE_NAME = Log.class.getName() + ".CONTENT";
	
	/** Operation of the log */
	private String operation;

	/** Operator who writes this log*/
	private String operator;

	/** Log content */
	private String content;

	/** Request parameters */
	private String parameter;

	/** IP */
	private String ip;

	@Column(nullable = false, updatable = false)
	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Column(updatable = false)
	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Column(length = 3000, updatable = false)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Lob
	@Column(updatable = false)
	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	@Column(nullable = false, updatable = false)
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
