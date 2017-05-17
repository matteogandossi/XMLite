package main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Writer {
	
	private ArrayList<Item> list;
	
	public Writer(ArrayList<Item> list){
		this.list = list;	
	}
	
	public boolean export(String fileOutput){
		
		PrintStream file;
		String outputFileName = fileOutput + "Lite.xml";
		
		try {
			file = new PrintStream(new FileOutputStream(outputFileName));
		} catch (FileNotFoundException e) {
			return false;
		}
		
		file.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		file.println("<file for=\"" + fileOutput + "\">");
		file.println("<nofelements>" + list.size() + "</nofelements>");
		file.println("<elements>");
		
		for(int i=0; i<list.size();i++){
			
			file.println("\t<element id=\"" + (i+1) + "\">" );
			file.println("\t\t<item>" + list.get(i).getItem() + "</item>" );
			file.println("\t\t<value>" + list.get(i).getValue() + "</value>" );
			file.println("\t</element>" );
		}
				
		file.println("</elements>");
		file.print("</file>");
		
		file.close();
		return true;
	}

}
