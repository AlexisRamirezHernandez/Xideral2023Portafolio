package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Producto;

public interface ProductoDAO {
	public List<Producto> getProductos();

	public void guardarProductos(Producto theCustomer);

	public Producto getProducto(int theId);

	public void borrarProducto(int theId);
}
