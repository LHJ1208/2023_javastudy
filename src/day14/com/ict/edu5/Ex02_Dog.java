package day14.com.ict.edu5;

public class Ex02_Dog extends Ex02_Animal {
	String color = "black";

	@Override
	public void sound() {
		System.out.println("댕댕");
	}

	public void play() {
		System.out.println("잔디에서 뛰어놀기");
	}
}
