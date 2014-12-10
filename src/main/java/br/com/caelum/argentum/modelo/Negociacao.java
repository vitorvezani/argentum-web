package br.com.caelum.argentum.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class Negociacao {

	private final double preco;
	private final int quantidade;
	private final Calendar data;

	public Negociacao(double preco, int quantidade, Calendar data) {

		if (data == null)
			throw new IllegalArgumentException("data nao pode ser nula");

		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}

	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Calendar getData() {
		return (Calendar) data.clone();
	}

	public double getVolume() {
		return preco * quantidade;
	}

	public boolean isMesmoDia(Calendar mesmoMomento) {
		return this.data.get(Calendar.DAY_OF_MONTH) == mesmoMomento.get(Calendar.DAY_OF_MONTH)
				&& this.data.get(Calendar.MONTH) == mesmoMomento.get(Calendar.MONTH)
				&& this.data.get(Calendar.YEAR) == mesmoMomento.get(Calendar.YEAR);
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String string = String
				.format("[Pre�o %.2f, Quantidade %d, Data ",
						this.preco, this.quantidade);
		return string + sdf.format(this.data.getTime()) + "]";
	}
}
