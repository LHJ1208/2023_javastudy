package jdbc.com.ict.edu3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DAO(Data Access Object) :
//	데이터베이스의 data에 접근하기 위한 객체
//	비지니스 로직을 분리하기 위해서 사용

//	DB에 접속해서 각종 SQL을 처리하는 클래스

//	싱글턴 패턴 :
//		소프트웨어 디자인 패턴에서 사용하는 패턴 중 하나이다.
//		생성자가 여러 차례 호출 되더라도 실제 생성되는 객체는 하나이고
//		최초 생성자 이후에는 호출된 최초 생성자가 생성한 객체를 리턴한다.
//		가장 대표적인 것이 spring 이 기존적으로 싱글턴 패턴을 사용한다.
public class DAO {
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	int result = 0;

	private static DAO dao = new DAO();

	public static DAO getInstance() {
		return dao;
	}

	// DB 접속 메서드
	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "c##lhj";
			String password = "1111";

			conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (Exception e) {
		}

		return null;
	}

	// DB에 접근 후 원하는 메서드를 만들어서 사용

	// 전체 보기 메서드
	public void getSelectAll() {
		try {
			conn = getConnection();
			String sql = "select * from 고객테이블";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			printAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	// 아이디를 받아서 해당 아이디를 가지고 있는 사람의 정보 검색
	public void getSelectOne(String c_id) {
		try {
			conn = getConnection();
			String sql = "select * from 고객테이블 where 고객아이디 = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, c_id);
			rs = pstm.executeQuery();

			printAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	public void getInsert(String c_id, String c_name, String c_age, String c_rank, String c_job, String c_point) {
		try {
			conn = getConnection();
			String sql = "insert into 고객테이블(고객아이디, 고객이름, 나이, 등급, 직업, 적립금) values(?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, c_id);
			pstm.setString(2, c_name);
			pstm.setString(3, c_age);
			pstm.setString(4, c_rank);
			pstm.setString(5, c_job);
			pstm.setString(6, c_point);
			result = pstm.executeUpdate();
			if (result > 0) {
				getSelectAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void getDelete(String c_id) {
		try {
			conn = getConnection();
			String sql = "delete from 고객테이블 where 고객아이디 = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, c_id);
			int result = pstm.executeUpdate();
			if (result > 0) {
				getSelectAll();
			} else {
				System.out.println("없는 아이디 입니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void getUpdate(String c_id, String c_name, String c_age, String c_rank, String c_job, String c_point) {
		try {
			conn = getConnection();
			String sql = "update 고객테이블 set 고객이름 = ?, 나이 = ?, 등급 = ?, 직업 = ?, 적립금 = ? where 고객아이디 = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, c_name);
			pstm.setString(2, c_age);
			pstm.setString(3, c_rank);
			pstm.setString(4, c_job);
			pstm.setString(5, c_point);
			pstm.setString(6, c_id);
			result = pstm.executeUpdate();
			if (result > 0) {
				getSelectAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void printAll() throws SQLException {
		System.out.println("고객아이디\t고객이름\t나이\t등급\t직업\t적립금");
		while (rs.next()) {
			System.out.print(rs.getString(1) + "\t");
			System.out.print(rs.getString(2) + "\t");
			System.out.print(rs.getString(3) + "\t");
			System.out.print(rs.getString(4) + "\t");
			System.out.print(rs.getString(5) + "\t");
			System.out.println(rs.getString(6));
		}
	}

	public void closeAll() throws SQLException {
		if (rs != null) {
			rs.close();
			rs = null;
		}
		if (pstm != null) {
			pstm.close();
			pstm = null;
		}
		if (conn != null) {
			conn.close();
			conn = null;
		}
	}
}
