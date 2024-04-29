package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	
	Borsa borsa = new Borsa(10);
	Attrezzo spada = new Attrezzo("spada", 5);
	Attrezzo lancia = new Attrezzo("lancia", 6);
	Attrezzo arco = new Attrezzo("arco", 4);
	
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

}