package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
	
	private StanzaBloccata blocked;
	private Stanza stanza;
	private Attrezzo attrezzoSblocca;
	
	

	@Before
	public void setUp() throws Exception {
		this.blocked = new StanzaBloccata("Atrio", "sud", "chiave");
		this.stanza = new Stanza("Aula");
		this.attrezzoSblocca = new Attrezzo("chiave", 1);
		this.blocked.impostaStanzaAdiacente("sud", stanza);
		
	}

	@Test
	public void testBloccata() {
		this.blocked.addAttrezzo(attrezzoSblocca);
		assertEquals(this.stanza, this.blocked.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testGetDescrizione() {
		this.blocked.addAttrezzo(attrezzoSblocca);
		assertEquals(this.blocked.toString(), this.blocked.getDescrizione());
	}

}
