package day13.com.ict.edu;

import java.util.Scanner;

//2주차 시험
//문제 해결 시나리오 문제 풀이
public class Exam0512W2 {
	public static void main(String[] args) {
		System.out.println("====== 문제번호 목록 ======");
		System.out.println("1 (언어 특성 활용하기 문제 1)");
		System.out.println("2 (언어 특성 활용하기 문제 2)");
		System.out.println("3 (언어 특성 활용하기 문제 3)");
		System.out.println("4 (라이브러리 활용하기 문제 1)");
		System.out.println("5 (라이브러리 활용하기 문제 2)");
		System.out.println("6 (라이브러리 활용하기 문제 3)");
		System.out.println("7 (라이브러리 활용하기 문제 4)");
		System.out.println("8 (라이브러리 활용하기 문제 5)");
		System.out.println();
		
		Scanner keyScan = new Scanner(System.in);
		System.out.print("문제번호 입력 : ");
		int proNum = keyScan.nextInt();
		System.out.println();

		switch (proNum) {
		case 1: // 언어 특성 활용하기 문제 1
			for (int i = 1; i < 10; i++)
				System.out.println("7 x " + i + " = " + (i * 7));
			break;

		case 2: // 언어 특성 활용하기 문제 2
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (i == j)
						System.out.print("1 ");
					else
						System.out.print("0 ");
				}
				System.out.println();
			}
			break;

		case 3: { // 언어 특성 활용하기 문제 3
			Scanner scan = new Scanner(System.in);

			int count = 0;
			int even = 0;
			esc: while (true) {
				count++;
				System.out.print("숫자입력 : ");
				int su = scan.nextInt(); // (1)
				String str = "";
				if (su % 2 == 0) {
					str = "짝수";
					even++;
				} else {
					str = "홀수";
				}
				System.out.println(su + "는 " + str + " 입니다.");
				while (true) {
					System.out.print("계속할까요?(Y(y)/N(n) >> ");
					String s1 = scan.next(); // (2)
					if (s1.equalsIgnoreCase("y")) {
						break; //(3)
					} else if (s1.equalsIgnoreCase("n")) {
						break esc; //(4)
					} else {
						System.out.println("제대로 입력하세요.");
						continue; // (5)
					}
				}
			}
			double per = (even / (count * 1.0)) * 100;
			System.out.println("전체 개수 : " + count);
			System.out.println("짝수 개수 : " + even);
			System.out.println("퍼센트 : " + ((int) (per * 10) / 10.0)); // (6)
			
			scan.close();
		}
			break;

		case 4: { // 라이브러리 활용하기 문제 1
			int[] su = { 3, 4, 9, 8, 2, 1, 7, 10, 5, 6 };
			int tmp = 0;
			for (int i = 0; i < su.length - 1; i++) {
				for (int j = i + 1; j < su.length; j++) {
					if (su[i] > su[j]) {
						tmp = su[i];
						su[i] = su[j];
						su[j] = tmp;
					}
				}
			}

			// 문제 확인용 출력
			for (int i = 0; i < su.length; i++) {
				System.out.print(su[i] + " ");
			}
		}
			break;

		case 5: { // 라이브러리 활용하기 문제 2
			int[] su = { 90, 80, 70, 95, 90, 85, 75 };
			int[] rank = { 1, 1, 1, 1, 1, 1, 1 };

			for (int i = 0; i < su.length; i++) {
				for (int j = 0; j < su.length; j++) {
					if (su[i] < su[j])
						rank[i]++;
				}
			}

			// 문제 확인용 출력
			for (int i = 0; i < su.length; i++) {
				System.out.print(su[i] + "\t");
			}
			System.out.println();
			for (int i = 0; i < su.length; i++) {
				System.out.print(rank[i] + "\t");
			}

			break;
		}

		case 6: { // 라이브러리 활용하기 문제 3
			int[] su = {90, 87, -20, 120, 67, 23, 40, 53};
			
			int min = su[0]; //가장 작은 값 저장할 변수
			int max = su[0]; //가장 큰 값 저장할 변수
			
			for (int i = 1; i < su.length; i++) {
				if(min > su[i]) min = su[i];
				if(max < su[i]) max = su[i];
			}

			System.out.println("가장 작은 값 : " + min);
			System.out.println("가장 큰 값 : " + max);
			
			break;
		}

		case 7: { // 라이브러리 활용하기 문제 4
			int[][] su = new int[3][];
			int[] k1 = { 10, 20, 30 };
			int[] k2 = { 100, 200 };
			int[] k3 = { 1000, 2000, 3000, 4000 };
			su[0] = k1;
			su[1] = k2;
			su[2] = k3;
			
			for (int i = 0; i < su.length; i++) {
				for (int j = 0; j < su[i].length; j++) {
					System.out.print(su[i][j] + " ");
				}				
				System.out.println();
			}
			
			break;
		}

		case 8: { // 라이브러리 활용하기 문제 5
			int[][] arr = new int[5][5];
			//번호 , 총점, 평균, 학점, 순위
			int[] p1 = {1, 270, 90, 'A', 1};
			int[] p2 = {2, 210, 70, 'C', 1};
			int[] p3 = {3, 180, 60, 'F', 1};
			int[] p4 = {4, 300, 100, 'A', 1};
			int[] p5 = {5, 285, 95, 'A', 1};
			
			//p1, p2, p3, p4, p5 배열을 arr 배열에 넣기
			// (1)
			arr[0] = p1;
			arr[1] = p2;
			arr[2] = p3;
			arr[3] = p4;
			arr[4] = p5;
			
			//순위를 구하자
			for(int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					//(자기자신 제외)
					if(i == j) continue; // (2)
					if(arr[i][1] < arr[j][1]) {
						arr[i][4]++;
					}
				}
			}
			
			//자리변경을 위한 임시 배열 필요
			int[] tmp; // (3)
			
			//순위로 오름 정령
			for (int i = 0; i < arr.length - 1; i++) {
				for (int j = i + 1; j < arr.length; j++) {
					//오름차순
					if(arr[i][4] > arr[j][4]) {
						// (4)
						tmp = arr[i];
						arr[i] = arr[j];
						arr[j] = tmp;
					}
				}				
			}
			
			//출력
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if(j == 3) {
						System.out.print((char)(arr[i][j]) + "\t");
					} else {
						System.out.print(arr[i][j] + "\t");
					}
				}
				System.out.println();
			}
			
			break;
		}

		default:
		}
		
		keyScan.close();
	}
}
