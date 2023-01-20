package polimorfismo_abstracta_01;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		ProductoElectrico computadora=new Computadora("9877678240032","Lenovo ideapad l340",15_435,2,"laptop");
		ProductoElectrico foco= new Foco("763228240032","Steren Wifi RGB",96.23, 100);
		
		List<ProductoElectrico>lista_almacen= new ArrayList<ProductoElectrico>();
		
		lista_almacen.add(computadora);
		lista_almacen.add(foco);
		System.out.format("%-15s %-15s %-25s %-15s %-10s %-25s %-15s",
				"Tipo Producto", "Codigo","Descripcion","Precio","Stock","Situacion Almacen","Forma de encendido");
		System.out.println();
		System.out.print("___________________________________________________________________________________________________________________________");
		System.out.println();
		for (ProductoElectrico producto : lista_almacen) {
			System.out.println(producto.toString());
		}
		
	}

}
