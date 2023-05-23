package day15.com.ict.edu2;

public class Ex04_Dog extends Ex04_abstract {
	String name = "바둑이";

	@Override
	public void sound() {
		System.out.println("멍!뭉!");
	}

	@Override
	public void play() {
		System.out.println("바다에서 놀기");
	}

	@Override
	public String getName() {
		return name;
	}
}
