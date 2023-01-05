package dojo3_ex3;

import java.time.LocalDate;
import java.util.ArrayList;

public class Biblioteca {

	private ArrayList<Livro> livros = new ArrayList<>();
	private ArrayList<Cliente> clientes = new ArrayList<>();
	private ArrayList<Aluguel> alugueis = new ArrayList<>();
	
	public ArrayList<Livro> getLivros() {
		return this.livros;
	}
	
	public ArrayList<Cliente> getClientes() {
		return this.clientes;
	}
	
	public boolean cadastrarLivro(Livro livro) {
		if(livros.size() < 1000) {
			livros.add(livro);
			return true;
		}
		
		return false;
	}
	
	public ArrayList<Aluguel> getAlugueis() {
		return alugueis;
	}

	public void setAlugueis(ArrayList<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}

	public boolean removerLivro(Livro livro) {
		return livros.remove(livro);
	}
	
	public boolean cadastrarCliente(Cliente cliente) {
		return clientes.add(cliente);
	}
	
	public boolean removerCliente(Cliente cliente) {
		return clientes.remove(cliente);
	}
	
	public Aluguel alugarLivro(Cliente cliente, ArrayList<Livro> livros) {
		ArrayList<Livro> livrosCliente = cliente.getUltimosLivros();
		ArrayList<Livro> novosLivros = new ArrayList<>();

		if(livrosCliente.size() == 0) {
			return new Aluguel(cliente, livros, LocalDate.now());
		} else {
			Livro livroAnterior = cliente.getUltimosLivros().get(cliente.getUltimosLivros().size() - 1);
			novosLivros.add(livroAnterior);
			for(Livro livroAlugado : livros) {
				for(Livro livro : livrosCliente) {
					if(this.getLivros().contains(livroAlugado)) {
						if(livroAlugado.getTitulo().equals(livro.getTitulo())) {
							return null;
						} else {
							removerLivro(livroAlugado);
							novosLivros.add(livroAlugado);
						}
					} else {
						return null;
					}
				}
			}
			
			cliente.setUltimosLivros(novosLivros);
			Aluguel novoAluguel = new Aluguel(cliente, livros, LocalDate.now());
			this.alugueis.add(novoAluguel);
			return novoAluguel;
		}
		
	}
	
	public boolean devolverLivro(Cliente cliente, ArrayList<Livro> livros) {
		for(Livro livroAlugado: livros) {
			if(!this.livros.contains(livroAlugado)) {
				cadastrarLivro(livroAlugado);
			} else {
				return false;
			}
		}
		
		return true;
	}
	
	public ArrayList<Aluguel> relatorioAlugueis(LocalDate min, LocalDate max, Livro livro) {
		ArrayList<Aluguel> relatorio = new ArrayList<>();
		for(Aluguel aluguel : this.alugueis) {
			if(aluguel.getDataAluguel().isAfter(min) && aluguel.getDataAluguel().isBefore(max)) {
				for(Livro livroAluguel: aluguel.getLivros()) {
					if(livroAluguel.getTitulo().equals(livro.getTitulo())) {
						relatorio.add(aluguel);
					}
				}

			}
		}
		
		return relatorio;
	}
	
	public ArrayList<Aluguel> relatorioAlugueis(Cliente cliente) {
		ArrayList<Aluguel> relatorio = new ArrayList<>();
		for(Aluguel aluguel : this.alugueis) {
			if(aluguel.getCliente().getCpf().equals(cliente.getCpf())) {
				relatorio.add(aluguel);
			}
		}
		
		return relatorio;
	}
}
