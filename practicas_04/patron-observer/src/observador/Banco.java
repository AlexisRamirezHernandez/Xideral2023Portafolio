package observador;

public class Banco extends Observer {

	private double monto;

	public Banco(double monto,Subject sb) {
		super(sb);
		this.monto = monto;
	}
	
	public void showAviso() {
		System.out.println("Ingreso nuevo por: "+monto);
	}

	@Override
	void update() {
		showAviso();
	}

}
