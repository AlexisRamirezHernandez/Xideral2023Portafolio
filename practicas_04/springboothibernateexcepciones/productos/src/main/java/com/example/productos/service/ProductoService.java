package com.example.productos.service;

import java.util.List;

import com.example.productos.entity.Producto;

public interface ProductoService {
	public List<Producto> findAll();

	public Producto findById(int Id);

	public void save(Producto producto);

	public void deleteById(int Id);
}
