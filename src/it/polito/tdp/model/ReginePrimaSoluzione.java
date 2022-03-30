package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

public class ReginePrimaSoluzione {
	
	List<List<Integer>> tutte; //tutte le soluzioni
	
	public List<List<Integer>> cercaRegine(int N) { //ritorna una lista di soluzioni complete
		this.tutte = new ArrayList<List<Integer>>();
		
		List<Integer> parziale = new ArrayList <Integer> ();
		this.regine_ricorsiva(parziale, 0, N);
		
		return this.tutte;
	}
	
	private void regine_ricorsiva(List<Integer> parziale, int livello, int N) {
		if(livello==N) {
			// caso terminale -- si è trovata la soluzione completa 
			// livello = N : già sono state riempite le N righe visto che si parte da zero
			
//			System.out.println(parziale);
			
			this.tutte.add(new ArrayList<Integer> (parziale)); // va chiamata per forza la new
			
		} else {
			// caso normale: si riceve una soluzione parziale (da zero a livello-1) già deciso
			// va decisa la soluzione parziale di livello tra tutti i valori possibili da zero a N-1
			// purché compatibili
			
			for(Integer col=0; col<N; col++) { // si prova dentro tutte le colonne
				// if(colonna compatibile con la soluzione parziale -- con le regine già posizionate) 
				// qui algoritmo di ricorsione
				
				if(this.compatibile(col, parziale, livello)) {
					parziale.add(col); // prova a mettere la regina qui
					this.regine_ricorsiva(parziale, livello+1, N); // prova a vedere se riesci a risolvere
					/* PROCEDURA DI BACKTRACKING */
					parziale.remove(parziale.size()-1); // torniamo all'inizio del tentativo e proseguiamo
				}
				
			}
		}
	}
	
	private boolean compatibile(Integer col, List<Integer> parziale, int livello) {
		if(parziale.indexOf(col) != -1) { // se la colonna già non è occupata già da altre regine
			return false;
		}
		
		for(int riga = 0; riga<parziale.size(); riga++) { // ogni riga dice che c'è una regina alle coordinate
														  // (riga, parziale.get(riga)) 
														  // confrontare con (livello, col)
			
			if((riga+parziale.get(riga)) == (livello+col))
				return false;
			
			if((riga-parziale.get(riga)) == (livello-col))
				return false;
		}
		return true;
	}

}
