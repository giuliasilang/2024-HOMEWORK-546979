package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GiocatoreTest {
	
	Giocatore giocatore = new Giocatore();
	
	@Test
	public void testGetCfu() {
		this.giocatore.setCfu(3);
		assertEquals(3, this.giocatore.getCfu());
	}

}
