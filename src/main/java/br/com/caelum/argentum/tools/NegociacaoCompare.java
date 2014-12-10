package br.com.caelum.argentum.tools;

import java.util.Comparator;

import br.com.caelum.argentum.modelo.Negociacao;

public class NegociacaoCompare implements Comparator<Negociacao>{

	@Override
	public int compare(Negociacao o1, Negociacao o2) {
		return o1.getData().compareTo(o2.getData());
	}

}
