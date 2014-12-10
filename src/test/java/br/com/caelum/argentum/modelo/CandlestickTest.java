package br.com.caelum.argentum.modelo;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

public class CandlestickTest {

	@Test(expected = IllegalArgumentException.class)
	public void precoMaximoNaoPodeSerMenorQueMinimo() {
		//Candlestick(abertura, fechamento, minimo, maximo, volume, data)
		new Candlestick(10, 20, 20, 10, 10000, Calendar.getInstance());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void precoMaximoNaoPodeTerDataNula() {
		//Candlestick(abertura, fechamento, minimo, maximo, volume, data)
		new Candlestick(10, 20, 10, 20, 10000, null);
	}
	
	@Test
	public void quandoAberturaIgualFechamentoEhAlta() {
		Candlestick candle = new Candlestick(10, 10, 10, 20, 10000, Calendar.getInstance());
		assertTrue("quando abertura é igual fechamento, o candle stick deve estar em alta", candle.isAlta());
	}
	
}
