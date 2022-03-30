package it.polito.tdp.model;

import java.util.List;

public class TestRegine {

	public static void main(String[] args) {
		
		Regine r = new Regine();
		List<Integer> soluzione = r.cercaRegine(15);
		System.out.println(soluzione);
	}

}
