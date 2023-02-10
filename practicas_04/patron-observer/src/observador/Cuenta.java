package observador;

public class Cuenta extends Subject {

	Persona p;
	Cuenta(Persona p){
		this.p=p;
	}
	void ingresarDinero() {
		System.out.println(p.getNombre());
		this.notificar();
	}
}
