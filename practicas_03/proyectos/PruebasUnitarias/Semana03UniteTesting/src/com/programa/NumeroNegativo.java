package com.programa;

public class NumeroNegativo implements Numero {

	@Override
	public boolean tipoNumero(String number) {
		return Float.parseFloat(number)<=0;
	}

}
