package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {
	
	private String direzioneBloccata;
	private String attrezzoSblocca;
	
	public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoSblocca) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.attrezzoSblocca = attrezzoSblocca;
		
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
        if(direzioneBloccata.equals(direzione) && !this.hasAttrezzo(attrezzoSblocca)) {
        	return this;
        }
        else
        	return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		String bloccata = "Stanza bloccata nella direzione " + this.direzioneBloccata + "\n prendi l'attrezzo sbloccante"
				 + this.attrezzoSblocca + " e posalo nella stanza";
		if(!this.hasAttrezzo(attrezzoSblocca)) return bloccata;
		return super.getDescrizione();
	}
	
	
}

	
