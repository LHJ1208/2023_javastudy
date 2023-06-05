package jdbc.com.ict.edu4;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("선택하세요");
		System.out.println("1. 테이블 전체 데이터 보기");
		System.out.println("2. 테이블 특정 데이터 보기");
		System.out.println("3. 데이터 삽입");
		System.out.println("4. 데이터 삭제");
		System.out.println("5. 데이터 수정");
		System.out.println(">>>>>>>>>>>>>>>>>>>>");

		int menu = scan.nextInt();
		switch (menu) {
		case 1: {
			printAll();
			break;
		}
		case 2: {
			System.out.print("고객아이디 : ");
			String c_id = scan.next();
			VO vo = DAO.getInstance().getSelectOne(c_id);
			if (vo != null) {
				System.out.print(vo.get고객아이디() + "\t");
				System.out.print(vo.get고객이름() + "\t");
				System.out.print(vo.get나이() + "\t");
				System.out.print(vo.get등급() + "\t");
				System.out.print(vo.get직업() + "\t");
				System.out.println(vo.get적립금());
			} else {
				System.out.println("아이디가 존재하지 않습니다.");
			}
			break;
		}
		case 3: {
			VO vo = new VO();
			System.out.println("삽입할 정보를 입력하세요");
			System.out.print("고객아이디 : ");
			vo.set고객아이디(scan.next());
			System.out.print("고객이름 : ");
			vo.set고객이름(scan.next());
			System.out.print("나이 : ");
			vo.set나이(scan.next());
			System.out.print("등급 : ");
			vo.set등급(scan.next());
			System.out.print("직업 : ");
			vo.set직업(scan.next());
			System.out.print("적립금 : ");
			vo.set적립금(scan.next());

			int result = DAO.getInstance().getInsert(vo);
			if (result > 0) {
				printAll();
			} else {
				System.out.println("삽입 실패");
			}
			break;
		}
		case 4: {
			VO vo = new VO();
			System.out.print("삭제할 고객아이디 : ");
			vo.set고객아이디(scan.next());
			int result = DAO.getInstance().getDelete(vo);
			if(result>0) {
				printAll();
			} else {
				System.out.println("삭제 실패");
			}
			break;
		}
		}
	}

	public static void printAll() {
		ArrayList<VO> list = DAO.getInstance().getSelectAll();
		System.out.println("고객아이디\t고객이름\t나이\t등급\t직업\t적립금");
		for (VO k : list) {
			System.out.print(k.get고객아이디() + "\t");
			System.out.print(k.get고객이름() + "\t");
			System.out.print(k.get나이() + "\t");
			System.out.print(k.get등급() + "\t");
			System.out.print(k.get직업() + "\t");
			System.out.println(k.get적립금());
		}
	}
}
