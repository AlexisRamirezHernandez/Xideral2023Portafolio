package polimorfismo_abstracta_01;

public class Foco extends ProductoElectrico {

	private int cantidad;
	public Foco(String codigo, String descripcion, double precio, int cantidad) {
		super(codigo, descripcion, precio, cantidad);
		this.cantidad=cantidad;
	}

	@Override
	public String conocer_situacion() {
		if(cantidad==0) return "Agotado";
		if(cantidad>0&&cantidad<60) return "Por agotarse";
		return "Disponible";
	}

	@Override
	public String forma_encendido() {
		return "Coloque el foco en el socket y encienda la luz";
	}
	
}
