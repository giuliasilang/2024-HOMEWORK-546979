package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {
	
	private IO io;
	public final static String MESSAGGIO_FINE = "Grazie di aver giocato!";
	private final static String NOME = "fine";

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		partita.setFinita();
		io.mostraMessaggio(MESSAGGIO_FINE);  // si desidera smettere
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
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
