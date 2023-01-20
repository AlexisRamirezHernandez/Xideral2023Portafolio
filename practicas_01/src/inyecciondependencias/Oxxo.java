package inyecciondependencias;

public class Oxxo {

	private String sucursal;
	private Producto producto;
	public Oxxo(String sucursal) {
		this.sucursal=sucursal;
	}
	
	public void abrirSucursal(){
		System.out.println("Abriendo sucursal...");
	}
	public void ingresar_producto() {
		System.out.println("Ingresando productos:");
		producto.establecer_tipo();
	}
	public Producto getProducto() {
		return producto;
	}
	public void setCProducto(Producto producto) {
		this.producto=producto;
	}
	
	@Override
	public String toString() {
		return String.format("Sucursal: %-10s", sucursal);
	}
}
