package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.ProductoDAO;
import com.luv2code.springdemo.entity.Producto;
@Service
public class ProductoServiceImpl implements ProductoService {
	// need to inject customer dao


	//@Autowired 
	//@Qualifier("productoDAOImplJDBC") 
	
	//@Qualifier("ProductoDAOImpl") 
	@Autowired
	@Qualifier("productoDAOImplJDBC") 
	private ProductoDAO productoDAO;

	@Override
	@Transactional
	public List<Producto> getProductos() {
		return productoDAO.getProductos();
	}

	@Override
	@Transactional
	public void guardarProducto(Producto producto) {
		productoDAO.guardarProductos(producto);

	}

	@Override
	@Transactional
	public Producto obtenProducto(int theId) {
		return productoDAO.getProducto(theId);
	}

	@Override
	@Transactional
	public void borrarProducto(int theId) {
		productoDAO.borrarProducto(theId);

	}

}
