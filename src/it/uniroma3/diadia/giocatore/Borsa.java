package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa{

	public final static int DEFAULT_PESO_MAX_BORSA = 10; 
	//private Attrezzo[] attrezzi;
	private Map<String, Attrezzo> attrezzi;
	private int pesoMax;
	private int pesoAttuale;
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA); 
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<>(); // speriamo bastino...
		this.pesoAttuale = 0;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		//this.attrezzi[this.numeroAttrezzi] = attrezzo;
		Attrezzo vecchio = this.attrezzi.put(attrezzo.getNome(), attrezzo);
		if(vecchio!=null) this.pesoAttuale -= vecchio.getPeso();
		this.pesoAttuale += attrezzo.getPeso();
		return true;
	}

	public int getPesoMax() {
		return pesoMax;
	}

//	public Attrezzo getAttrezzo(String nomeAttrezzo) {
//		Attrezzo a = null;
//		for (int i= 0; i<this.numeroAttrezzi; i++)
//			if (this.attrezzi[i].getNome().equals(nomeAttrezzo)) a = attrezzi[i];
//		return a; 
//	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}

	public int getPeso() { // peso della borsa
//		for (String chiave: this.attrezzi.keySet())
//			peso += this.attrezzi.get(chiave).getPeso();
		return this.pesoAttuale;
	}

	public boolean isEmpty() {
		//return this.numeroAttrezzi == 0;
		return this.attrezzi.isEmpty();

	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		if(this.hasAttrezzo(nomeAttrezzo)) {
			this.pesoAttuale -= this.getAttrezzo(nomeAttrezzo).getPeso();
			return this.attrezzi.remove(nomeAttrezzo);
		}
		return null;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			//s.append(this.attrezzi.values().toString());
		}
		else 
			s.append("Borsa vuota");
		return s.toString();
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		final List<Attrezzo> daOrdinare = new ArrayList<>();
		daOrdinare.addAll(this.attrezzi.values());
		daOrdinare.sort(new ComparatoreAttrezziPerPeso());
		return daOrdinare;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		SortedSet<Attrezzo> ordinata = new TreeSet<>(this.attrezzi.values());
		return ordinata;
	}
	
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		final Map<Integer, Set<Attrezzo>> peso2attrezzi = new HashMap<Integer, Set<Attrezzo>>();
		for(Attrezzo a: this.attrezzi.values()) {
			if(peso2attrezzi.containsKey(a.getPeso())) {
				peso2attrezzi.get(a.getPeso()).add(a);
			}
			else {
				Set<Attrezzo> altroSet = new HashSet<>();
				altroSet.add(a);
				peso2attrezzi.put(a.getPeso(), altroSet);
			}
		}
		return peso2attrezzi;
	}
	
	public SortedSet<Attrezzo> getSordetSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> daOrdinare = new TreeSet<>(new ComparatoreAttrezziPerPeso());
		daOrdinare.addAll(this.attrezzi.values());
		return daOrdinare;
	}
	
	
}