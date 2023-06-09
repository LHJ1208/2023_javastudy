package mybatis.com.ict.edu;

import org.apache.ibatis.session.SqlSession;

//DB 처리하는 메서드들을 가지고 있는 클래스
public class DAO {
	//실제 사용하는 클래스 SqlSession
	private static SqlSession ss;
	
	// 싱글턴 패턴 (동기화 처리) :
	private synchronized static SqlSession getSession() {
		if(ss != null) {
			ss = DBService.getFactory().openSession();
		}
		
		return ss;
	}
	
	// DB 처리하는 메서드들
	
}
