package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	
	private IO io;
	private String nomeAttrezzo;
	private final static String NOME = "posa";

	@Override
	public void esegui(Partita partita) {
		Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if(attrezzo == null) {
			io.mostraMessaggio("Quale attrezzo vuoi prendere?");
		}
		else if(partita.getStanzaCorrente().getNumeroAttrezziPossibili()>0) {
			partita.getStanzaCorrente().addAttrezzo(attrezzo);
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		}
		else 
			io.mostraMessaggio("Non c'è spazio nella stanza");
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

	@Override
	public String getNome() {
		return NOME;
	}

	@Override
	public void setIo(IO io) {
		this.io = io;
	}

}
