package model;

import java.util.Random;
import java.util.concurrent.Semaphore;

import sun.nio.ch.SelChImpl;

/*
 * Numa prova de triatlo moderno, o circuito se dá da seguinte maneira:
- 3Km de corrida onde os atletas correm entre 20 e 25 m / 30 ms
- 3 tiros ao alvo com pontuação de 0 a 10
- 5 km de ciclismo onde os atletas pedalam entre 30 e 40 m/ 40 ms
25 atletas participam da prova e largam juntos, no entanto, apenas 5 armas de tiro estão a
disposição. Cada atleta leva de 0,5 a 3s por tiro. Conforme os atletas finalizam o circuito de
corrida, em ordem de chegada, pegam a arma para fazer os disparos. Uma vez encerrados os
disparos, a arma é liberada para o próximo, e o atleta segue para pegar a bicicleta e continuar
o circuito.
Para determinar o ranking final dos atletas, considera-se a seguinte regra:
- O primeiro que chegar recebe 250 pontos, o segundo recebe 240, o terceiro recebe
230, ... , o último recebe 10.
- Soma-se à pontuação de cada atleta, o total de pontos obtidos nos 3 tiros (somados)
Ordenar a pontuação e exibir o resultado final do maior pontuador para o menor.
 */

public class Corrida extends Thread implements Comparable<Corrida>{

	private String nome;
	private Semaphore controle;
	private Semaphore controlePosicao;
	private Random num;

	private int pontos;
	private static int posicao;
	
	

	public Corrida(String nome, Semaphore controle, Semaphore controlePosicao) {
		super();
		this.nome = nome;
		this.controle = controle;
		this.controlePosicao = controlePosicao;
		num = new Random();
		start();
	}
	
	
	public int getPontos() {
		return pontos;
	}
	public String getNome() {
		return nome;
	}

	private void correr() {
		
		int distCorrida = 3000;

		try {

			System.out.println(nome + " iniciou a corrida\n");

			while (distCorrida > 0) {

				distCorrida -= num.nextInt(15) + 20;

				sleep(30);

				//System.out.println(nome + " falta " + distCorrida + "m \n");
			}

			sleep(100);
			System.err.println(nome + " finaizou a corrida\n");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private void ciclismo() {
		
		int distCorrida = 5000;
		
		try {
			
			System.out.println(nome + " iniciou o ciclismo\n");
			
			while (distCorrida > 0) {
				
				distCorrida -= num.nextInt(10) + 30;
				
				sleep(40);
				
				//System.out.println(nome + " falta " + distCorrida + "m \n");
			}
			
			sleep(100);
			System.err.println(nome + " finaizou o ciclismo\n");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void tiro() {

		try {

			int pTiro;

			System.out.println(nome + " iniciou o TIRO\n");

			for (int i = 0; i < 3; i++) {

				pTiro = num.nextInt(11);
				sleep(num.nextInt(2500) + 500);
				System.out.println(nome + " "+ (i + 1) + "- tiro " + pTiro + " pontos\n");
				pontos += pTiro;

			}
			
			sleep(100);
			System.err.println(nome + " finalizando TIROS\n");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void finalizarCorrida() {
		posicao ++;
		
		switch (posicao) {
		case 1:
			pontos += 250;
			break;
		case 2:
			pontos += 240;
			break;
		case 3:
			pontos += 230;
			break;
		case 4:
			pontos += 220;
			break;
		case 5:
			pontos += 210;
			break;
		case 6:
			pontos += 200;
			break;
		case 7:
			pontos += 190;
			break;
		case 8:
			pontos += 180;
			break;
		case 9:
			pontos += 170;
			break;
		case 10:
			pontos += 160;
			break;
		case 11:
			pontos += 150;
			break;
		case 12:
			pontos += 140;
			break;
		case 13:
			pontos += 130;
			break;
		case 14:
			pontos += 120;
			break;
		case 15:
			pontos += 110;
			break;
		case 16:
			pontos += 100;
			break;
		case 17:
			pontos += 90;
			break;
		case 18:
			pontos += 80;
			break;
		case 19:
			pontos += 70;
			break;
		case 20:
			pontos += 60;
			break;
		case 21:
			pontos += 50;
			break;
		case 22:
			pontos += 40;
			break;
		case 23:
			pontos += 30;
			break;
		case 24:
			pontos += 20;
			break;
		case 25:
			pontos += 10;
			break;

		default:
			break;
		}
		
	}
	
	public int iniciar() {
		run();
		return pontos;
	}
	

	@Override
	public void run() {
		
		
		try {
			correr();
			controle.acquire();
			tiro();
			controle.release();
			ciclismo();
			controlePosicao.acquire();
			finalizarCorrida();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			controle.release();
			controlePosicao.release();
		}
		
		super.run();
	}


	


	@Override
	public int compareTo(Corrida o) {
		if (this.pontos > o.getPontos()) { 
			  return -1; 
			  } if (this.pontos < o.getPontos()) { 
			  return 1; 
			  } 
			  return 0;
	}



}
