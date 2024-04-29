package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FabbricaDiComandiFisarmonicaTest {

	private ComandoVai vai;
	private ComandoPosa posa;
	private ComandoPrendi prendi;
	
	@Before
	public void setUp() {
		this.vai = new ComandoVai();
		this.posa = new ComandoPosa();
		this.prendi = new ComandoPrendi();
		
	}
	
	@Test
	public void testComandoVai() {
		this.vai.setParametro("nord");
		String comando = this.vai.getNome() + " " + this.vai.getParametro();
		assertEquals("vai nord", comando);
	}
	
	@Test
	public void testComandoPosa() {
		this.posa.setParametro("spada");
		String comando = this.posa.getNome() + " " + this.posa.getParametro();
		assertEquals("posa spada", comando);
	}
	
	@Test
	public void testComandoPrendi() {
		this.prendi.setParametro("spada");
		String comando = this.prendi.getNome() + " " + this.prendi.getParametro();
		assertEquals("prendi spada", comando);
	}

}
