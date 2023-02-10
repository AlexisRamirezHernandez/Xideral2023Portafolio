package com.luv2code.springboot.cruddemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class Producto {
	private int codigo;
	private String descripcion;
	private int cantidad;
	private float precio_venta;
	private int categoria_id;
}
