package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	
	private IO io;
	private String nomeAttrezzo;
	private final static String NOME = "prendi";

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		Attrezzo attrezzo = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(attrezzo == null) {
			io.mostraMessaggio("Quale attrezzo vuoi prendere?");
		}
		else {
			partita.getStanzaCorrente().removeAttrezzo(attrezzo);
			partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		}
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.nomeAttrezzo = parametro;

	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.nomeAttrezzo;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return NOME;
	}

	@Override
	public void setIo(IO io) {
		// TODO Auto-generated method stub
		this.io = io;
	}

}
