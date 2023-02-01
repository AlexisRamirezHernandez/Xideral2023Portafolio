package com.programa;

public class NumeroPrimo implements Numero{

	@Override
	public boolean tipoNumero(String number) {
		int numero=Integer.parseInt(number);
		int cantidad=0;
		for (int i=1;i<=numero;i++) {
			if(numero%i==0)cantidad++; 
		}
		return cantidad==2;
	}

}
