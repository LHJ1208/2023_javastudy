package jdbc.com.ict.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//1. 자바와 오라클을 연결하기 위해서 ojdbc8.jar(driver)를 다운 받아서 util에 저장하였다.
//2. 프로젝트에 ojdbc8.jar 등록하자
//	프로젝트에서 마우스 오른쪽 - Build Path - Configure Build Path ... - Modulepath 클릭 - Add External JARS - util 폴더에서 ojdbc8.jar 파일 열기 - Apply and Close
public class Ex02_Statement_select {
	public static void main(String[] args) {
		// 1. Java를 오라클에 접속할 수 있도록 도와주는 클래스
		Connection connection = null;

		// 2. SQL 구문 작성을 도와주는 클래스
		Statement statement = null;

		// 3-1. select문의 결과를 받는 클래스
		ResultSet resultSet = null;

		// 3-2. select문을 제외한(delete, update, insert) 결과를 받는 변수
		int result = 0;

		try {
			// 4. jdbc 드라이버 로딩 : 오라클, MySQL 등 각각 내용이 다르다.
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 5. 접속하기 위한 정보 저장
			// 오라클, MySQL 각각 내용이 다르다.
			String url = "jdbc:oracle:thin:@192.168.0.8:1521:xe"; // 호스트 ip주소, 포트, SID
			String user = "c##lhj";
			String password = "1111";

			// 6. 접속하기 :
			connection = DriverManager.getConnection(url, user, password);

			// 7. SQL 작성하기
			String sql = "select * from BOOK";

			// 8. SQL을 보낼 수 있는 구문 만들기
			statement = connection.createStatement();

			// 9. SQL을 담아서 보내고 결과 받기

			// 9-1. select
			resultSet = statement.executeQuery(sql);

			// 9-2. select 제외(insert, update, delete)
			// result = statement.executeUpdate(sql);

			while (resultSet.next()) {
				System.out.print(resultSet.getString(1) + "\t");
				System.out.print(resultSet.getString(2) + "\t");
				System.out.print(resultSet.getString(3) + "\t");
				System.out.print(resultSet.getString(4) + "\n");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
