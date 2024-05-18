package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	
	Borsa borsa;
	Attrezzo spada;
	Attrezzo lancia;
	Attrezzo arco;
	Attrezzo lanterna;
	Borsa alfabetica;
	
	@Before
	public void setUp() {
		this.borsa  = new Borsa(10);
		this.spada = new Attrezzo("spada", 5);
		this.lancia = new Attrezzo("lancia", 6);
		this.arco  = new Attrezzo("arco", 4);
		this.lanterna = new Attrezzo("lanterna", 4);
		this.alfabetica = new Borsa(30);
	}
	
	@Test
	public void testAddAttrezzoBorsaVuota() {
		borsa.addAttrezzo(spada);
		assertTrue(this.borsa.hasAttrezzo("spada"));
	}
	
	@Test
	public void testAddAttrezzoBorsaPiena() {
		borsa.addAttrezzo(spada);
		borsa.addAttrezzo(lancia);
		assertEquals(false, this.borsa.hasAttrezzo("lancia"));
	}
	
	@Test
	public void testRemoveAttrezzo() {
		borsa.addAttrezzo(spada);
		borsa.addAttrezzo(arco);
		assertTrue(borsa.hasAttrezzo("arco"));
		borsa.removeAttrezzo("arco");
		assertFalse(borsa.hasAttrezzo("arco"));
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPeso() {
		this.alfabetica.addAttrezzo(spada);
		this.alfabetica.addAttrezzo(arco);
		this.alfabetica.addAttrezzo(lancia);
		
		assertEquals(List.of(arco, spada, lancia), new ArrayList<>(this.alfabetica.getContenutoOrdinatoPerPeso()));
		// da completare
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNome() {
		//assertEquals(List.of(arco, borsa, lancia, spada), this.alfabetica.getContenutoOrdinatoPerNome());
		this.alfabetica.addAttrezzo(spada);
		this.alfabetica.addAttrezzo(arco);
		this.alfabetica.addAttrezzo(lancia);
		
		assertEquals(List.of(arco, lancia, spada),new ArrayList<>(this.alfabetica.getContenutoOrdinatoPerNome()));
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPeso() {
		Set<Attrezzo> att = new HashSet<>();
		att.add(arco);
		att.add(lanterna);
		Map<Integer, Set<Attrezzo>> expected = new HashMap<>();
		expected.put(4, att);
		this.borsa.addAttrezzo(arco);
		this.borsa.addAttrezzo(lanterna);
		assertEquals(expected, this.borsa.getContenutoRaggruppatoPerPeso());
	}
	
	

}