package diadia;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;

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
