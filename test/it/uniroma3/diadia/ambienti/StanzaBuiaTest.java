package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	
	private StanzaBuia buia;
	private Stanza stanza;
	private String luce;
	private Attrezzo attrezzo;

	@Before
	public void setUp() throws Exception {
		this.luce = "torcia";
		this.attrezzo = new Attrezzo(this.luce, 2);
		this.stanza = new Stanza(new String("Aula"));
		this.stanza.addAttrezzo(attrezzo);
		this.buia = new StanzaBuia(stanza.getNome(), luce);
		this.buia.addAttrezzo(attrezzo);
	}

	@Test
	public void testDescrizione() {
		assertEquals(this.stanza.toString(), this.buia.getDescrizione());
	}

}
