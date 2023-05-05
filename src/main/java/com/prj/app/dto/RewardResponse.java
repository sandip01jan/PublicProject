package com.prj.app.dto;

import java.util.List;

public class RewardResponse {
	private int statusCode;
	private String statusMessage;
	private List<Response> response;

	@Override
	public String toString() {
		return String.format("RewardResponse [statusCode=%s, statusMessage=%s, response=%s]", statusCode, statusMessage,
				response);
	}

	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public List<Response> getResponse() {
		return response;
	}
	public void setResponse(List<Response> response) {
		this.response = response;
	}
}