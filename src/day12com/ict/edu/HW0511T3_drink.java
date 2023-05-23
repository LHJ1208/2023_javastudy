package day12com.ict.edu;

public class HW0511T3_drink {
	private String name = ""; // 음료수 이름
	private int price = 0; // 음료수 가격
	private int count = 0; // 음료수 재고 개수

	public HW0511T3_drink(String name, int price, int count) {
		super();
		this.name = name;
		this.price = price;
		this.count = count;
	}

	// get()/set()
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isEmpty() {
		return count <= 0;
	}

	public boolean isEqualsName(String str) {
		return name.equals(str);
	}

	public boolean canBuy(int input) {
		return price <= input;
	}
}
