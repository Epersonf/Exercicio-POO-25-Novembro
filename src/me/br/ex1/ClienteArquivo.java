package me.br.ex1;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ClienteArquivo {
	
	static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	public static void carregaCadastros() {
		try {
			clientes = leCadastros();
		} catch (ClassNotFoundException | IOException e) {
			return;
		}
	}
	
	public static boolean inserir(Cliente c) throws IOException, ClassNotFoundException {
		if (buscar(c.getCpf(), true).size() != 0) return false;
		clientes.add(c);
		return true;
	}
	
	
	public static ArrayList<Cliente> buscar(String key, boolean porCPF) throws IOException, ClassNotFoundException {
		ArrayList<Cliente> toReturn = new ArrayList<Cliente>();
		for (Cliente c : clientes) {
			if (key.equalsIgnoreCase((porCPF) ? c.getCpf() : c.getNome())) {
				toReturn.add(c);
				if (porCPF) return toReturn;				
			}
		}
		return toReturn;
	}
	
	public static ArrayList<Cliente> getClientes() throws IOException, ClassNotFoundException {
		return clientes;
	}
	
	public static boolean remove(String key) {
		for (int i = 0; i < clientes.size(); i++) {
			if (!key.equalsIgnoreCase(clientes.get(i).getCpf())) continue;
			clientes.remove(i);
			return true;
		}
		return false;
	}
	
	public static void salvaCadastros() throws IOException {
		FileOutputStream file = new FileOutputStream("clientes.bin");
		ObjectOutputStream fObj = new ObjectOutputStream(file);
		
		for (Cliente c : clientes)
			fObj.writeObject(c);
		
		fObj.close();
		file.close();
	}
	
	public static ArrayList<Cliente> leCadastros() throws IOException, ClassNotFoundException {
		ArrayList<Cliente> toReturn = new ArrayList<Cliente>();
		FileInputStream file = new FileInputStream("clientes.bin");
		ObjectInputStream fObj = new ObjectInputStream(file);
		
		try {
			while(true) {
				toReturn.add((Cliente) fObj.readObject());
			}
		} catch(EOFException e) {
			fObj.close();
			file.close();
			return toReturn;
		}
	}
}
