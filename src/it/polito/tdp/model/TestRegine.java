package it.polito.tdp.model;

import java.util.List;

public class TestRegine {

	public static void main(String[] args) {
		
		RegineTutte r = new RegineTutte();
		List<List<Integer>> soluzione = r.cercaRegine(4);
		System.out.println(soluzione);
	}

}
