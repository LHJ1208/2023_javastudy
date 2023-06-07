package jdbc.com.ict.edu5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//DB에 접속해서 각종 SQL 처리하는 클래스
public class Ex02_DAO {
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	private static Ex02_DAO dao = new Ex02_DAO();

	public static Ex02_DAO getInstance() {
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

	// 각종 DB처리 메서드

	// 전체보기
	public ArrayList<Ex02_VO> getSelectAll() {
		try {
			conn = getConnection();
			String sql = "select * from customer2 order by custid";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			ArrayList<Ex02_VO> list = new ArrayList<>();
			while (rs.next()) {
				Ex02_VO vo = new Ex02_VO();
				vo.setCustid(rs.getString(1));
				vo.setName(rs.getString(2));
				vo.setAddress(rs.getString(3));
				vo.setPhone(rs.getString(4));
				list.add(vo);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	// 삽입
	public int getInsert(Ex02_VO vo) {
		return 0;
	}

	// 삭제
	public int getDelete(Ex02_VO vo) {
		return 0;
	}

	// 불러오기
	public Ex02_VO getSelectOne(Ex02_VO vo) {
		return null;
	}

	// 고치기
	public int getUpdate(Ex02_VO vo) {
		return 0;
	}

	// 아이디 체크
	public boolean getIdChk(String custid) {
		// 중복이면 false, 중복 아니면 true
		boolean idchk = true;

		try {
			conn = getConnection();
			String sql = "select * from customer2 where custid = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, custid);
			rs = pstm.executeQuery();
			if (rs.next()) {
				idchk = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
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
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return idchk;
	}
}
