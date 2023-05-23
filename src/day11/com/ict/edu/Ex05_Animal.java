package day11.com.ict.edu;

public class Ex05_Animal {
	//멤버 필드//
	
	//생존여부
	boolean live = true;
	
	//나이
	int age = 0;
	
	//이름
	String name = "";
	
	
	//멤버 메서드//
	
	//생존여부를 변경하는 메서드
	void setLive(boolean input) {
		live = input;
	}
	
	//생존여부를 반환하는 메서드
	boolean getLive() {
		return live;
	}
	
	//나이를 변경하는 메서드
	void setAge(int input) {
		age = input;
	}
	
	//나이를 반환하는 메서드
	int getAge() {
		return age;
	}
	
	//이름을 변경하는 메서드
	void setName(String input) {
		name = input;
	}
	
	//이름을 반환하는 메서드
	String getName() {
		return name;
	}
	
	//이름, 나이, 생존여부를 변경하는 메서드
	void setField(String s1, int s2, boolean s3) {
		name = s1;
		age = s2;
		live = s3;
	}
	void setField(int s2, String s1, boolean s3) {
		name = s1;
		age = s2;
		live = s3;
	}
	void setField(boolean s3, int s2, String s1) {
		name = s1;
		age = s2;
		live = s3;
	}
	
	//이름, 나이, 생존여부를 출력하는 메서드
	void printAtConsole() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("생존여부 : " + (live ? "生" : "死"));
	}
}
