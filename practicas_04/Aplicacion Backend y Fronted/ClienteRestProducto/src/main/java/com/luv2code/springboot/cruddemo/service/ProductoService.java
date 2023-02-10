package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Producto;

public interface ProductoService {
	public List<Producto> findAll();

	public Producto findById(int Id);

	public void save(Producto producto);

	public void deleteById(int Id);
}
