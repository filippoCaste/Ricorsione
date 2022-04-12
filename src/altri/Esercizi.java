package altri;

public class Esercizi {
	
	String soluzione = "";
	
	protected boolean cercaInteroInArray(int n, int[] array) {
		return this.cercaIntero_ricorsiva(0, n, array);
	}
	
	private boolean cercaIntero_ricorsiva(int livello, int n, int[] array) {
		// caso terminale
		if(array[livello] == n) {
			return true;
		} 
		if(livello >= array.length-1)
			return false;
		
		// caso normale
		return this.cercaIntero_ricorsiva(livello+1, n, array);
	}
	
	protected String concatenaStringhe(String s1, String s2) {
		Concatenazione c = new Concatenazione (s1, s2);
		String parziale = s1;
		this.concatenaStringhe_ricorsiva(s2, parziale);
		// prendo il primo carattere a dx e lo metto a sx
		return soluzione;
	}
	
	private void concatenaStringhe_ricorsiva(String rimanenti, String parziale) {
		// caso terminale
		if(rimanenti.length()==0) {
			soluzione = parziale;
			return;
		}
		// caso normale
		else {
			int i=(rimanenti.length()-1);
			String nuovaParziale = ""+ rimanenti.toCharArray()[i] + parziale ;
			String nuovaRimanenti = rimanenti.substring(0, rimanenti.length()-1);
			this.concatenaStringhe_ricorsiva(nuovaRimanenti, nuovaParziale);
			return;

		}
	}

	public static void main(String[] args) {
		int[] array = {0,3,2,5,3,1,7};
		Esercizi e = new Esercizi();
		System.out.println( e.cercaInteroInArray(9, array) );
		
		// ------------------------------------------------------------------------
		System.out.println( e.concatenaStringhe("aaaa", "bcde") );
		
	}
	
	class Concatenazione {
		String prima;
		String seconda;
		
		Concatenazione(String prima, String seconda) {
			this.prima = prima;
			this.seconda = seconda;
		}
	}

}
