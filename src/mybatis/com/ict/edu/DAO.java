package mybatis.com.ict.edu;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

//DB 처리하는 메서드들을 가지고 있는 클래스
public class DAO {
	// 실제 사용하는 클래스 SqlSession
	private static SqlSession ss;

	// 싱글턴 패턴 (동기화 처리) :
	private synchronized static SqlSession getSession() {
		if (ss == null) {
			ss = DBService.getFactory().openSession();
		}

		return ss;
	}

	// DB 처리하는 메서드들

	// CUSTOMER 테이블 전체 보기
	// SELECT , 결과는 여러개 , 파라미터가 없음
	public static List<VO> getList() {
		List<VO> list = null;
		// selectList() : 결과가 하나 이상일 때
		// selectOne() : 결과가 반드시 하나일 때
		// 파라미터가 있는 메서드와 파라미터가 없는 메서드로 나눈다.
		// 파라미터가 있는 메서드 : selectList("mapper의 id", 파라미터);
		// 파라미터가 없는 메서드 : selectList("mapper의 id");

		list = getSession().selectList("custList");
		return list;
	}
	
	// SELECT , 결과는 하나, 파라미터 있음
	public static VO getOne(String custid) {
		VO vo = getSession().selectOne("custOne", custid);
		return vo;
	}
	
	// INSERT, DELETE, UPDATE 결과 int, 파라미터 있음
	public static int getInsert(VO vo) {
		int result = getSession().insert("custIns", vo);
		ss.commit();
		return result;
	}
	
	public static int getDelete(VO vo) {
		int result = getSession().delete("custDel", vo);
		ss.commit();
		return result;
	}
	
	public static int getUpdate(VO vo) {
		int result = getSession().update("custUpdate", vo);
		ss.commit();
		return result;
	}
}
