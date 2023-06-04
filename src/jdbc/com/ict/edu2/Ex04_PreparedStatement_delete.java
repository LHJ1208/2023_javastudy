package jdbc.com.ict.edu2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Ex04_PreparedStatement_delete {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "c##lhj";
			String password = "1111";

			conn = DriverManager.getConnection(url, user, password);

			// 보통은 primary key를 이용해서 삭제한다.
			String sql = "select * from customer order by custid";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				System.out.print(rs.getString(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getString(4) + "\n");
			}

			sql = "delete from customer where custid = ?";
			// ? => 바인딩 변수
			pstm = conn.prepareStatement(sql);

			Scanner scan = new Scanner(System.in);
			System.out.print("\ncustID : ");
			int custid = scan.nextInt();

			pstm.setInt(1, custid);

			int result = pstm.executeUpdate();
			if (result > 0) {
				System.out.println("\ndelete complete\n");
			}

			sql = "select * from customer order by custid";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				System.out.print(rs.getString("custid") + "\t");
				System.out.print(rs.getString("name") + "\t");
				System.out.print(rs.getString("address") + "\t");
				System.out.print(rs.getString("phone") + "\n");
			}

		} catch (Exception e) {
			System.out.println("삭제 실패");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
			}
		}
	}
}
