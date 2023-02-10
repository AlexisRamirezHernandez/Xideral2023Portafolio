package com.example.productos.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productos.entity.Producto;
import com.example.productos.service.ProductoService;

@RestController
@RequestMapping("/api")
public class ProductoRestController {
	
	private ProductoService productoService;

	@Autowired
	public ProductoRestController(ProductoService productoService) {
		this.productoService = productoService;
	}

	// expose "/employees" and return list of employees
	@GetMapping("/productos")
	public List<Producto> findAll() {
		return productoService.findAll();
	}

	// add mapping for GET /employees/{employeeId}

	@GetMapping("/productos/{codigoId}")
	public Producto getProducto(@PathVariable int codigoId) {

		Producto theProducto = productoService.findById(codigoId);

		if (theProducto == null) {
			throw new ProductoNotFoundException("El producto con el codigo: " + codigoId + " No existe");
		}

		return theProducto;
	}

	// add mapping for POST /employees - add new employee

	@PostMapping("/productos")
	public Producto addProducto(@RequestBody Producto producto) {

		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update

		producto.setCodigo(0);

		productoService.save(producto);

		return producto;
	}

	// add mapping for PUT /employees - update existing employee

	@PutMapping("/productos")
	public Producto updateProducto(@RequestBody Producto producto) {

		productoService.save(producto);

		return producto;
	}

	// add mapping for DELETE /employees/{employeeId} - delete employee

	@DeleteMapping("/productos/{codigoId}")
	public String deleteProducto(@PathVariable int codigoId) {

		Producto tempProducto = productoService.findById(codigoId);

		// throw exception if null

		if (tempProducto == null) {
			throw new ProductoNotFoundException("Producto codigo no fue encontrado - " + codigoId);
		}

		productoService.deleteById(codigoId);

		return "Producto eliminado - " + codigoId;
	}
}
