package main;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Main {
	
	public static void main(String[] args){
		
		//String inputFileName = JOptionPane.showInputDialog("Inserire il nome del file con estensione.");
		String inputFileName = "prova.xml";
		Writer w;
		try {
			w = new Writer(Reader.read(inputFileName),inputFileName);
		} catch (IOException | ParserConfigurationException | SAXException e) {
			e.printStackTrace();
			return;
		}
		int idx = inputFileName.lastIndexOf('.');
		
		String nameNE = inputFileName.substring(0, idx);
		
		String outputFileName = nameNE + "Lite.xml";
		
		System.out.println(w.export(outputFileName));
		
		
		
	}

}
