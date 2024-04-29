package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LabirintoTest {

	Labirinto labirinto = new Labirinto();
	
	@Test
	public void testGetStanzaIniziale() {
		assertEquals("Atrio", this.labirinto.getStanzaIniziale().getNome());
	}
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", this.labirinto.getStanzaVincente().getNome());
	}

}
