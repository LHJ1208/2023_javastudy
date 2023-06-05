package day27.com.ict.HW;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HW0601_DB_DAO_LHJ {
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	int result = 0;

	public static HW0601_DB_DAO_LHJ dao = new HW0601_DB_DAO_LHJ();

	public static HW0601_DB_DAO_LHJ getInstance() {
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

	public ArrayList<HW0601_DB_VO_LHJ> getSelectAll() {
		ArrayList<HW0601_DB_VO_LHJ> list = null;
		try {
			conn = getConnection();
			String sql = "select * from customer2 order by custid";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {
				HW0601_DB_VO_LHJ vo = new HW0601_DB_VO_LHJ();
				vo.setCustid(rs.getString(1));
				vo.setName(rs.getString(2));
				vo.setAddress(rs.getString(3));
				vo.setPhone(rs.getString(4));
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

	public HW0601_DB_VO_LHJ getSelectOne(String c_id) {
		HW0601_DB_VO_LHJ vo = null;
		try {
			conn = getConnection();
			String sql = "select * from customer2 where custid = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, c_id);
			rs = pstm.executeQuery();

			if (rs.next()) {
				vo = new HW0601_DB_VO_LHJ();
				vo.setCustid(rs.getString(1));
				vo.setName(rs.getString(2));
				vo.setAddress(rs.getString(3));
				vo.setPhone(rs.getString(4));
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

	public int getInsert(HW0601_DB_VO_LHJ vo) {
		result = 0;

		try {
			conn = getConnection();
			String sql = "insert into customer2(custid, name, address, phone)" + " values(?, ?, ?, ?)";
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, vo.getCustid());

			if (vo.getName() == null) {
				pstm.setNull(2, java.sql.Types.VARCHAR);
			} else {
				pstm.setString(2, vo.getName());
			}

			if (vo.getAddress() == null) {
				pstm.setNull(3, java.sql.Types.VARCHAR);
			} else {
				pstm.setString(3, vo.getAddress());
			}

			if (vo.getPhone() == null) {
				pstm.setNull(4, java.sql.Types.VARCHAR);
			} else {
				pstm.setString(4, vo.getPhone());
			}

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

	public int getDelete(String custid) {
		try {
			conn = getConnection();
			String sql = "delete from customer2 where custid = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, custid);
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

	public int getDelete(HW0601_DB_VO_LHJ vo) {
		try {
			conn = getConnection();
			String sql = "delete from customer2 where custid = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, vo.getCustid());
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

	public int getUpdate(HW0601_DB_VO_LHJ vo) {
		result = 0;

		try {
			conn = getConnection();
			String sql = "update customer2 set name = ?, address = ?, phone = ? where custid = ?";
			pstm = conn.prepareStatement(sql);

			if (vo.getName() == null) {
				pstm.setNull(1, java.sql.Types.VARCHAR);
			} else {
				pstm.setString(1, vo.getName());
			}

			if (vo.getAddress() == null) {
				pstm.setNull(2, java.sql.Types.VARCHAR);
			} else {
				pstm.setString(2, vo.getAddress());
			}

			if (vo.getPhone() == null) {
				pstm.setNull(3, java.sql.Types.VARCHAR);
			} else {
				pstm.setString(3, vo.getPhone());
			}

			pstm.setString(4, vo.getCustid());

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

	public boolean isExist(String custid) {
		boolean result = false;

		try {
			conn = getConnection();
			String sql = "select * from customer2 where custid = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, custid);
			rs = pstm.executeQuery();
			if (rs.next()) {
				result = true;
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

		return result;
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
