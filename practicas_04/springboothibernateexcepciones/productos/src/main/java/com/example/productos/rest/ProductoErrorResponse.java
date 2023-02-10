package com.example.productos.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoErrorResponse {
	private int status;
	private String message;
	private long timeStamp;
	
}
