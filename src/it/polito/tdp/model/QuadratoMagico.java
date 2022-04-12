package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

public class QuadratoMagico {
	
	private int sommaCorretta;
	private int N;
	private int N2; // calcolati una volta per tutte e accessibile da chiunque. Meglio calcolarlo una volta
					// che calcolarselo ogni volta ad ogni ricorsione
	
	public void risolviQuadrato(int N) {
		this.N = N;
		this.N2 = N*N;
		this.sommaCorretta = N2*(N2+1)/(2*N);
		
		List<Integer> parziale = new ArrayList<>();
		this.cerca(parziale, 0);
	}
	
	private void cerca(List<Integer> parziale, int livello) {
		// caso terminale
		if(livello == this.N2) {
			if(controllaSomme(parziale)) {
				System.out.println(parziale);
			} 
		}
		// caso normale
		else {
			if(livello % this.N == 0 & livello!=0) { // se si è completata una riga, si può vedere subito se va bene oppure va cambiata
				if(!controllaRiga(livello / this.N - 1, parziale))
					return;
			}
			for(int i=1; i <= this.N2; i++) {
				if(!parziale.contains(i)) { // parziale.contains(i) il contains ha forte impatto sull'efficienza dell'algoritmo
					parziale.add(i);		// un miglioramento della soluzione si avrebbe con un'altra struttura dati contenente i numeri non ancora inseriti
					cerca(parziale, livello+1);
					// backtracking
					parziale.remove(parziale.size()-1);
				}
			}
		}
	}

	private boolean controllaRiga(int riga, List<Integer> parziale) {
		int sum = 0;
		for(int col=0; col<this.N; col++) {
			sum += parziale.get(riga*N+col);
		}
		if(sum!=this.sommaCorretta)
			return false;
		else
			return true;
	}

	private boolean controllaSomme(List<Integer> parziale) {
		// controlla somma per riga
		for(int riga=0; riga<this.N; riga++) {
			int sum = 0;
			for(int col=0; col<this.N; col++) {
				sum += parziale.get(riga*N+col); // riga*N mi riporta all'elemento della lista della riga corrispondente
			}
			if(sum!=this.sommaCorretta)
				return false;
		}
		
		// controlla somma per colonna
		for(int col=0; col<this.N; col++) {
			int sum = 0;
			for(int riga=0; riga<this.N; riga++) {
				sum += parziale.get(riga*N+col); // riga*N mi riporta all'elemento della lista della riga corrispondente
			}
			if(sum!=this.sommaCorretta)
				return false;
		}
		
		// controllo diagonale
		int sum = 0;
		for(int riga=0; riga<this.N; riga++) {
			sum += parziale.get(riga*this.N + riga);
		}
		if(sum!=this.sommaCorretta)
			return false;
		
		sum = 0;
		for(int riga=0; riga<this.N; riga++) {
			sum += parziale.get(riga*this.N + (this.N-1-riga));
		}
		if(sum!=this.sommaCorretta)
			return false;
		
		return true;
	}

}
