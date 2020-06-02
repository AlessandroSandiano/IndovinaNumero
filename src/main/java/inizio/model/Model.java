package inizio.model;

import java.security.InvalidParameterException;

public class Model {
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
				return -1;
			}
			if (nScelto > nEstratto) {
				tRimasti--;
				return 1;
			}
			if (nScelto == nEstratto) {
				tRimasti--;
				return 0;
			}
		}
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
	
}
