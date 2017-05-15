package main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Writer {
	
	private ArrayList<Item> list;
	private String name;
	
	public Writer(ArrayList<Item> list, String path){
		this.list = list;
		this.name = path;		
	}
	
	public boolean export(String fileOutput){
		
		PrintStream file;
		try {
			file = new PrintStream(new FileOutputStream(fileOutput));
		} catch (FileNotFoundException e) {
			return false;
		}
	
		int idx = name.lastIndexOf('.');
		
		String nameNE = name.substring(0, idx);
		
		file.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		file.println("<file for=\"" + nameNE + "\">");
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
