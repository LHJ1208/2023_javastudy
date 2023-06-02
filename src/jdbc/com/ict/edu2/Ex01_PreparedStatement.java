package jdbc.com.ict.edu2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex01_PreparedStatement {
	public static void main(String[] args) {
		// 오라클에 접속해서 처리하는 클래스 3개
		Connection conn = null;
		// Statement stmt = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int result = 0;

		try {
			// 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 오라클에 접속할 정보 저장
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "c##lhj";
			String password = "1111";

			// 오라클에 접속
			conn = DriverManager.getConnection(url, user, password);

			String sql = "select * from 고객테이블 order by 고객아이디 asc";
			pstm = conn.prepareStatement(sql);

			// 바인딩 변수(?)가 있으면 처리하자

			// 결과 받기
			rs = pstm.executeQuery();

			while (rs.next()) {
				System.out.print(rs.getString(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getString(4) + "\t");
				System.out.print(rs.getString(5) + "\t");
				System.out.print(rs.getString(6) + "\n");

				System.out.print(rs.getString("고객아이디") + "\t");
				System.out.print(rs.getString("고객이름") + "\t");
				System.out.print(rs.getString("나이") + "\t");
				System.out.print(rs.getString("등급") + "\t");
				System.out.print(rs.getString("직업") + "\t");
				System.out.print(rs.getString("적립금") + "\n\n");
			}
		} catch (Exception e) {
		} finally {
			try {
				if (rs != null)
					rs.close();
//				if (stmt != null)
//					stmt.close();
				if (pstm != null)
					pstm.close();
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}

		}
	}
}
