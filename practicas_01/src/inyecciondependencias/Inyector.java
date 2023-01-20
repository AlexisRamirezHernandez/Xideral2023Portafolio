package inyecciondependencias;

public class Inyector {
	static Producto lacteo=new Lacteo("Leche Lala 1 litro");
	static Producto comida= new ComidaRapida("Hot Dog Vickingo");
	
	public static void inyectarProducto(Oxxo oxxo,String tipo) {
		if(tipo=="lacteo") oxxo.setCProducto(lacteo);
		if(tipo=="comida") oxxo.setCProducto(comida);
	}
}
