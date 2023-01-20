package inyecciondependencias;

public class Main {

	public static void main(String[] args) {
		Oxxo oxxo1=new Oxxo("Oxxo Xoxocotlán");
		Inyector.inyectarProducto(oxxo1, "lacteo");
		System.out.println(oxxo1.toString());
		oxxo1.abrirSucursal();
		oxxo1.ingresar_producto();
		
		Oxxo oxxo2 = new Oxxo("Oxxo Oaxaca de Juarez");
		Inyector.inyectarProducto(oxxo2, "comida");
		System.out.println(oxxo2.toString());
		oxxo2.abrirSucursal();
		oxxo2.ingresar_producto();
		
	}

}
