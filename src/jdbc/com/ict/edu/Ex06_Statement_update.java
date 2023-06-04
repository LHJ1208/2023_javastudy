package jdbc.com.ict.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//박세리의 주소를 대한민국 제주도, 전화번호를 000-9000-0001로 변경하자
public class Ex06_Statement_update {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		int result = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "c##lhj";
			String password = "1111";

			connection = DriverManager.getConnection(url, user, password);

			statement = connection.createStatement();

			String sql = "update customer set address = '대한민국 제주도', phone = '000-9000-0001' where name = '박세리'";

			result = statement.executeUpdate(sql);

			if (result > 0) {
				sql = "select * from customer order by custid asc";

				resultSet = statement.executeQuery(sql);

				while (resultSet.next()) {
					System.out.print(resultSet.getString(1) + "\t");
					System.out.print(resultSet.getString(2) + "\t");
					System.out.print(resultSet.getString(3) + "\t");
					System.out.print(resultSet.getString(4) + "\n");
				}
			}

		} catch (Exception e) {
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (Exception e2) {
			}
		}
	}
}
