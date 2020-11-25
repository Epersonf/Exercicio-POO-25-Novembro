package me.br.ex1;

import java.io.IOException;
import java.util.ArrayList;

import me.br.ex1.exceptions.ClienteInexistenteException;
import me.br.ex1.exceptions.ClienteJaExistenteException;
import me.br.ex1.exceptions.DadoInvalidoException;
import me.br.ex1.exceptions.RepositorioException;

public class CadastroCliente {	
	public static void main(String[] args) throws RepositorioException, ClienteJaExistenteException, DadoInvalidoException, ClienteInexistenteException, IOException, ClassNotFoundException {
		TelaCliente TC = new TelaCliente();
		ClienteArquivo.carregaCadastros();
		while(TC.criaMenu()) {System.out.println("-----------------------------");};
		ClienteArquivo.salvaCadastros();
	}
	
	public static boolean inserir(Cliente c) throws RepositorioException, ClienteJaExistenteException, IOException, ClassNotFoundException {
		return ClienteArquivo.inserir(c);
	}
	
	public static ArrayList<Cliente> buscar(String key, boolean porCPF) throws ClienteInexistenteException, IOException, ClassNotFoundException {
		return ClienteArquivo.buscar(key, porCPF);
	}
	
	public static ArrayList<Cliente> getClientes() throws ClassNotFoundException, IOException {
		return ClienteArquivo.getClientes();
	}
	
	public static boolean remove(String key) {
		return ClienteArquivo.remove(key);
	}
}
