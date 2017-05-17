package main;

import java.io.*;
import java.util.ArrayList;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Reader {
	
	public static ArrayList<Item> read(String path) throws IOException, ParserConfigurationException, SAXException{
		
		File f = new File(path);
		
		//classe factory per istanziare il documentbuilder
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//serve per parsare il file xml in un document per poi essere percorso come albero
		DocumentBuilder db;
		db = dbf.newDocumentBuilder();
		
		//elemento document per seguire il doc
		Document doc;
		doc = db.parse(f);
		
		ArrayList<Item> list = new ArrayList<Item>();
		
		//creo una lista di nodi per recuperare i dati
		NodeList contextList = doc.getDocumentElement().getElementsByTagName("context");
		NodeList anchorList = doc.getDocumentElement().getElementsByTagName("anchor") ;
		
		int lunghezza = (contextList.getLength()<anchorList.getLength()?contextList.getLength():anchorList.getLength());
		String currentItem;
		boolean currentValue;
		
		for (int i = 0; i < lunghezza; i++) {
			
			currentItem = anchorList.item(i).getTextContent();
			Element element = (Element) contextList.item(i);
			
			if(element.getElementsByTagName("pos").getLength()!=0)
				currentValue = true;
			else 
				currentValue = false;
			
			list.add(new Item(currentItem,currentValue));
			
		}
		
		return list;
		
	}
	

}
