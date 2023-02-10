package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.luv2code.springboot.cruddemo.entity.Producto;

@Service
public class ProductoServiceImpl implements ProductoService {

	private RestTemplate restTemplate;

	private String crmRestUrl;

	private Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	public ProductoServiceImpl(RestTemplate theRestTemplate, @Value("${crm.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;

		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}

	@Override
	public List<Producto> findAll() {
		ResponseEntity<List<Producto>> responseEntity = restTemplate.exchange(crmRestUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Producto>>() {
				});

		List<Producto> productos = responseEntity.getBody();

		logger.info("in findAll(): productos" + productos);

		return productos;
	}

	@Override
	public Producto findById(int Id) {
		Producto producto = restTemplate.getForObject(crmRestUrl + "/" + Id, Producto.class);

		logger.info("in findById(): El Producto=" + producto);

		return producto;
	}

	@Override
	public void save(Producto producto) {

		int codigo = producto.getCodigo();

		// make REST call
		if (codigo == 0) {
			// add employee
			restTemplate.postForEntity(crmRestUrl, producto, String.class);

		} else {
			// update employee
			restTemplate.put(crmRestUrl, producto);
		}

		logger.info("El producto se guardo(): success");

	}

	@Override
	public void deleteById(int Id) {
		restTemplate.delete(crmRestUrl + "/" + Id);

		logger.info("in deleteById() Producto se elimino con codigo:=" + Id);

	}

}
