package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.cruddemo.entity.Producto;
import com.luv2code.springboot.cruddemo.service.ProductoService;



@Controller
@RequestMapping("/mvc")
public class ProductoMvcController {
	// need to inject our customer service
		@Autowired
		private ProductoService productoService;
		
		@GetMapping("/productos")
		public String listProductos(Model theModel) {
			
			// get customers from the service
			List<Producto> productos = productoService.findAll();
					
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
		public String saveCustomer(@ModelAttribute("producto") Producto producto) {
			
			// save the customer using our service
			productoService.save(producto);	
			
			return "redirect:/mvc/productos";
		}
		
		@GetMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("codigoId") int theId,
										Model theModel) {
			
			// get the customer from our service
			Producto producto = productoService.findById(theId);	
			
			// set customer as a model attribute to pre-populate the form
			theModel.addAttribute("producto", producto);
			
			// send over to our form		
			return "producto-form";
		}
		
		@GetMapping("/delete")
		public String deleteProducto(@RequestParam("codigoId") int theId) {
			
			// delete the customer
			productoService.deleteById(theId);
			
			return "redirect:/mvc/productos";
		}

}
