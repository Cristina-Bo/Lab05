package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.AnagrammiDAO;

public class AnagrammiModel {
	
	AnagrammiDAO anagrammaDAO = new AnagrammiDAO();
	
	//interfaccia pubblica alla ricorsione dove mettere l'inizializzazione

	public Set<String> calcolaAnagramma(String intera) {
		Set<String> anagrammi = new HashSet<String>();
		
		
		String parziale ="";
		calcola(parziale, intera, 0, anagrammi);
		
		
		return anagrammi;
	}
	
	public boolean isCorrect(String anagramma){
		return anagrammaDAO.isCorrect(anagramma);
	}

	private void calcola(String parziale, String intera, int livello, Set<String> anagrammi) {
	
		// condizione di terminazione
		if(livello == intera.length()) {
			anagrammi.add(parziale);
			return;
			
		}
		
		//
		for(int i=0; i<intera.length(); i++) {
			
			//generare una soluzione
			parziale+=intera.charAt(i);
			
			//filtro
			if(conta(parziale, intera.charAt(i))<=conta(intera, intera.charAt(i))) {
				calcola(parziale, intera, livello+1, anagrammi);
			}
			
			//backtrack
			parziale = parziale.substring(0, parziale.length()-1);
			
			
		}
		
		
		
		
		
	}

	private static int conta(String string, char c) {
		int count = 0;
		for(int i= 0; i<string.length(); i++) {
			if(string.charAt(i)==c) {
				count++;
			}
		}
		
		return count;
	}
	
	

}
