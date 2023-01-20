package patronsingleton;

public class SecretarioGobierno {

	static private SecretarioGobierno sg = new SecretarioGobierno("Jesus Romero","Secretaria de Gobierno"); 
	static int contador;
	
	private SecretarioGobierno(String nombre,String dependencia) {
		
		contador++;
	}

	static public SecretarioGobierno getnstance() {
		return sg;
	}
}
