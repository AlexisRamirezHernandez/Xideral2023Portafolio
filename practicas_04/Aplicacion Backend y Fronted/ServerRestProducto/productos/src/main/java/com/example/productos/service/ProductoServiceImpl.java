package com.example.productos.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productos.dao.ProductoDAO;
import com.example.productos.entity.Producto;

@Service
public class ProductoServiceImpl implements ProductoService {

	private ProductoDAO productoDAO;

	@Autowired
	public ProductoServiceImpl(ProductoDAO productoDAO) {
		this.productoDAO = productoDAO;
	}

	@Override
	@Transactional
	public List<Producto> findAll() {
		return productoDAO.findAll();
	}

	@Override
	@Transactional
	public Producto findById(int Id) {
		return productoDAO.findById(Id);
	}

	@Override
	@Transactional
	public void save(Producto producto) {
		productoDAO.save(producto);
	}

	@Override
	@Transactional
	public void deleteById(int Id) {
		productoDAO.deleteById(Id);

	}

}
