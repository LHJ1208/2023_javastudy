package day33.com.ict.HW;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class HW0612_DB_DAO_LHJ {
	// 실제 사용하는 클래스 SqlSession
	private static SqlSession ss;

	// 싱글턴 패턴 (동기화 처리) :
	private synchronized static SqlSession getSession() {
		if (ss == null) {
			ss = DBService.getFactory().openSession();
		}

		return ss;
	}

	public static List<HW0612_DB_VO_LHJ> getSelectAll() {
		List<HW0612_DB_VO_LHJ> list = null;

		list = getSession().selectList("customerSelectAll");
		return list;
	}

	public static HW0612_DB_VO_LHJ getSelectOne(String c_id) {
		HW0612_DB_VO_LHJ vo = getSession().selectOne("customerSelectOne", c_id);

		return vo;
	}

	public static List<HW0612_DB_VO_LHJ> getSelectByName(String c_name) {
		List<HW0612_DB_VO_LHJ> list = null;

		list = getSession().selectList("customerSelectByName", c_name);

		return list;
	}

	public static List<HW0612_DB_VO_LHJ> getSelectByPhone(String c_name) {
		List<HW0612_DB_VO_LHJ> list = null;

		list = getSession().selectList("customerSelectByPhone", c_name);

		return list;
	}

	public static List<HW0612_DB_VO_LHJ> getSelectByAddress(String c_name) {
		List<HW0612_DB_VO_LHJ> list = null;

		list = getSession().selectList("customerSelectByyAddress", c_name);

		return list;
	}

	public static int getInsert(HW0612_DB_VO_LHJ vo) {
		int result = getSession().insert("customerInsert", vo);
		ss.commit();
		return result;
	}

	public static int getDelete(HW0612_DB_VO_LHJ vo) {
		int result = getSession().delete("customerDelete", vo);
		ss.commit();
		return result;
	}

	public static int getUpdate(HW0612_DB_VO_LHJ vo) {
		int result = getSession().update("customerUpdate", vo);
		ss.commit();
		return result;
	}

	public static boolean isExist(String custid) {
		boolean result = true;

		if (getSelectOne(custid) == null) {
			result = false;
			System.out.println("can not found");
		}

		return result;
	}
}
