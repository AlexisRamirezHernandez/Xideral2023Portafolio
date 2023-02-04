package com.javatechie.spring.batch.config;

import org.springframework.batch.item.ItemProcessor;

import com.javatechie.spring.batch.entity.Producto;

public class ProductoProcessor implements ItemProcessor<Producto, Producto> {

	@Override
	public Producto process(Producto item) throws Exception {
		if (item.getCategoria().equals("Frutas/Verduras")) {
			return item;
		}
		return null;
//	    	return item;
	}

}
