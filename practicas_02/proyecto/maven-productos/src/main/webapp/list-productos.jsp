<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Student Tracker App</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>FooBar University</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Student -->
			
			<input type="button" value="Add Student" 
				   onclick="window.location.href='add-producto-form.jsp'; return false;"
				   class="add-student-button"
			/>
			
			<table>
			
				<tr>
					<th>Codigo</th>
					<th>Descripcion</th>
					<th>Cantidad</th>
					<th>Precio de venta</th>
					<th>Acciones</th>
				</tr>
				
				<c:forEach var="tempProducto" items="${PRODUCT_LIST}">
					
					<!-- set up a link for each student -->
					<c:url var="tempLink" value="ProductoController">
						<c:param name="command" value="LOAD" />
						<c:param name="codigoID" value="${tempProducto.codigo}" />
					</c:url>

					<!--  set up a link to delete a student -->
					<c:url var="deleteLink" value="ProductoController">
						<c:param name="command" value="DELETE" />
						<c:param name="codigoID" value="${tempProducto.codigo}" />
					</c:url>
																		
					<tr>
						<td> ${tempProducto.descripcion} </td>
						<td> ${tempProducto.cantidad} </td>
						<td> ${tempStudent.precioventa} </td>
						<td> ${tempStudent.departamento_id} </td>
						
						<td> 
							<a href="${tempLink}">Update</a> 
							 | 
							<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">
							Delete</a>	
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








