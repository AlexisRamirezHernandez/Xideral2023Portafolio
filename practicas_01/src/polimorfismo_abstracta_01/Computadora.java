package polimorfismo_abstracta_01;

public class Computadora extends ProductoElectrico {

	private int cantidad;
	private String tipo;
	public Computadora(String codigo, String descripcion, double precio, int cantidad,String tipo) {
		super(codigo, descripcion, precio, cantidad);
		this.cantidad=cantidad;
		this.tipo=tipo;
	}

	@Override
	public String conocer_situacion() {
		if(cantidad==0) return "Agotado";
		if(cantidad>0&&cantidad<10) return "Por agotarse";
		return "Disponible";
	}
	
	@Override 
	public String forma_encendido() {
		if(tipo=="laptop")return "Carge la bateria";
		return "Mantenga conectada siempre";
		
	}
	
}
