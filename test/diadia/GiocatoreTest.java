package diadia;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

public class GiocatoreTest {
	
	Giocatore giocatore = new Giocatore();
	
	@Test
	public void testGetCfu() {
		this.giocatore.setCfu(3);
		assertEquals(3, this.giocatore.getCfu());
	}

}
