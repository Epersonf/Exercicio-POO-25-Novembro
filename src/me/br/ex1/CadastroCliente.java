package me.br.ex1;

import me.br.ex1.exceptions.ClienteInexistenteException;
import me.br.ex1.exceptions.ClienteJaExistenteException;
import me.br.ex1.exceptions.DadoInvalidoException;
import me.br.ex1.exceptions.RepositorioException;

public class CadastroCliente {
	static int max_size = 10;
	private static Cliente[] clientes = new Cliente[max_size];
	
	public static void main(String[] args) throws RepositorioException, ClienteJaExistenteException, DadoInvalidoException, ClienteInexistenteException {
		inserir(new Cliente("22", "Nome", "Nome@id.uff.br", null));
		inserir(new Cliente("23", "Nome", "Nome@id.uff.br", null));
		
		//erro
		inserir(new Cliente("23", "Nome", "Nomed.uff.br", null));
		
		//erro
		System.out.println(buscar("24").getCpf());
		
		//erro
		inserir(new Cliente("23", "Nome", "Nome@id.uff.br", null));
	}
	
	public static void inserir(Cliente c) throws RepositorioException, ClienteJaExistenteException {
		for (int i = 0; i < max_size; i++) {
			if (clientes[i] != null) {
				if (clientes[i].getCpf().equals(c.getCpf())) throw new ClienteJaExistenteException("Cliente ja existente!");
				continue;
			}
			clientes[i] = c;
			return;
		}
		throw new RepositorioException("Nao eh possivel adicionar mais clientes.");
	}
	
	public static Cliente buscar(String cpf) throws ClienteInexistenteException {
		for (int i = 0; i < max_size; i++) {
			if (clientes[i] == null) break;
			if (!clientes[i].getCpf().equalsIgnoreCase(cpf)) continue;
			return clientes[i];
		}
		throw new ClienteInexistenteException("Cliente requisitado nao existe.");
	}
}
