package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendiTest {
	
	private ComandoPrendi prendi;
	private Partita partita;
	private Attrezzo attrezzo;
	private Borsa borsa;
	

	@Before
	public void setUp() {
		this.prendi = new ComandoPrendi();
		this.partita = new Partita(new Labirinto());
		this.attrezzo = new Attrezzo("attrezzo", 2);
		this.borsa = new Borsa();
		
		
	}
	
	@Test
	public void testPrendi() {
		this.partita.getStanzaCorrente().addAttrezzo(attrezzo);
		this.partita.getGiocatore().setBorsa(borsa);
		this.prendi.setParametro("attrezzo");
		this.prendi.esegui(partita);
		assertEquals(true, this.partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo"));
		
	}

}
