package com.luv2code.web.jdbc;


public class Producto {
	private int id;
	private String descripcion;
	private int cantidad;
	private double precio_venta;
	private int departamento_id;
	
	public Producto(int id, String descripcion, int cantidad, double precio_venta, int departamento_id) {
		this.id = id;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.precio_venta = precio_venta;
		this.departamento_id = departamento_id;
	}
	public Producto(String descripcion, int cantidad, double precio_venta, int departamento_id) {
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.precio_venta = precio_venta;
		this.departamento_id = departamento_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio_venta() {
		return precio_venta;
	}
	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}
	public int getDepartamento_id() {
		return departamento_id;
	}
	public void setDepartamento_id(int departamento_id) {
		this.departamento_id = departamento_id;
	}
	
}
