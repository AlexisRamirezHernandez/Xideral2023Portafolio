package com.example.productos.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.productos.entity.Producto;

@Repository
public class ProductoDAOHibernateImpl implements ProductoDAO {

	private EntityManager entityManager;

	@Autowired
	public ProductoDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Producto> findAll() {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		Query<Producto> theQuery = currentSession.createQuery("from Producto", Producto.class);

		// execute query and get result list
		List<Producto> productos = theQuery.getResultList();

		// return the results
		return productos;
	}

	@Override
	public Producto findById(int Id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Producto producto = currentSession.get(Producto.class, Id);
		return producto;
	}

	@Override
	public void save(Producto producto) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(producto);

	}

	@Override
	public void deleteById(int Id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery(
						"delete from Producto where codigo=:codigoId");
		theQuery.setParameter("codigoId", Id);
		
		theQuery.executeUpdate();

	}

}
