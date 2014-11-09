package com.jacksonf.domain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class FileCSV {
	
	
	public ArrayList<Client> LoadFile(String csvFile)
	{		
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";
		
		ArrayList<Client> clients = new ArrayList<>();
	 
		try {
	 
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
	 
			        // use comma as separator
				String[] columns = line.split(cvsSplitBy);
	 
				Client client = new Client();
				
				client.setId(Integer.parseInt(columns[0]));
				client.setNome(columns[1]);
				client.setCpf(columns[2]);
				client.setLogradouro(columns[3]);
				client.setNumero(columns[4]);
				client.setComplemento(columns[5]);
				client.setTelefoneResidencial(columns[6]);
				client.setTelefoneCelular(columns[7]);
				
				clients.add(client);
				
				
				
				
			}
						
	 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return clients;
	 
		
	}
}
