package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Producto;

public interface ProductoService {
	public List<Producto> getProductos();

	public void guardarProducto(Producto producto);

	public Producto obtenProducto(int theId);

	public void borrarProducto(int theId);
}
