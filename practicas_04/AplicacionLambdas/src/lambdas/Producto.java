package lambdas;

public class Producto {
	private int codigo;
	private String descripcion;
	private String categoria;
	private int cantidad;
	private double precio;

	public Producto(int codigo, String descripcion, int cantidad, String categoria, double precio) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return codigo + "," + descripcion + "," + categoria + "," + cantidad + "," + precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Producto actualizarStock(int cantidad) {
		return this;
	}
}
