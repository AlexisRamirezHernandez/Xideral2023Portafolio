package com.curso;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.programa.Numero;
import com.programa.NumeroComplejo;
import com.programa.NumeroNatural;
import com.programa.NumeroNegativo;
import com.programa.NumeroPrimo;

class test01 {

	@Test
	void TestNumeroNegativo() {
		Numero n = new NumeroNegativo();
		String numero="9";
		assertEquals(false, n.tipoNumero(numero));
	}
	@Test
	void TestNumeroComplejo() {
		Numero n = new NumeroComplejo();
		String numero="3i";
		assertEquals(false, n.tipoNumero(numero));
	}
	@Test
	void TestNumeroConplejo2() {
		Numero n = new NumeroComplejo();
		String numero="9+3i";
		assertEquals(true, n.tipoNumero(numero));
	}
	@Test
	void TestNumeroPrimo() {
		Numero n = new NumeroPrimo();
		String numero="9";
		assertEquals(false, n.tipoNumero(numero));
	}
	@Test
	void TestNumeroPrimo2() {
		Numero n = new NumeroPrimo();
		String numero="7";
		assertEquals(false, n.tipoNumero(numero));
	}
	@Test
	void TestNumeroNatural() {
		Numero n = new NumeroNatural();
		String numero="9";
		assertEquals(true, n.tipoNumero(numero));
	}
	@Test
	void TestNumeroNatural2() {
		Numero n = new NumeroNatural();
		String numero="-9";
		assertEquals(true, n.tipoNumero(numero));
	}
	@Test
	void TestNumeroNull() {
		Numero n = new NumeroNatural();
		String number=null;
	    boolean type =n.tipoNumero(number);
		assertNull(type);
	}
	
}
