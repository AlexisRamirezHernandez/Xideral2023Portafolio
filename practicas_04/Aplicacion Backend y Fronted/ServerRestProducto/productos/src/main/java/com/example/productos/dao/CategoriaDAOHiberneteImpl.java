package com.example.productos.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.productos.entity.Categoria;

@Repository
public class CategoriaDAOHiberneteImpl implements CategoriaDAO {

	private EntityManager entityManager;

	@Autowired
	public CategoriaDAOHiberneteImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Categoria> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		Query<Categoria> theQuery = currentSession.createQuery("from Categoria", Categoria.class);

		// execute query and get result list
		List<Categoria> categorias = theQuery.getResultList();

		// return the results
		return categorias;
	}

	@Override
	public Categoria findById(int Id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		Categoria categoria = currentSession.get(Categoria.class, Id);
		return categoria;
	}

	@Override
	public void save(Categoria categoria) {
		Session currentSession = entityManager.unwrap(Session.class);

		// save employee
		currentSession.saveOrUpdate(categoria);

	}

	@Override
	public void deleteById(int Id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Categoria where id=:categoriaID");
		theQuery.setParameter("categoriaId", Id);

		theQuery.executeUpdate();

	}

}
