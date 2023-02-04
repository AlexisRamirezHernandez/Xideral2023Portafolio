package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Producto;
@Repository
public class ProductoDAOImpl implements ProductoDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Producto> getProductos() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query ... sort by last name
		Query<Producto> theQuery = currentSession.createQuery("from Producto order by codigo", Producto.class);

		// execute query and get result list
		List<Producto> customers = theQuery.getResultList();

		// return the results
		return customers;
	}

	@Override
	public void guardarProductos(Producto producto) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save/upate the product ... finally LOL
		currentSession.saveOrUpdate(producto);

	}

	@Override
	public Producto getProducto(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		Producto producto = currentSession.get(Producto.class, theId);

		return producto;
	}

	@Override
	public void borrarProducto(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Producto where codigo=:codigoID");
		theQuery.setParameter("codigoID", theId);

		theQuery.executeUpdate();

	}

}
