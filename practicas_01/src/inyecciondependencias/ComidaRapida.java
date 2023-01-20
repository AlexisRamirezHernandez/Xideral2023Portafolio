package inyecciondependencias;

public class ComidaRapida implements Producto{

	private String tipo;
	public ComidaRapida(String tipo) {
		this.tipo=tipo;
	}
	@Override
	public void establecer_tipo() {
		System.out.format("Este producto es un lacteo de tipo: %-10s \n", tipo);
	}
}
