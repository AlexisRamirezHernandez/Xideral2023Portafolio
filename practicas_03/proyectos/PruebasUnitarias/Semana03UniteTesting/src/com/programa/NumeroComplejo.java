package com.programa;

public class NumeroComplejo implements Numero {

	@Override
	public boolean tipoNumero(String number) {
		return number.contains("i");
	}

}
