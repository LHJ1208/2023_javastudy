package day12com.ict.edu;

public class Ex08_Constructor {
	private String name = "Water";
	private int price = 500;
		
	public Ex08_Constructor(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}	
}
