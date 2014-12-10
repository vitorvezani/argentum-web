package br.com.caelum.argentum.testes;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.argentum.modelo.Candlestick;
import br.com.caelum.argentum.modelo.CandlestickFactory;
import br.com.caelum.argentum.modelo.Negociacao;

public class TestesAdicionais {
	public static void main(String[] args) {
		Calendar hoje = Calendar.getInstance();
		
		Negociacao negociacao1 = new Negociacao(30.0, -1, hoje);
		Negociacao negociacao2 = new Negociacao(30.0, 0, hoje);
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2);
		CandlestickFactory candleFactory = new CandlestickFactory();
		Candlestick candle = candleFactory.constroiCandleParaData(hoje, negociacoes);
		
		System.out.println(candle);
	}
}
