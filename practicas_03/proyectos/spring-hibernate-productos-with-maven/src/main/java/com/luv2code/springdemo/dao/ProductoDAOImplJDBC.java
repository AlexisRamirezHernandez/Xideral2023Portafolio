package com.luv2code.springdemo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Producto;

@Repository
public class ProductoDAOImplJDBC implements ProductoDAO {
	@Autowired
	private DataSource dataSource;

	@Override
	public List<Producto> getProductos() {

		List<Producto> productos = new ArrayList<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			// get a connection
			myConn = dataSource.getConnection();
			System.out.println(myConn);
			// create sql statement
			String sql = "select * from producto order by codigo";

			myStmt = myConn.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result set
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("codigo");
				String descripcion = myRs.getString("descripcion");
				int cantidad = myRs.getInt("cantidad");
				float precioventa = myRs.getFloat("precio_venta");
				int categoria_id = myRs.getInt("categoria_id");

				// create new student object
				Producto tempProducto = new Producto(id, descripcion, cantidad, precioventa, categoria_id);

				// add it to the list of students
				productos.add(tempProducto);
			}

			return productos;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
		return productos;
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}

			if (myStmt != null) {
				myStmt.close();
			}

			if (myConn != null) {
				myConn.close(); // doesn't really close it ... just puts back in connection pool
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	@Override
	public void guardarProductos(Producto producto) {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();

			// create sql for insert
			System.out.println(producto.getCodigo());
			String sql = producto.getCantidad() == 0
					? "insert into producto " + "(descripcion, cantidad, precio_venta,categoria_id)"
							+ "values (?, ?, ?, ?)"
					: "update producto " + "set descripcion=?, cantidad=?, precio_venta=?, categoria_id=? "
							+ "where codigo=?";

			myStmt = myConn.prepareStatement(sql);

			if (producto.getCodigo()==0) {
				myStmt.setString(1, producto.getDescripcion());
				myStmt.setInt(2, producto.getCantidad());
				myStmt.setDouble(3, producto.getPrecio_venta());
				myStmt.setInt(4, producto.getCategoria_id());
			}
			if(producto.getCodigo()!=0) {
				myStmt.setString(1, producto.getDescripcion());
				myStmt.setInt(2, producto.getCantidad());
				myStmt.setDouble(3, producto.getPrecio_venta());
				myStmt.setDouble(4, producto.getCategoria_id());
				myStmt.setInt(5, producto.getCodigo());
			}
			// set the param values for the student
			

			// execute sql insert
			myStmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	@Override
	public Producto getProducto(int codigo) {

		Producto producto = null;

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int codigoID;

		try {
			// convert student id to int
			codigoID = codigo;

			// get connection to database
			myConn = dataSource.getConnection();

			// create sql to get selected student
			String sql = "select * from producto where codigo=?";

			// create prepared statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, codigoID);

			// execute statement
			myRs = myStmt.executeQuery();

			// retrieve data from result set row
			if (myRs.next()) {

				int id = myRs.getInt("codigo");
				String descripcion = myRs.getString("descripcion");
				int cantidad = myRs.getInt("cantidad");
				float precioventa = myRs.getFloat("precio_venta");
				int categoria_id = myRs.getInt("categoria_id");

				// use the studentId during construction
				producto = new Producto(id, descripcion, cantidad, precioventa, categoria_id);
			} else {
				throw new Exception("No se pudo encontrar el producto con el codigo: " + codigoID);
			}

			return producto;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
		return producto;
	}

	public void actualizarProducto(Producto producto) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();

			// create SQL update statement
			String sql = "update producto " + "set descripcion=?, cantidad=?, precio_venta=?, categoria_id=? "
					+ "where codigo=?";
			System.out.println(sql);
			// prepare statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setString(1, producto.getDescripcion());
			myStmt.setInt(2, producto.getCantidad());
			myStmt.setDouble(3, producto.getPrecio_venta());
			myStmt.setDouble(4, producto.getCategoria_id());
			myStmt.setInt(5, producto.getCodigo());

			// execute SQL statement
			myStmt.execute();
		} finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	@Override
	public void borrarProducto(int codigo) {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// convert student id to int
			int codigoID = codigo;

			// get connection to database
			myConn = dataSource.getConnection();

			// create sql to delete student
			String sql = "delete from producto where codigo=?";

			// prepare statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, codigoID);

			// execute sql statement
			myStmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// clean up JDBC code
			close(myConn, myStmt, null);
		}
	}
}
