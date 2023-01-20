package inyecciondependencias;

public class Lacteo implements Producto {

	private String tipo;
	public Lacteo(String tipo) {
		this.tipo=tipo;
	}
	@Override
	public void establecer_tipo() {
		System.out.format("Este producto es un lacteo de tipo: %-10s \n", tipo);
	}

}
