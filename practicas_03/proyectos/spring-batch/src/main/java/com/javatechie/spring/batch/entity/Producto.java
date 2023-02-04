package com.javatechie.spring.batch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTS_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
	@Id
	@Column(name = "codigo")
	private int codigo;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "cantidad")
	private int cantidad;
	@Column(name = "proveedor")
	private String proveedor;
	@Column(name = "categoria")
	private String categoria;
	@Column(name = "precio_venta")
	private float precio_venta;
	
}
