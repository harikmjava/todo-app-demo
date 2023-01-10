package io.yelpcode.todoappdemo.model;

public enum ErrorCodes {

	TODO_NOT_FOUND(1001);

	private int code;

	ErrorCodes(int code) {
		this.code = code;
	}

	public int code() {
		return this.code;
	}

}