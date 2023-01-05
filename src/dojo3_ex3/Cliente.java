package dojo3_ex3;

import java.util.ArrayList;

public class Cliente {

	private String nome;
	private String cpf;
	private ArrayList<Livro> ultimosLivros = new ArrayList<>();
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public ArrayList<Livro> getUltimosLivros() {
		return ultimosLivros;
	}

	public void setUltimosLivros(ArrayList<Livro> ultimosLivros) {
		this.ultimosLivros = ultimosLivros;
	}	

}
