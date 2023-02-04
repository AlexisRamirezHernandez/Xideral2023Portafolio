
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<title>Lista de Productos</title>

<!-- reference our style sheet -->

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Administrador de productos</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<!-- put new button: Add Customer -->

			<input type="button" value="Add Producto"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />

			<!--  add our html table here -->

			<table>
				<tr>
					<th>Codigo</th>
					<th>Descripcion</th>
					<th>Stock</th>
					<th>Precio Venta</th>
					<th>Categoria</th>
					<th>Acciones</th>

				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="producto" items="${productos}">

					<c:url var="updateLink" value="/producto/showFormForUpdate">
						<c:param name="codigoID" value="${producto.codigo}" />
					</c:url>

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/producto/delete">
						<c:param name="codigoID" value="${producto.codigo}" />
					</c:url>


					<tr>
						<td>${producto.codigo}</td>
						<td>${producto.descripcion}</td>
						<td>${producto.cantidad}</td>
						<td>${producto.precio_venta}</td>
						<td>${producto.categoria_id}</td>


						<td>
							<!-- display the update link --> <a href="${updateLink}">Update</a>
							| <a href="${deleteLink}"
							onclick="if (!(confirm('Estas seguro de eliminar este producto?'))) return false">Delete</a>
						</td>

					</tr>

				</c:forEach>

			</table>

		</div>

	</div>


</body>

</html>









