package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosaTest {
	
	private ComandoPosa posa = new ComandoPosa();
	private Partita partita;
	private Attrezzo attrezzo;
	private Stanza stanza;
	private Borsa borsa;
	
	@Before
	public void setUp() throws Exception{
		this.partita = new Partita(new Labirinto());
		this.attrezzo = new Attrezzo("attrezzo", 2);
		this.stanza = new Stanza("Aula");
		this.borsa = new Borsa();
	}

	@Test
	public void testPosa() {
		partita.setStanzaCorrente(stanza);
		partita.getGiocatore().setBorsa(borsa);
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		posa.setParametro("attrezzo");
		posa.esegui(partita);
		assertEquals(true, partita.getStanzaCorrente().hasAttrezzo("attrezzo"));
	}

}
