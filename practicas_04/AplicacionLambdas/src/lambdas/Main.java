package lambdas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) throws IOException{
		List<Producto> productos = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("src/lambdas/products.csv"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        Producto p = new Producto(Integer.parseInt(values[0]),values[1],
		        		Integer.parseInt(values[2]),values[4],Double.parseDouble(values[5]));
		        
		        productos.add(p);

		    }
		}

		// crear una lista con  aquellos productos que sean menores 5 pesos
		// para aumentarles el precio 3 pesos mas 
		
		List<Producto> productosbajos= productos.stream()
				.filter(x->x.getPrecio()<5.00)
				.peek(z->z.setPrecio(z.getPrecio()+0))
				.collect(Collectors.toList());
		productosbajos.forEach(x -> System.out.println(x.toString()));
		
	}
}
