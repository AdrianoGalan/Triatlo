package model;

public class ControleVencedor implements Comparable {

	private String nome;
	private int pontos;

	public ControleVencedor(String nome, int pontos) {
		super();
		this.nome = nome;
		this.pontos = pontos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	@Override
	public String toString() {
		return "nome=" + nome + ", pontos=" + pontos ;
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
