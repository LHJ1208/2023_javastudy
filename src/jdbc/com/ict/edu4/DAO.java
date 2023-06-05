package jdbc.com.ict.edu4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	int result = 0;

	public static DAO dao = new DAO();

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

	public ArrayList<VO> getSelectAll() {
		ArrayList<VO> list = null;
		try {
			conn = getConnection();
			String sql = "select * from 고객테이블";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {
				VO vo = new VO();
				vo.set고객아이디(rs.getString(1));
				vo.set고객이름(rs.getString(2));
				vo.set나이(rs.getString(3));
				vo.set등급(rs.getString(4));
				vo.set직업(rs.getString(5));
				vo.set적립금(rs.getString(6));
				list.add(vo);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	public VO getSelectOne(String c_id) {
		VO vo = null;
		try {
			conn = getConnection();
			String sql = "select * from 고객테이블 where 고객아이디 = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, c_id);
			rs = pstm.executeQuery();

			if (rs.next()) {
				vo = new VO();
				vo.set고객아이디(rs.getString(1));
				vo.set고객이름(rs.getString(2));
				vo.set나이(rs.getString(3));
				vo.set등급(rs.getString(4));
				vo.set직업(rs.getString(5));
				vo.set적립금(rs.getString(6));
			}
			return vo;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public int getInsert(VO vo) {
		result = 0;

		try {
			conn = getConnection();
			String sql = "insert into 고객테이블(고객아이디, 고객이름, 나이, 등급, 직업, 적립금)" + " values(?, ?, ?, ?, ?, ?)";
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, vo.get고객아이디());
			pstm.setString(2, vo.get고객이름());
			pstm.setString(3, vo.get나이());
			pstm.setString(4, vo.get등급());
			pstm.setString(5, vo.get직업());
			pstm.setString(6, vo.get적립금());

			result = pstm.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return -1;
	}

	public int getDelete(VO vo) {
		try {
			conn = getConnection();
			String sql = "delete from 고객테이블 where 고객아이디 = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, vo.get고객아이디());
			result = pstm.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return -1;
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
