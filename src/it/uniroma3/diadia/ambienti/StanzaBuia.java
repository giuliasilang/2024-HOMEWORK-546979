package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{

	private String attrezzoLucente;
	
	public StanzaBuia(String nome, String attrezzoLucente) {
		super(nome);
		this.attrezzoLucente = attrezzoLucente;
	}
	
	public String getDescrizione() {
		String buio = new String();
		if(!this.hasAttrezzo(attrezzoLucente)) {
			buio = "Qui c'è un buio pesto";
			return buio;
		}
		return super.getDescrizione();

	}
}
