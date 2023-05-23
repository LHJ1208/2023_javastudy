package day11.com.ict.edu;

public class HW0510LHJ_method { // 클래스 헤더
	// 멤버 필드//
	// instance 멤버 변수
	String name = ""; // 이름
	int kor = 0; // 국어점수
	int eng = 0; // 영어점수
	int math = 0; // 수학점수
	int sum = 0; // 총점
	double avg = 0.0; // 평균
	String grade = ""; // 학점
	int rank = 1; // 순위

	// 생성자// 생략 -> 기본 생성자

	// 멤버 메서드//
	// instance 멤버 메서드

	// setter 메서드

	void setName(String input) {
		name = input;
	}

	void setKor(int input) {
		kor = input;
	}

	void setEng(int input) {
		eng = input;
	}

	void setMath(int input) {
		math = input;
	}

	// 총점을 계산해서 멤버변수 sum에 저장하는 메서드
	void setSum() {
		sum = kor + eng + math;
	}

	void setSum(int inputKor, int inputEng, int inputMath) {
		setKor(inputKor);
		setEng(inputEng);
		setEng(inputMath);
		sum = kor + eng + math;
	}

	// 평균을 계산해서 멤버변수 avg에 저장하는 메서드
	void setAvg() {
		avg = (sum * 10 / 3) / 10.0;
	}

	// 메서드 오버로딩
	void setAvg(int inputKor, int inputEng, int inputMath) {
		setSum(inputKor, inputEng, inputMath);
		avg = (sum * 10 / 3) / 10.0;
	}

	// 학점을 계산해서 멤버변수 grade에 저장하는 메서드
	void setGrade() {
		if (avg >= 90)
			grade = "A";
		else if (avg >= 80)
			grade = "B";
		else if (avg >= 70)
			grade = "C";
		else
			grade = "F";
	}

	// 메서드 오버로딩
	void setGrade(int inputKor, int inputEng, int inputMath) {
		setAvg(inputKor, inputEng, inputMath);
		if (avg >= 90)
			grade = "A";
		else if (avg >= 80)
			grade = "B";
		else if (avg >= 70)
			grade = "C";
		else
			grade = "F";
	}

	void setRank(int input) {
		rank = input;
	}

	// getter 메서드
	String getName() {
		return name;
	}

	int getKor() {
		return kor;
	}

	int getEng() {
		return eng;
	}

	int getMath() {
		return math;
	}

	int getSum() {
		return sum;
	}

	double getAvg() {
		return avg;
	}

	String getGrade() {
		return grade;
	}

	int getRank() {
		return rank;
	}

	// HW0510LHJ_method class 멤버필드들의 정보를 하나의 문자열로 합쳐서 반환한다.
	public String toString() {
		String result = "";
		result += name + "\t";
		result += kor + "\t";
		result += eng + "\t";
		result += math + "\t";
		result += sum + "\t";
		result += avg + "\t";
		result += grade + "\t";
		result += rank;

		return result;
	}

	// 멤버변수 rank의 값을 1 증가시킨다
	void rankUp() {
		rank++;
	}
}
