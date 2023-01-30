package com.luv2code.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;




/**
 * Servlet implementation class ProductoController
 */
@WebServlet("/ProductoController")
public class ProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDbUtil productoDbUtil;
	
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoController() throws ServletException{
        super();
        // TODO Auto-generated constructor stub
        try {
			productoDbUtil = new ProductoDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listarProductos(request, response);
				break;
				
			case "ADD":
				agregarProducto(request, response);
				break;
				
			case "LOAD":
				cargarProducto(request, response);
				break;
				
			case "UPDATE":
				actualizarProducto(request, response);
				break;
			
			case "DELETE":
				eliminarProducto(request, response);
				break;
				
			default:
				listarProductos(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read student id from form data
		String codigoID = request.getParameter("codigo");
		
		// delete student from database
		productoDbUtil.borrarProducto(codigoID);
		
		// send them back to "list students" page
		listarProductos(request, response);
	}

	private void actualizarProducto(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read student info from form data
		int id = Integer.parseInt(request.getParameter("codigo"));
		String descripcion = request.getParameter("descripcion");
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		double precio_venta =Double.parseDouble( request.getParameter("precioventa"));
		int departamento_id= Integer.parseInt(request.getParameter("departamento_id"));
		
		// create a new student object
		Producto producto = new Producto(descripcion, cantidad, precio_venta, departamento_id);		
		// perform update on database
		productoDbUtil.actualizarProducto(producto);
		
		// send them back to the "list students" page
		listarProductos(request, response);
		
	}

	private void cargarProducto(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// read student id from form data
		String codigoID = request.getParameter("codigo");
		
		// get student from database (db util)
		Producto producto =productoDbUtil.obtenunProducto(codigoID);
		
		// place student in the request attribute
		request.setAttribute("THE_STUDENT", producto);
		
		// send to jsp page: update-student-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-producto-form.jsp");
		dispatcher.forward(request, response);		
	}

	private void agregarProducto(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read student info from form data
		String descripcion = request.getParameter("descripcion");
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		Double precioventa = Double.parseDouble(request.getParameter("precioventa"));		
		int departamento_id=1;
		// create a new student object
		Producto producto = new Producto(descripcion, cantidad,precioventa, departamento_id);
		
		// add the student to the database
		productoDbUtil.agregarProducto(producto);
				
		// send back to main page (the student list)
		listarProductos(request, response);
	}

	private void listarProductos(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// get students from db util
		List<Producto> productos = productoDbUtil.obtenProductos();
		
		// add students to the request
		request.setAttribute("PRODUCT_LIST", productos);
				
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-productos.jsp");
		dispatcher.forward(request, response); 
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
