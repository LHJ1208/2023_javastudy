package jdbc.com.ict.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex05_Statement_delete {
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

			String sql = "delete from customer where name = '이강인'";

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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
