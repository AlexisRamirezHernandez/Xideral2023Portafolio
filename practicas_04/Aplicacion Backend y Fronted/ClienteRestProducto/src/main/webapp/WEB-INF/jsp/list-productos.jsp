<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Catalogo de Productos</title>

<!-- reference our style sheet -->

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Catalogo de Productos</h2>
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
					<th>Cantidad</th>
					<th>Precio Venta</th>
					<th>Categoria</th>
					<th>Action</th>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="producto" items="${productos}">

					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/mvc/showFormForUpdate">
						<c:param name="codigoId" value="${producto.codigo}" />
					</c:url>

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/mvc/delete">
						<c:param name="codigoId" value="${producto.codigo}" />
					</c:url>

					<tr>
						<td>${producto.codigo}</td>
						<td>${producto.descripcion}</td>
						<td>${producto.cantidad}</td>
						<td>${producto.precio_venta}</td>
						<td>${producto.categoria_id}</td> ¿
						<td>
							<!-- display the update link --> <a href="${updateLink}">Update</a>
							| <a href="${deleteLink}"
							onclick="if (!(confirm('Estas seguro que deseas eliminar este producto?'))) return false">Delete</a>
						</td>

					</tr>

				</c:forEach>

			</table>

		</div>

	</div>

</body>
</html>