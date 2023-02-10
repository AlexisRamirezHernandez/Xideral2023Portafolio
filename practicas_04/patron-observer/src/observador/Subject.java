package observador;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
	private List<Observer> observadores = new ArrayList<>();
	
	void attach(Observer o) { 
		observadores.add(o);
	}
	
	void detach(Observer o) {
		observadores.remove(o);
	}
	void notificar() {
		for(Observer o: observadores)
			o.update();
	}
}
