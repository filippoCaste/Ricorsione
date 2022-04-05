package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

public class SerieFibonacci {
	
	List<Integer> soluzione;
	
	public List<Integer> costruisci(int n) {
		this.soluzione = null;
		List<Integer> parziale = new ArrayList<Integer>();
		
		this.costruzione_ricorsiva(parziale, 0, n);
		
		return this.soluzione;
	}
	
	private void costruzione_ricorsiva(List<Integer> parziale, int livello, int n) {
		// caso terminale
		if(livello == n) {
			this.soluzione = new ArrayList<Integer> (parziale);
		}
		// casi iniziali
		else if(livello == 0 || livello == 1) {
			parziale.add(1);
			this.costruzione_ricorsiva(parziale, ++livello, n);
		}
		
		// caso ricorsivo
		else {
			// F(n) = F(n-1) + F(n-2)
			parziale.add(parziale.get(livello-1)+parziale.get(livello-2));
			this.costruzione_ricorsiva(parziale, ++livello, n);
		}
		
	}

	public static void main(String[] args) {
		SerieFibonacci sf = new SerieFibonacci();
		List<Integer> soluzione = sf.costruisci(1500);
		System.out.println(soluzione);
	}

}
