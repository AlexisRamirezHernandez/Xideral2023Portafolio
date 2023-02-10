package com.example.productos.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductoRestExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ProductoErrorResponse> handleException(ProductoNotFoundException exc) {

		ProductoErrorResponse error = new ProductoErrorResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage(),
				System.currentTimeMillis());

		// return ResponseEntity

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ProductoErrorResponse> handleException(Exception exc) {

		// create CustomerErrorResponse

		ProductoErrorResponse error = new ProductoErrorResponse(HttpStatus.BAD_REQUEST.value(), exc.getMessage(),
				System.currentTimeMillis());

		// return ResponseEntity

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
