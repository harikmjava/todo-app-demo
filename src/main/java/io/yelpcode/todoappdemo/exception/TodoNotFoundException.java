package io.yelpcode.todoappdemo.exception;

import java.math.BigInteger;

@SuppressWarnings("serial")
public class TodoNotFoundException extends RuntimeException {

	public TodoNotFoundException(final BigInteger id) {
		super(String.format("Todo with id '%s' not found", id));
	}
}