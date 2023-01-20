package polimorfismo_abstracta_01;

public abstract class ProductoElectrico {
	
	private String codigo;
	private String descripcion;
	private double precio;
	private int cantidad;
	
	public ProductoElectrico(String codigo, String descripcion,double precio,int cantidad) {
		this.codigo=codigo;
		this.descripcion=descripcion;
		this.precio=precio;
		this.cantidad=cantidad;
	}

	public abstract String conocer_situacion();
	public abstract String forma_encendido();
	public String toString() {
		return String.format("%-15s %-15s %-25s $%-15.2f %-10d %-25s %-15s",
				this.getClass().getSimpleName(), codigo,descripcion,precio,cantidad,this.conocer_situacion(),this.forma_encendido());
	}
}
