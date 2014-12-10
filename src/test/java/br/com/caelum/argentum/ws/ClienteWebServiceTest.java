package br.com.caelum.argentum.ws;

import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.caelum.argentum.modelo.Negociacao;

public class ClienteWebServiceTest {

	@Test
	public void testGetNegociacoes() {
		ClienteWebService ws = new ClienteWebService();
		List<Negociacao> negociacoes = new ArrayList<Negociacao>();
		negociacoes = ws.getNegociacoes();
		assertNotEquals(negociacoes.size(), 0);
	}

}
