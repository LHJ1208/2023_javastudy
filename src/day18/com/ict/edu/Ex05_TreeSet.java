package day18.com.ict.edu;

import java.util.Random;
import java.util.TreeSet;

public class Ex05_TreeSet {
	public static void main(String[] args) {
		// 로또 : 1 ~ 45, 랜덤, 중복 안 됨, 6자리
		TreeSet<Integer> lotto = new TreeSet<>();

		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			int su = (int) (random.nextDouble() * 45) + 1;

			// 안 들어가지면
			if (!lotto.add(su)) {
				i--;
			}
		}

		System.out.println(lotto);
	}
}
