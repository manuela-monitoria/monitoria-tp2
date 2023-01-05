package dojo3_ex3;

public class Main {

	public static void main(String[] args) {

		Biblioteca biblio = new Biblioteca();
		Cliente cliente = new Cliente();
		cliente.setNome("Manuela");
		cliente.setCpf("999999");
		
		biblio.cadastrarCliente(cliente);
		biblio.removerCliente(cliente);
	}

}
