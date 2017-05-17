package main;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Main {
	
	private static void writeOnFile(ArrayList<Item> list, String outputFileName){
		
		Writer w = new Writer(list);
		
		if(w.export(outputFileName))
			Grafica.showInfoMessage("Scrittura del file completata.", "Scrittura completata con successo!");
		else
			Grafica.showErrorMessage("Scrittura del file non riuscita!", "Errore scrittura!");
		
	}
	
	private static void fromFile(){
		
		String inputFileName = Grafica.getFileName("Inserire il nome del file con estensione.");
		ArrayList<Item> list;
		
		try {
			list = Reader.read(inputFileName);
		} catch (IOException | ParserConfigurationException | SAXException e) {
			Grafica.showErrorMessage("Errore nella lettura del file!", "Errore lettura");
			System.exit(0);
			list = null;
		}
		
		int idx = inputFileName.lastIndexOf('.');
		String nameNE = inputFileName.substring(0, idx);
		
		writeOnFile(list, nameNE);		
		
	}
	
	private static void newFile(){
		
		String title = Grafica.getFileName("Inserisci l'argomento del file.");
		ArrayList<Item> list = new ArrayList<Item>();
		Item newItem;
		int count = 0;
		
		do{
			newItem = Grafica.getItem("Inserisci il nuovo elemento.\n"
									+ "Per terminare l'inserimento, chiudere la finestra. ", 
									"Inserimento nuovo elemento", count);
			if(newItem != null)
				list.add(newItem);
			
			count++;
			
		}while(newItem != null);
		
		writeOnFile(list, title);
		
		
		
	}
	
	public static void main(String[] args){
		
		int n = Grafica.chooseOperation();
		
		switch (n) {
		case 0:
			fromFile();
			break;
		case 1:
			newFile();

		default:
			break;
		}
		
		
	}

}
