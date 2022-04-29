package it.polito.tdp.model.domino;

import java.util.ArrayList;
import java.util.List;

public class Domino {
	
	private List<List<Integer>> soluzione;
	private List<List<Integer>> tasselli;
	
	/**
	Consider the game of Domino, composed of two-sided
	pieces: each side is labeled with a number from 0 to {@code N} 
	Each combination of number pairs is represented exactly
	once.
	Find the longest possible sequence of pieces, such that
	consecutive pieces have the same value on the adjacent
	sides.
	 * @param N
	 * @return the list containing a list of integer -- the solution
	 */
	public List<List<Integer>> trovaSequenza(final int N) {
		this.soluzione = new ArrayList<>();
		tasselli = this.creazioneTasselli(N);
		this.calcola_ricorsione(0, soluzione, tasselli, N);
		return this.soluzione;
	}
	
	private List<List<Integer>> creazioneTasselli(int N) {
		List<List<Integer>> res = new ArrayList<>();
		
		for(int i = 0; i<= N; i++) {
			for(int j=i; j<=N; j++) {
				List<Integer> pos = new ArrayList<>();
				pos.add(i);
				pos.add(j);
				res.add(pos);
			}
		}
		return res;
	}
		
								// potrebbe essere lo step
	private void calcola_ricorsione(int livello, List<List<Integer>> parziale, List<List<Integer>> rimanenti, final int N) {
		// condizioni di terminazione
		if(rimanenti.size()==0 || livello == this.tasselli.size()) {
			this.soluzione = parziale; // ed è sicuramente la migliore perché ci sono tutte
			return;
		}
		
		if(livello != 0 && !possibileContinuare(parziale, rimanenti)) {
			return;
		}
			
		// algoritmo ricorsivo
		for(List<Integer> li : rimanenti) {
			if(livello!=0 && !parziale.contains(li) && (parziale.get(parziale.size()-1).get(1)==li.get(0) ||
					parziale.get(parziale.size()-1).get(1)==li.get(1) )) {
				if(parziale.get(parziale.size()-1).get(1)==li.get(1)) {
					List<Integer> newLi = new ArrayList<>();
					newLi.add(li.get(1));
					newLi.add(li.get(0));
					parziale.add(newLi);
				}
				else
					parziale.add(li);
			}
			else if(livello==0) 
				parziale.add(li);
			else
				continue;
			List<List<Integer>> nuovaRimanenti = new ArrayList<>(rimanenti);
			nuovaRimanenti.remove(li);
			this.calcola_ricorsione(++livello, parziale, nuovaRimanenti, N);

//			// backtracking
//			parziale.remove(parziale.size()-1);
//			livello--;
		}
		return;
		
	}
	private boolean possibileContinuare(List<List<Integer>> parziale, List<List<Integer>> rimanenti) {
		List<Integer> ultima = parziale.get(parziale.size()-1);
		for(List<Integer> li : rimanenti) {
			if(li.get(0) == ultima.get(0) || li.get(0)==ultima.get(ultima.size()-1) || li.get(li.size()-1)==ultima.get(0) || li.get(li.size()-1)==ultima.get(ultima.size()-1))
				return true;
		}
		return false;
	}
}
