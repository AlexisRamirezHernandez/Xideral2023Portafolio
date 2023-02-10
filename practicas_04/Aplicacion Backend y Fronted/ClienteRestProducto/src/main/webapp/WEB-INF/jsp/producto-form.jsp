<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<title>Guardar Producto</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/add-customer-style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Guardar información producto</h3>

		<form:form action="saveProducto" modelAttribute="producto"
			method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="codigo" />

			<table>
				<tbody>
					<tr>
						<td><label>Descripcion:</label></td>
						<td><form:input path="descripcion" /></td>
					</tr>

					<tr>
						<td><label>Cantidad:</label></td>
						<td><form:input type="number" path="cantidad" /></td>
					</tr>

					<tr>
						<td><label>Precio Venta:</label></td>
						<td><form:input type="number" path="precio_venta" /></td>
					</tr>
					<tr>
						<td><label>Categoria:</label></td>
						<td><select name="categoria_id" id="categoria_id">
								<option value="1">1</option>
						</select></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>


				</tbody>
			</table>


		</form:form>

		<div style=""></div>

		<p>
			<a href="${pageContext.request.contextPath}/mvc/employees">Back
				to List</a>
		</p>

	</div>

</body>
</html>