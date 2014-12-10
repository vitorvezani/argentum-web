package br.com.caelum.argentum.reader;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;

import br.com.caelum.argentum.modelo.Negociacao;

public class LeitorXMLTest {

	@Test
	public void carregaXmlComUmaNegociacaoEmListaUnitaria() {
		String xmlDeTeste = "<list>" +
				" <negociacao>" +
				" <preco>43.5</preco>" +
				" <quantidade>1000</quantidade>" +
				" <data>" +
				" <time>1322233344455</time>" +
				" </data>" +
				" </negociacao>" +
				"</list>";
		
		LeitorXML leitor = new LeitorXML();
		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		List<Negociacao> negociacoes = leitor.carrega(xml);
		
		assertEquals(negociacoes.size(), 1);
		assertTrue(negociacoes.get(0).getPreco() == 43.5d);
		assertTrue(negociacoes.get(0).getQuantidade() == 1000);
	}
	
	@Test
	public void carregaXmlComMaisDeUmaNegociacaoEmListaUnitaria() {
		String xmlDeTeste = "<list>" +
				" <negociacao>" +
				" 	<preco>43.5</preco>" +
				" 	<quantidade>1000</quantidade>" +
				" 	<data>" +
				" 		<time>1322233344455</time>" +
				" 	</data>" +
				" </negociacao>" +
				" <negociacao>" +
				" 	<preco>53.5</preco>" +
				" 	<quantidade>100</quantidade>" +
				" 	<data>" +
				" 		<time>1322233344455</time>" +
				"	</data>" +
				" </negociacao>" +
				"</list>";
		
		LeitorXML leitor = new LeitorXML();
		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		List<Negociacao> negociacoes = leitor.carrega(xml);
		
		assertEquals(negociacoes.size(), 2);
		assertTrue(negociacoes.get(0).getPreco() == 43.5d);
		assertTrue(negociacoes.get(0).getQuantidade() == 1000);
		assertTrue(negociacoes.get(1).getPreco() == 53.5d);
		assertTrue(negociacoes.get(1).getQuantidade() == 100);
	}
	
	@Test
	public void carregaXmlComZeroNegociacoesEmListaUnitaria() {
		String xmlDeTeste = "<list>" +
							"</list>";
		
		LeitorXML leitor = new LeitorXML();
		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		List<Negociacao> negociacoes = leitor.carrega(xml);
		
		assertEquals(negociacoes.size(), 0);
	}
	
	@Test
	public void carregaXmlComUmaNegociacaoQtdeFaltandoEmListaUnitaria() {
		String xmlDeTeste = "<list>" +
				" <negociacao>" +
				" <data>" +
				" <time>1322233344455</time>" +
				" </data>" +
				" </negociacao>" +
				"</list>";
		
		LeitorXML leitor = new LeitorXML();
		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		List<Negociacao> negociacoes = leitor.carrega(xml);
		
		assertEquals(negociacoes.size(), 1);
		assertTrue(negociacoes.get(0).getPreco() == 0.0d);
		assertTrue(negociacoes.get(0).getQuantidade() == 0.0d);
	}

}
