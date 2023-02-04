package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="producto")
public class Producto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private int codigo;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="cantidad")
	private int cantidad;
	
	@Column(name="precio_venta")
	private float precio_venta;
	
	@Column(name="categoria_id")
	private int categoria_id;

	public Producto(String descripcion, int cantidad, float precio_venta, int categoria_id) {
		super();
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.precio_venta = precio_venta;
		this.categoria_id = categoria_id;
	}
	
	
	
	
}
