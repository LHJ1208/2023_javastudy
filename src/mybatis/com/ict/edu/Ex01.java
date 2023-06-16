package mybatis.com.ict.edu;

import java.util.List;
import java.util.Scanner;

//마이바티스 셋팅하기
//1. config.xml 만들기 - DB 접속
//2. mapper.xml 만들기 - 실제 SQL 작성하는 파일 (실제 DB에 갖다와서 결과를 내보내는 파일)
//3. VO.java - DB 에 들어갈 파라미터 및 결과 저장을 담당하는 파일
//4. DAO.java - mapper와 연결되서 자바에서 DB 실행시키는 파일(DB 처리하는 클래스들을 모은 파일)
//5. DBService - config.xml 파일을 읽고 MyBatis를 실행할 수 있도록 하는 파일 

//1. 환경설정 파일(config.xml) 만들기
public class Ex01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Ex01 test = new Ex01();

		System.out.println("선택하세요");
		System.out.println("1. CUSTOMER 테이블 전체보기");
		System.out.println("2. CUSTOMER 테이블 특정 데이터 보기");
		System.out.println("3. CUSTOMER 테이블 데이터 삽입");
		System.out.println("4. CUSTOMER 테이블 데이터 삭제");
		System.out.println("5. CUSTOMER 테이블 데이터 수정");
		System.out.print(" >>> ");

		int menu = scan.nextInt();
		List<VO> list = null;

		switch (menu) {
		case 1:
			list = DAO.getList();
			test.prn(list);
			break;
		case 2: {
			System.out.print("custid를 입력하세요 >>> ");
			String custid = scan.next();
			VO vo = DAO.getOne(custid);
			test.prn2(vo);
			break;
		}
		case 3: {
			System.out.println("삽입정보를 입력하세요 >>> ");
			System.out.print("이름 : ");
			String name = scan.next();
			System.out.print("주소 : ");
			String address = scan.next();
			System.out.print("전화번호 : ");
			String phone = scan.next();
			VO vo = new VO();
			vo.setName(name);
			vo.setAddress(address);
			vo.setPhone(phone);
			int result = DAO.getInsert(vo);
			if(result > 0) {
				list = DAO.getList();
				test.prn(list);
			}
			break;
		}
		case 4: {
			System.out.print("삭제할 custid를 입력하세요 >> ");
			String custid = scan.next();
			VO vo = new VO();
			vo.setCustid(custid);
			int result = DAO.getDelete(vo);
			if(result > 0) {
				list = DAO.getList();
				test.prn(list);
			}
			
			break;
		}
		case 5: {
			System.out.println("갱신정보를 입력하세요");
			System.out.print("갱신할 번호 : ");
			String custid = scan.next();
			System.out.print("이름 : ");
			String name = scan.next();
			System.out.print("주소 : ");
			String address = scan.next();
			System.out.print("전화번호 : ");
			String phone = scan.next();
			
			VO vo = new VO();
			vo.setCustid(custid);
			vo.setName(name);
			vo.setAddress(address);
			vo.setPhone(phone);
			
			int result = DAO.getUpdate(vo);
			if(result > 0) {
				list = DAO.getList();
				test.prn(list);
			}
			break;
		}
		default:
			System.out.println("제대로 입력하세요.");
		}
	}

	// 테이블 전체보기 메서드
	public void prn(List<VO> list) {
		System.out.println("번호\t이름\t주소\t전화번호");
		for (VO vo : list) {
			System.out.print(vo.getCustid() + "\t");
			System.out.print(vo.getName() + "\t");
			System.out.print(vo.getAddress() + "\t");
			System.out.println(vo.getPhone());
		}
	}

	// 보기 메서드
	public void prn2(VO vo) {
		System.out.println("번호\t이름\t주소\t전화번호");
		System.out.print(vo.getCustid() + "\t");
		System.out.print(vo.getName() + "\t");
		System.out.print(vo.getAddress() + "\t");
		System.out.println(vo.getPhone());
	}
}
