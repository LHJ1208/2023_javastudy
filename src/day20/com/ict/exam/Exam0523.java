package day20.com.ict.exam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

//1번 문제
class Test_Sub extends Test_Super {
	String name = "홍반장";

	public void play() {
		String name = "홍두께";
		System.out.println(name);
		System.out.println(this.name);
		System.out.println(super.name);
	}
}

//2번 문제
abstract class Test01 {
	String name = "홍길동";

	// 일반 메서드
	public void play() {
		System.out.println("놀자");
	}

	public String sound() {
		return "6시간 이상 잠자기";
	}

	public abstract void hobby();
}

class Test_Super {
	String name = "홍길동";
}

//3번 문제
enum Type {
	WALKING, RUNNING, TRACKING, HIKING
}

//4번 문제
interface Animal {
	public void sound();
}

interface Animal2 {
	public String play();
}

class Cat {
	void music(Animal animal) {
		animal.sound();
	}

	void game(Animal2 animal2) {
		System.out.println(animal2.play());
	}
}

public class Exam0523 {
	// 3번 문제
	String name;
	int size;
	Type type;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String inputStr = "";

		System.out.print("실행할 문제 입력 >> ");
		inputStr = scan.next();

		switch (inputStr) {
		case "1": {
			Test_Sub test = new Test_Sub();
			test.play();

			break;
		}
		case "3": {
			Exam0523 shose = new Exam0523();
			shose.name = "나이키";
			shose.size = 270;
			shose.type = Type.RUNNING;

			System.out.println("신발 이름 : " + shose.name);
			System.out.println("신발 사이즈 : " + shose.size);
			System.out.println("신발 종류 : " + shose.type);
			System.out.println("신발 종류 : " + Type.RUNNING);

			break;
		}
		case "4": {
			Cat cat = new Cat();
			cat.music(new Animal() {
				@Override
				public void sound() {
					System.out.println("야옹~ 야옹~ ");
				}
			});
			cat.game(new Animal2() {
				@Override
				public String play() {
					return "그루밍";
				}
			});

			break;
		}

		case "5": {
			while (true) {
				int su1 = 50;
				System.out.println("정수 입력 : ");
				try {
					int su2 = scan.nextInt();
					System.out.println("정답 : " + (su1 / su2));
				} catch (Exception e) {
					System.out.println("예외 발생");
				}
				break;
			}

			System.out.println("수고하셨습니다.");

			break;
		}
		case "6": {
			TreeSet<Integer> myLotto = new TreeSet<>();
			Random random = new Random();
			int ballCount = 0;
			Integer ball = 0;

			while (ballCount < 6) {
				ball = random.nextInt(45) + 1;
				if (!myLotto.contains(ball)) {
					myLotto.add(ball);
					ballCount++;
				}
			}

			Iterator<Integer> it = myLotto.iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
			}

			break;
		}

		case "7": {
			ArrayList<String> arrList;
			arrList = new ArrayList<>();

			arrList.add("손흥민");
			arrList.add("이강인");
			arrList.add("김민재");
			arrList.add("차범근");

			if (arrList.contains("손흥민")) {
				int index = arrList.indexOf("손흥민");
				System.out.println(index + 1);
			}

			Iterator<String> it = arrList.iterator();
			while (it.hasNext()) {
				String k = it.next();
				System.out.println(k);
			}

			break;
		}

		default: {
		}

		}

		scan.close();
	}
}
