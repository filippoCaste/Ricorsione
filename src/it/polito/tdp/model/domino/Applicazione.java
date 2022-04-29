package it.polito.tdp.model.domino;

import java.util.List;

public class Applicazione {

	public static void main(String[] args) {
		Domino d = new Domino();
		List<List<Integer>> sol = d.trovaSequenza(6);
		for(List<Integer> li : sol)
			System.out.println(li);
	}

}
 