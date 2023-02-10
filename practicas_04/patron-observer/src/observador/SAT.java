package observador;

public class SAT extends Observer {
	private double monto;

	public SAT(double monto,Subject sb) {
		super(sb);
		this.monto = monto;
	}

	public void showAviso() {
		System.out.println("El SAT Detecto un movimiento de dinero a tu cuenta por $"+monto);
	}

	@Override
	public void update() {
		showAviso();
	}

}
