package io.yelpcode.todoappdemo.exception;

import io.yelpcode.todoappdemo.model.ErrorCodes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler
	public ResponseEntity<?> todoNotFound(TodoNotFoundException ex) {
		return ResponseEntity.badRequest()
				.body(new ResponseStatusError(ErrorCodes.TODO_NOT_FOUND.code(), ex.getMessage()));
	}

}

@Data
@AllArgsConstructor
class ResponseStatusError {

	private int status;
	private String message;
}