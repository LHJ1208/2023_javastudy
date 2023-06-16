package network.com.ict.edu;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// json : xml 과 함께 정보를 전달할 때 사용
//	JavaScript Object Notation(JSON) : 데이터 교환 포맷
//	json_simple 라이브러리 다운받기

public class Ex05_JSONParser {
	public static void main(String[] args) {
		String jsonData = "{\"Persons\":[{\"name\":\"고경태\",\"age\":\"30\",\"블로그\":\"ktko.tistory.com\",\"gender\":\"남자\"},"
				+ "{\"name\":\"이홍준\",\"age\":\"31\",\"블로그\":\"없음\",\"gender\":\"남자\"},"
				+ "{\"name\":\"서정윤\",\"age\":\"30\",\"블로그\":\"없음\",\"gender\":\"여자\"}],"
				+ "\"Books\":[{\"name\":\"javascript의모든것\",\"price\":\"10000\"},"
				+ "{\"name\":\"java의모든것\",\"price\":\"15000\"}]}";
		
		try {
			JSONParser jsonParser = new JSONParser();
			
			// JSONParser에 json데이터를 넣어 파싱한 다음 JSONObject로 변환한다.
			JSONObject jsonObj = (JSONObject)jsonParser.parse(jsonData);
			
			//Persons이 배열로 되어있으므로 JSONArray
			JSONArray personArray = (JSONArray) jsonObj.get("Persons");
			for (int i = 0; i < personArray.size(); i++) {
				System.out.println("===== person : " + i + " =====");
				JSONObject person_obj = (JSONObject) personArray.get(i);
				System.out.println("이름 : " + person_obj.get("name"));
				System.out.println("나이 : " + person_obj.get("age"));
				System.out.println("블로그 : " + person_obj.get("블로그"));
				System.out.println("성별 : " + person_obj.get("gender"));
			}

			JSONArray booksArray = (JSONArray) jsonObj.get("Books");
			for (int i = 0; i < booksArray.size(); i++) {
				System.out.println("===== Books : " + i + " =====");
				JSONObject book_obj = (JSONObject) booksArray.get(i);
				System.out.println("제목 : " + book_obj.get("name"));
				System.out.println("가격 : " + book_obj.get("price"));
			}
		} catch (Exception e) {
		}
	}
}
