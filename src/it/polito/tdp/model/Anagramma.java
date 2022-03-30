package it.polito.tdp.model;

public class Anagramma {
	
	/**
	 * Riceve una stringa e stampa tutti i suoi anagrammi
	 * @param s
	 */
	public void anagramma(String s) {
		this.anagrammaRicorsiva("", 0, s); // livello iniziale
	}
	
	/**
	 * Data una soluzione parziale, stampa TUTTI gli anagrammi che iniziano in quel modo
	 * @param parziale Soluzione parziale iniziale dell'anagramma. Avrà 'livello' caratteri.
	 * @param livello Livello della ricorsione. Si parte dal livello {@code 0}
	 * @param rimanenti I caratteri da sistemare
	 */
	private void anagrammaRicorsiva(String parziale, int livello, String rimanenti) {
		if(rimanenti.length() == 0) { 
			
// caso terminale (semplice) -- quando 'rimanenti' è vuota
			System.out.println(parziale); // FINE
			
		} else {
			
// caso normale (intermedio)
			// es. parziale="AC", livello=2, rimanenti="BD"
			
			for(int pos=0; pos<rimanenti.length(); pos++) {
				String nuovaParziale = parziale+rimanenti.charAt(pos);
				String nuovaRimanenti = rimanenti.substring(0,pos)+rimanenti.substring(pos+1);
				this.anagrammaRicorsiva(nuovaParziale, livello+1, nuovaRimanenti);
			}
			
		}
	}
	
	public static void main(String[] args) {
		Anagramma main = new Anagramma();
		main.anagramma("abcd"); // Debug con step Into e step Over per seguire tutti i passi
	}

}
