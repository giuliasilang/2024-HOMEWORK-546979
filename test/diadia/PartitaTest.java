package diadia;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {

	Partita partita = new Partita(new Labirinto());
	Stanza stanza = new Stanza("Stanza");
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", this.partita.getLabirinto().getStanzaVincente().getNome());
	}
	
	@Test
	public void testSetStanzaCorrente() {
		Stanza stanzaCorrente = new Stanza("Atrio");
		Stanza altraStanza = new Stanza("Aula N11");
		
		partita.setStanzaCorrente(altraStanza);
		assertTrue(partita.getStanzaCorrente().equals(altraStanza));
		
		partita.setStanzaCorrente(stanzaCorrente);
		assertTrue(partita.getStanzaCorrente().equals(stanzaCorrente));
	}
	
	@Test
	public void testIsFinita() {
		assertTrue(!partita.isFinita());
	}

}
