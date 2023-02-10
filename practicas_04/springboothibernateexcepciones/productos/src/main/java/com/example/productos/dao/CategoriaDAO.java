package com.example.productos.dao;

import java.util.List;

import com.example.productos.entity.Categoria;

public interface CategoriaDAO {
	public List<Categoria> findAll();

	public Categoria findById(int Id);

	public void save(Categoria categoria);

	public void deleteById(int Id);

}
