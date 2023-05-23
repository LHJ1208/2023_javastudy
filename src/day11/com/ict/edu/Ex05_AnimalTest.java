package day11.com.ict.edu;

public class Ex05_AnimalTest {
	public static void main(String[] args) {
		//객체 생성
		Ex05_Animal ani = new Ex05_Animal();
		
		boolean b1 = true;
		int n1 = 0;
		String s1 = "";
		
		//이름을 큰뿔소로 변경
		ani.setName("큰뿔소");
		
		//나이를 3으로 변경
		ani.setAge(3);
		
		//생존여부를 살아있음으로 변경
		ani.setLive(true);
		
		//결과 출력
		s1 = ani.getName();
		n1 = ani.getAge();
		b1 = ani.getLive();
		System.out.println("이름 : " + s1);
		System.out.println("나이 : " + n1);
		System.out.println("생존여부 : " + (b1 ? "生" : "死"));
		
		System.out.println("=========");
		
		//각각 이름을 펭귄,	나이를 1,	생존여부를 살아있음으로 변경
		ani.setName("펭귄");
		ani.setAge(1);
		ani.setLive(true);
		
		//결과 출력
		s1 = ani.getName();
		n1 = ani.getAge();
		b1 = ani.getLive();
		System.out.println("이름 : " + s1);
		System.out.println("나이 : " + n1);
		System.out.println("생존여부 : " + (b1 ? "生" : "死"));

		System.out.println("=========");
		
		ani.setField(false, 101, "거북이");
		ani.printAtConsole();

		System.out.println("=========");
		
		ani.setField("토끼", 102, true);
		ani.printAtConsole();
	}
}
