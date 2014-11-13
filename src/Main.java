import java.util.ArrayList;
import java.util.Scanner;

import com.jacksonf.domain.Client;
import com.jacksonf.domain.FileCSV;
import com.jacksonf.domain.Node;
import com.jacksonf.domain.ThreeAVL;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		ThreeAVL arvore = new ThreeAVL();
		FileCSV  csv = new FileCSV();
		
		ArrayList<Client> clientes = csv.LoadFile("C:\\temp\\clientes.csv");
				
		
		Node node = null;
		
		for (Client client : clientes) {
			node = arvore.insertNode(node, client);
		}
		
		int optionMenu = 0;
		
		Scanner reader = new Scanner(System.in);
		
		do {
			System.out.println("Informe 1 para Inserir novo cliente");			
			
			optionMenu = reader.nextInt();
			
			if (optionMenu == 1){
				Client cliente = new Client();
								
				System.out.println("Id: ");
				cliente.setId(reader.nextInt());
				System.out.println("Nome: ");
				cliente.setNome(reader.nextLine());
				System.out.println("Cpf: ");
				cliente.setCpf(reader.nextLine());
				System.out.println("Logradouro: ");
				cliente.setLogradouro(reader.nextLine());
				System.out.println("Numero: ");
				cliente.setNumero(reader.nextLine());
				System.out.println("Complemento: ");
				cliente.setComplemento(reader.nextLine());
				System.out.println("Telefone Residencial: ");
				cliente.setTelefoneResidencial(reader.nextLine());
				System.out.println("Telefone Celular: ");
				cliente.setTelefoneCelular(reader.nextLine());

				node = arvore.insertNode(node, cliente);
				
			}
				
			
		} while (optionMenu != 0);
		
		reader.close();

		arvore.printOrder(node);
		System.out.println();
		arvore.printPreOrder(node);
		System.out.println();
		arvore.printPosOrder(node);	
		
		
		System.out.println("Total rotação: " + arvore.getRotateTotalCount());
		System.out.println("Total rotação Esq.: " + arvore.getRotateLeftCount());
		System.out.println("Total rotação Dir.: " + arvore.getRotateRightCount());
		
		
		System.out.println("Bye bye user!!!");		
	}

}
