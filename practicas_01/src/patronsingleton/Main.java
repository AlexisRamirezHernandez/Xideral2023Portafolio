package patronsingleton;

public class Main {

	public static void main(String[] args) {
		SecretarioGobierno sg1= SecretarioGobierno.getnstance();
		SecretarioGobierno sg2= SecretarioGobierno.getnstance();
		SecretarioGobierno sg3= SecretarioGobierno.getnstance();
		SecretarioGobierno sg4= SecretarioGobierno.getnstance();

		System.out.println(sg1.getClass().getSimpleName()+"Solo permite tener "
		+SecretarioGobierno.contador+" Cargo de este tipo");
	}

}
