package day15.com.ict.edu;

public class Main {
	public static void main(String[] args) {
		Cat cat = new Cat();

		System.out.println(cat.eyes);
		System.out.println(cat.color);
		
		cat.play();
		cat.sound();
		cat.hobby();
		cat.sleep();
	}
}
