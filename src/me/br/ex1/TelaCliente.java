package me.br.ex1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import me.br.ex1.exceptions.ClienteInexistenteException;
import me.br.ex1.exceptions.ClienteJaExistenteException;
import me.br.ex1.exceptions.DadoInvalidoException;
import me.br.ex1.exceptions.RepositorioException;

public class TelaCliente {
	private Scanner scan;
	private int menu = 0;
	
	public TelaCliente() {
		scan = new Scanner(System.in);
	}
	
	public void close() {
		scan.close();
	}
	
	public boolean criaMenu() throws RepositorioException, ClienteJaExistenteException, IOException, DadoInvalidoException, ClienteInexistenteException, ClassNotFoundException {
		
		String cpf, name, email;
		ArrayList<Cliente> c;
		
		switch (menu) {
			case 0:
				System.out.println("Escolha:\n1 - Cadastrar cliente\n2 - Buscar cliente pelo nome\n3 - Buscar cliente pelo CPF\n4 - Excluir cliente\n5 - Listar clientes");
				menu = scan.nextInt();
				break;
			case 1:
				System.out.println("Digite o nome do cliente: ");
				name = scan.next();
				System.out.println("Digite o cpf do cliente: ");
				cpf = scan.next();
				System.out.println("Digite o email do cliente: ");
				email = scan.next();
				if (CadastroCliente.inserir(new Cliente(cpf, name, email))) {
					System.out.println("Usuario registrado");
				} else {
					System.out.println("CPF ja cadastrado.");
				}
				menu = 0;
				break;
			case 2:
				System.out.println("Digite o nome do cliente: ");
				name = scan.next();
				c = CadastroCliente.buscar(name, false);
				if (c.size() <= 0) {System.out.println("Clientes nao encontrados.");break;}
				for (int i = 0; i < c.size(); i++)
					System.out.println(c.get(i).getDados());
				menu = 0;
				break;
			case 3:
				System.out.println("Digite o CPF do cliente: ");
				name = scan.next();
				c = CadastroCliente.buscar(name, true);
				System.out.println((c.size() > 0) ? c.get(0).getDados() : "Cliente nao encontrado.");
				menu = 0;
				break;
			case 4:
				System.out.println("Digite o CPF do cliente a ser removido: ");
				boolean b = CadastroCliente.remove(scan.next());
				System.out.println(b ? "Removido" : "Nao encontrado...");				
				menu = 0;
				break;
			case 5:
				for (Cliente c_ : CadastroCliente.getClientes())
					System.out.println(c_.getDados());
				menu = 0;
				break;
			default:
				System.out.println("Saindo do programa...");
				this.close();
				menu = 0;
				return false;
		}
		return true;
	}
}
