package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

	Labirinto labirinto = new Labirinto();
	Partita partita = new Partita(this.labirinto);
	Stanza stanza = new Stanza("Stanza");
	Stanza stanzaCorrente = new Stanza("Atrio");
	Stanza stanzaAdiacente = new Stanza("Aula N11");
	
	@Test
	public void testGetAttrezzo() {
		Stanza vuota = new Stanza("vuota");
		assertNull(vuota.getAttrezzo("inesistente"));
	}
	
	@Test
	public void testGetStanzaAdiacente() {
		assertNull(stanzaCorrente.getStanzaAdiacente("nord"));
	}

	@Test
	public void testImpostaStanzaAdiacente() {
		stanzaCorrente.impostaStanzaAdiacente("est", stanzaAdiacente);
		assertTrue(stanzaCorrente.getStanzaAdiacente("est").equals(stanzaAdiacente));
	}
	
	@Test
	public void testHasAttrezzo() {
		Attrezzo attrezzo = new Attrezzo("spada",10);
		this.stanza.addAttrezzo(attrezzo);
		assertEquals(true, this.stanza.hasAttrezzo("spada"));
		
	}

}
