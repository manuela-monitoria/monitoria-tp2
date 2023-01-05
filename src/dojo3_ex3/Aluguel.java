package dojo3_ex3;

import java.time.LocalDate;
import java.util.ArrayList;

public class Aluguel {

	private Cliente cliente;
	private ArrayList<Livro> livros;
	private LocalDate dataAluguel;
	
	public Aluguel(Cliente cliente, ArrayList<Livro> livros, LocalDate dataAluguel) {
		this.cliente = cliente;
		this.livros = livros;
		this.dataAluguel = dataAluguel;
	}

	public LocalDate getDataAluguel() {
		return dataAluguel;
	}

	public void setDataAluguel(LocalDate dataAluguel) {
		this.dataAluguel = dataAluguel;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Livro> getLivros() {
		return livros;
	}

	public void setLivros(ArrayList<Livro> livros) {
		this.livros = livros;
	}

}
