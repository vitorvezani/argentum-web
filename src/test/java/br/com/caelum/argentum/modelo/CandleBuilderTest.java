package br.com.caelum.argentum.modelo;

import org.junit.Test;

public class CandleBuilderTest {

	@Test(expected = IllegalStateException.class)
	public void geracaoDeCandleDeveTerTodosOsDadosNecessarios() {
		CandleBuilder candleBuilder = new CandleBuilder();
		candleBuilder
			.comAbertura(Double.MAX_VALUE)
			.comData(null)
			.comFechamento(Double.MAX_VALUE)
			.comMaximo(Double.MAX_VALUE)
			.comMinimo(Double.MAX_VALUE)
			.comVolume(Double.MAX_VALUE)
			.geraCandle();
	}

}
