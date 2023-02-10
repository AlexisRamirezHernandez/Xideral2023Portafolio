package com.example.productos.dao;

import java.util.List;

import com.example.productos.entity.Producto;

public interface ProductoDAO {
	public List<Producto> findAll();

	public Producto findById(int Id);

	public void save(Producto producto);

	public void deleteById(int Id);
}
