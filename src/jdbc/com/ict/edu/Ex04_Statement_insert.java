package jdbc.com.ict.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex04_Statement_insert {
	public static void main(String[] args) {
		// 접속과 처리를 위한 클래스 3개
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		int result = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "c##lhj";
			String password = "1111";

			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();

			// insert (6, '이강인', '대한민국 서울', '000-9000-0001') 추가
			String sql = "insert into customer(custid, name, address, phone) "
					+ " values (6, '이강인', '대한민국 서울', '000-9000-0001')";

			result = stmt.executeUpdate(sql);

			if (result > 0) {
				// 성공하면 select문을 이용해서 보자
				sql = "select * from customer order by custid asc";
				// stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);

				while (rs.next()) {
					System.out.print(rs.getString("custid") + "\t");
					System.out.print(rs.getString("name") + "\t");
					System.out.print(rs.getString("address") + "\t");
					System.out.print(rs.getString("phone") + "\n");
				}
			}

		} catch (Exception e) {
		} finally {
			try {
				rs.close();
				stmt.close();
				rs.close();
			} catch (Exception e2) {
			}
		}
	}
}
