package observador;



public class Main {

	public static void main(String[] args) {
		Persona persona = new Persona("Oscar");
		Cuenta cuenta= new Cuenta(persona);
		double monto = 18_000;
		Observer banco =new Banco(monto, cuenta);
	
		if (monto>15_000) {Observer sat = new SAT(monto, cuenta);}
		
		cuenta.ingresarDinero();
		
	}
}
