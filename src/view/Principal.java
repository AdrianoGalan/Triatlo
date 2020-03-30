package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Semaphore;

import model.ControleVencedor;
import model.Corrida;

public class Principal {

	public static void main(String[] args) {
	
		Semaphore controlePosicao = new Semaphore(1);
		Semaphore controle = new Semaphore(5);
		ArrayList<Corrida> cv = new ArrayList<Corrida>();
		
		
			Corrida c1 = new Corrida("#1", controle, controlePosicao);
			Corrida c2 = new Corrida("#2", controle, controlePosicao);
			Corrida c3 = new Corrida("#3", controle, controlePosicao);
			Corrida c4 = new Corrida("#4", controle, controlePosicao);
			Corrida c5 = new Corrida("#5", controle, controlePosicao);
			Corrida c6 = new Corrida("#6", controle, controlePosicao);
			Corrida c7 = new Corrida("#7", controle, controlePosicao);
			Corrida c8 = new Corrida("#8", controle, controlePosicao);
			Corrida c9 = new Corrida("#9", controle, controlePosicao);
			Corrida c10 = new Corrida("#10", controle, controlePosicao);
			Corrida c11 = new Corrida("#11", controle, controlePosicao);
			Corrida c12 = new Corrida("#12", controle, controlePosicao);
			Corrida c13 = new Corrida("#13", controle, controlePosicao);
			Corrida c14 = new Corrida("#14", controle, controlePosicao);
			Corrida c15 = new Corrida("#15", controle, controlePosicao);
			Corrida c16 = new Corrida("#16", controle, controlePosicao);
			Corrida c17 = new Corrida("#17", controle, controlePosicao);
			Corrida c18 = new Corrida("#18", controle, controlePosicao);
			Corrida c19 = new Corrida("#19", controle, controlePosicao);
			Corrida c20 = new Corrida("#20", controle, controlePosicao);
			Corrida c21 = new Corrida("#21", controle, controlePosicao);
			Corrida c22 = new Corrida("#22", controle, controlePosicao);
			Corrida c23 = new Corrida("#23", controle, controlePosicao);
			Corrida c24 = new Corrida("#24", controle, controlePosicao);
			Corrida c25 = new Corrida("#25", controle, controlePosicao);
		
		try {
			c1.join();
			c2.join();
			c3.join();
			c4.join();
			c5.join();
			c6.join();
			c7.join();
			c8.join();
			c9.join();
			c10.join();
			c11.join();
			c12.join();
			c13.join();
			c14.join();
			c15.join();
			c16.join();
			c17.join();
			c18.join();
			c19.join();
			c20.join();
			c21.join();
			c22.join();
			c23.join();
			c24.join();
			c25.join();
		
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		cv.add(c1);
		cv.add(c2);
		cv.add(c3);
		cv.add(c4);
		cv.add(c5);
		cv.add(c6);
		cv.add(c7);
		cv.add(c8);
		cv.add(c9);
		cv.add(c10);
		cv.add(c11);
		cv.add(c12);
		cv.add(c13);
		cv.add(c14);
		cv.add(c15);
		cv.add(c16);
		cv.add(c17);
		cv.add(c18);
		cv.add(c19);
		cv.add(c20);
		cv.add(c21);
		cv.add(c22);
		cv.add(c23);
		cv.add(c24);
		cv.add(c25);
		
	
		
		Collections.sort(cv);
		
		for (int w2 = 0; w2 < cv.size(); w2++) {
			
			System.out.println((w2+1) + " " + cv.get(w2).getNome()+ " com " + cv.get(w2).getPontos() + " Pontos" );
			
		}
		

	}

}
