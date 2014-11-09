import java.util.ArrayList;

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

		arvore.printOrder(node);
		System.out.println();
		arvore.printPreOrder(node);
		System.out.println();
		arvore.printPosOrder(node);
		
		
		
	}

}
