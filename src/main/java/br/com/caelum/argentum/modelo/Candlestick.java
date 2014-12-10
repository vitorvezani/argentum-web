package br.com.caelum.argentum.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class Candlestick {

	private final double abertura;
	private final double fechamento;
	private final double minimo;
	private final double maximo;
	private final double volume;
	private final Calendar data;

	public Candlestick(double abertura, double fechamento, double minimo,
			double maximo, double volume, Calendar data) {
		
		if (minimo > maximo)
			throw new IllegalArgumentException(String.format("o valor minimo(%f) não pode ser maior que o maximo(%f)", minimo, maximo));
		
		if (data == null)
			throw new IllegalArgumentException("data nao pode ser nula");
		
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.minimo = minimo;
		this.maximo = maximo;
		this.volume = volume;
		this.data = data;
	}

	public double getAbertura() {
		return abertura;
	}

	public double getFechamento() {
		return fechamento;
	}

	public double getMinimo() {
		return minimo;
	}

	public double getMaximo() {
		return maximo;
	}

	public double getVolume() {
		return volume;
	}

	public Calendar getData() {
		return data;
	}

	public boolean isAlta() {
		return this.abertura <= this.fechamento;
	}

	public boolean isBaixa() {
		return this.abertura > this.fechamento;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String string = String
				.format("[Abertura %.1f, Fechamento %.1f, Minima %.1f, Maxima %.1f, Volume %.2f, Data ",
						this.abertura, this.fechamento, this.minimo, this.maximo, this.volume);
		return string + sdf.format(this.data.getTime()) + "]";
	}
}
