package br.com.caelum.argentum.modelo;

import java.util.GregorianCalendar;

public class CandleBuilder {
	private double abertura = Double.MAX_VALUE;
	private double fechamento = Double.MAX_VALUE;
	private double minimo = Double.MAX_VALUE;
	private double maximo = Double.MAX_VALUE;
	private double volume = Double.MAX_VALUE;
	private GregorianCalendar data = null;

	public CandleBuilder comAbertura(double abertura) {
		this.abertura = abertura;
		return this;
	}

	public CandleBuilder comFechamento(double fechamento) {
		this.fechamento = fechamento;
		return this;
	}

	public CandleBuilder comMinimo(double minimo) {
		this.minimo = minimo;
		return this;
	}

	public CandleBuilder comMaximo(double maximo) {
		this.maximo = maximo;
		return this;
	}

	public CandleBuilder comVolume(double volume) {
		this.volume = volume;
		return this;
	}

	public CandleBuilder comData(GregorianCalendar data) {
		this.data = data;
		return this;
	}

	public Candlestick geraCandle() {

		if (abertura == Double.MAX_VALUE || fechamento == Double.MAX_VALUE || minimo == Double.MAX_VALUE || maximo == Double.MAX_VALUE
				|| volume == Double.MAX_VALUE || data == null)
			throw new IllegalStateException(
					"é necessário preencher todos os valores");

		return new Candlestick(abertura, fechamento, minimo, maximo, volume,
				data);
	}

}
