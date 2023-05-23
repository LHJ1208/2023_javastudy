package day11.com.ict.edu;

public class Ex07_method {
	int sum = 0;
	double avg = 0.0;
	String hak = "";
	
	//총점을 구하는 메서드
	void getSum(int kor, int eng, int math) {
		sum = kor + eng + math;
	}
	
	//평균을 구하는 메서드
	void getAvg() {
		avg = (sum * 10 / 3) / 10.0;
	}
	void getAvg(int inputSum) {
		avg = (inputSum * 10 / 3) / 10.0;
	}
	
	//학점을 구하는 메서드
	void getHak() {
		if (avg >= 90)
			hak = "A";
		else if (avg >= 80)
			hak = "B";
		else if (avg >= 70)
			hak = "C";
		else
			hak = "F";
	}
	
	void getHak(double inputAvg) {
		if (inputAvg >= 90)
			hak = "A";
		else if (avg >= 80)
			hak = "B";
		else if (avg >= 70)
			hak = "C";
		else
			hak = "F";
	}
}
