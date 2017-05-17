package main;

public class Item {
	
	private String item;
	private boolean value;
	
	
	public Item(String item, boolean value){
		this.item = item;
		this.value = value;
	}
	
	public String getItem() {
		return item;
	}
	
	public boolean getValue() {
		return value;
	}
	
	@Override
	public String toString(){
		
		StringBuilder s = new StringBuilder();
		s.append("<element>\n");
		s.append("<item>" + item + "</item>\n");
		s.append("<value>" + value + "</value>\n");
		s.append("</element>\n");
		
		return s.toString();
	}


}
