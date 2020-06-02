package inizio.model;

import java.security.InvalidParameterException;
import java.util.*;

public class Model {
	
	Set<Integer> numeriInseriti = new HashSet<>();
	
	private final int tmax=8, nmax=100;
	private int tRimasti, nEstratto, nScelto;
	
	public Model () {
		tRimasti = tmax;
		nEstratto = (int)(Math.random()*nmax) + 1;
	}
	
	public int tentativo () {
		if (tentativoValido() == true) {
			if (nScelto < nEstratto) {
				tRimasti--;
				numeriInseriti.add(Integer.valueOf(nScelto));
				return -1;
			}
			if (nScelto > nEstratto) {
				tRimasti--;
				numeriInseriti.add(Integer.valueOf(nScelto));
				return 1;
			}
			if (nScelto == nEstratto) {
				tRimasti--;
				return 0;
			}
		}
		else
			return 2;
		return 0;
	}
	
	public boolean terminata () {
		if (tRimasti == 0)
			throw new IllegalStateException("Hai perso. Il numero segreto era " + nEstratto + "\nClicca su Nuova Partita per rifarti!\n");
		return false;
	}
	
	public boolean tentativoValido () {
		if (nScelto<1 || nScelto>100)
			throw new InvalidParameterException("Il numero inserito è fuori dall'intervallo 1-" + nmax + "\n");
		if (this.numeriInseriti.contains(Integer.valueOf(nScelto)) == true)
			return false;
		return true;
	}

	public int getTmax() {
		return tmax;
	}

	public int getNmax() {
		return nmax;
	}

	public void setnScelto(int nScelto) {
		this.nScelto = nScelto;
	}

	public int getnScelto() {
		return nScelto;
	}

	public int gettRimasti() {
		return tRimasti;
	}

	public void settRimasti(int tRimasti) {
		this.tRimasti = tRimasti;
	}

	public int getnEstratto() {
		return nEstratto;
	}

	public Set<Integer> getNumeriInseriti() {
		return numeriInseriti;
	}
	
}
