package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVaiTest {
	
	private ComandoVai vai;
	private Partita partita;
	private Labirinto labirinto;
	
	@Before
	public void setUp() throws Exception{
		this.vai = new ComandoVai();
		this.labirinto = new Labirinto();
		this.partita = new Partita(this.labirinto);
		vai.setIo(new IOConsole());
	}
	
	@Test
	public void testVaiNull() {
		Stanza stanza = new Stanza("Bagno");
		this.partita.setStanzaCorrente(stanza);
		this.vai.esegui(partita);
		assertEquals(stanza, this.partita.getStanzaCorrente());
		
	}

	@Test
	public void testVai() {
		Stanza stanzaCorrente = new Stanza("Atrio");
		Stanza prossimaStanza = new Stanza("Aula N1");
		stanzaCorrente.impostaStanzaAdiacente("sud", prossimaStanza);
		this.partita.setStanzaCorrente(stanzaCorrente);
		this.vai.setParametro("sud");
		this.vai.esegui(partita);
		assertEquals("Aula N1", this.partita.getStanzaCorrente().getNome());
	}

}
