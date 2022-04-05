package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

public class ReginePrimaSoluzione {
	
	List<Integer> soluzione; //tutte le soluzioni
	
	public List<Integer> cercaRegine(int N) { // ritorna la prima soluzione trovata
		this.soluzione = null;
		
		List<Integer> parziale = new ArrayList <Integer> ();
		this.regine_ricorsiva(parziale, 0, N);
		
		return this.soluzione;
	}
	
	private boolean regine_ricorsiva(List<Integer> parziale, int livello, int N) { // il boolean dice se bisogna continuare dopo aver trovato la prima soluzione
		if(livello==N) {
			
//			System.out.println(parziale);
			
			this.soluzione = new ArrayList<>(parziale); // va chiamata per forza la new
			return false; // fermarsi, non continuare
			
		} else {
			
			for(Integer col=0; col<N; col++) { 
				if(this.compatibile(col, parziale, livello)) {
					parziale.add(col); // prova a mettere la regina qui
					boolean continua = this.regine_ricorsiva(parziale, livello+1, N); // prova a vedere se riesci a risolvere
					if(!continua)
						return false;
					parziale.remove(parziale.size()-1); // torniamo all'inizio del tentativo e proseguiamo
				}
				
			}
			return true;
		}
	}
	
	private boolean compatibile(Integer col, List<Integer> parziale, int livello) {
		if(parziale.indexOf(col) != -1) { // se la colonna già non è occupata già da altre regine
			return false;
		}
		
		for(int riga = 0; riga<parziale.size(); riga++) { 
			if((riga+parziale.get(riga)) == (livello+col))
				return false;
			
			if((riga-parziale.get(riga)) == (livello-col))
				return false;
		}
		return true;
	}

}
