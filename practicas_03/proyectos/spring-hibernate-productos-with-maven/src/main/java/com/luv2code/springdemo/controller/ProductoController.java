package com.luv2code.springdemo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Producto;
import com.luv2code.springdemo.service.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	// need to inject our customer service
		@Autowired
		private ProductoService productoService;
		
		@GetMapping("/list")
		public String listCustomers(Model theModel) {
			System.out.println("HOLA");

			// get customers from the service
			List<Producto> productos = productoService.getProductos();
			// add the customers to the model
			theModel.addAttribute("productos", productos);
			
			return "list-productos";
		}
		
		@GetMapping("/showFormForAdd")
		public String showFormForAdd(Model theModel) {
			
			// create model attribute to bind form data
			Producto producto = new Producto();
			
			theModel.addAttribute("producto", producto);
			
			return "producto-form";
		}
		
		@PostMapping("/saveProducto")
		public String saveProducto(@ModelAttribute("producto") Producto produto) {
			
			// save the customer using our service
			productoService.guardarProducto(produto);	
			
			return "redirect:/producto/list";
		}
		
		@GetMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("codigoID") int theId,
										Model theModel) {
			
			// get the customer from our service
			Producto producto = productoService.obtenProducto(theId);	
			
			// set customer as a model attribute to pre-populate the form
			theModel.addAttribute("producto",producto);
			
			// send over to our form		
			return "producto-form";
		}
		
		@GetMapping("/delete")
		public String deleteProducto(@RequestParam("codigoID") int theId) {
			
			// delete the customer
			productoService.borrarProducto(theId);
			
			return "redirect:/producto/list";
		}
}
