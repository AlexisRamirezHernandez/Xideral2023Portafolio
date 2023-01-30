package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class ProductoDbUtil {
	private DataSource dataSource;

	public ProductoDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Producto> obtenProductos() throws Exception {
		
		List<Producto> productos = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
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
				double precioventa = myRs.getDouble("precio_venta");
				int departamento_id=myRs.getInt("departamento_id");
				
				// create new student object
				Producto tempProducto = new Producto(id, descripcion, cantidad, precioventa,departamento_id);
				
				// add it to the list of students
				productos.add(tempProducto);				
			}
			
			return productos;		
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}		
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
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void agregarProducto(Producto producto) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into producto "
					   + "(descripcion, cantidad, precio_venta,departamento_id)"
					   + "values (?, ?, ?, 1)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the student
			myStmt.setString(1, producto.getDescripcion());
			myStmt.setInt(2, producto.getCantidad());
			myStmt.setDouble(3, producto.getPrecio_venta());
			myStmt.setInt(4, producto.getDepartamento_id());

	
			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public Producto obtenunProducto(String codigo) throws Exception {

		Producto producto = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int codigoID;
		
		try {
			// convert student id to int
			codigoID = Integer.parseInt(codigo);
			
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
				
			//	int id = myRs.getInt("codigo");
				String descripcion = myRs.getString("descripcion");
				int cantidad = myRs.getInt("cantidad");
				double precioventa = myRs.getDouble("precio_venta");
				int departamento_id=myRs.getInt("departamento_id");
				
				// use the studentId during construction
				producto = new Producto(descripcion, cantidad, precioventa, departamento_id);
			}
			else {
				throw new Exception("No se pudo encontrar el producto con el codigo: " + codigoID);
			}				
			
			return producto;
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	public void actualizarProducto(Producto producto) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "update producto "
						+ "set descripcion=?, cantidad=?, precio_venta=? "
						+ "where codigo=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setString(1, producto.getDescripcion());
			myStmt.setInt(2, producto.getCantidad());
			myStmt.setDouble(3, producto.getPrecio_venta());
			//myStmt.setInt(4, theStudent.getId());
			
			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public void borrarProducto(String codigo) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert student id to int
			int codigoID = Integer.parseInt(codigo);
			
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
		}
		finally {
			// clean up JDBC code
			close(myConn, myStmt, null);
		}	
	}
}
