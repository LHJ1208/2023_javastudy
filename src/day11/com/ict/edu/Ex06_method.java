package day11.com.ict.edu;

public class Ex06_method {
	// 총점을 계산해서 반환하는 메서드
	int getSum(int kor, int eng, int math) {
		return kor + eng + math;
	}

	// korArr, engArr, mathArr 각각 배열의 length가 같아야 정상작동함
	int[] getSum(int[] korArr, int[] engArr, int[] mathArr) {
		int length = korArr.length;
		int[] result = new int[length];

		for (int i = 0; i < length; i++) {
			result[i] = korArr[i] + engArr[i] + mathArr[i];
		}

		return result;
	}

	// 평균을 계산해서 반환하는 메서드
	double getAvg(int kor, int eng, int math) {
		return ((kor + eng + math) * 10 / 3) / 10.0;
	}

	double getAvg(int sum) {
		return (sum * 10 / 3) / 10.0;
	}

	// korArr, engArr, mathArr 각각 배열의 length가 같아야 정상작동함
	double[] getAvg(int[] korArr, int[] engArr, int[] mathArr) {
		int length = korArr.length;
		double[] result = new double[length];
		int[] sumArr = new int[length];

		for (int i = 0; i < length; i++) {
			sumArr[i] = korArr[i] + engArr[i] + mathArr[i];
			result[i] = (sumArr[i] * 10 / 3) / 10.0;
		}

		return result;
	}

	double[] getAvg(int[] sumArr) {
		int length = sumArr.length;
		double[] result = new double[length];

		for (int i = 0; i < length; i++) {
			result[i] = (sumArr[i] * 10 / 3) / 10.0;
		}

		return result;
	}

	// 학점을 구해서 반환하는 메서드
	String getGrade(int kor, int eng, int math) {
		String result = "";
		double avg = ((kor + eng + math) * 10 / 3) / 10.0;

		if (avg >= 90)
			result = "A";
		else if (avg >= 80)
			result = "B";
		else if (avg >= 70)
			result = "C";
		else
			result = "F";

		return result;
	}

	String getGrade(int sum) {
		String result = "";
		double avg = (sum * 10 / 3) / 10.0;

		if (avg >= 90)
			result = "A";
		else if (avg >= 80)
			result = "B";
		else if (avg >= 70)
			result = "C";
		else
			result = "F";

		return result;
	}

	String getGrade(double avg) {
		String result = "";

		if (avg >= 90)
			result = "A";
		else if (avg >= 80)
			result = "B";
		else if (avg >= 70)
			result = "C";
		else
			result = "F";

		return result;
	}

	// korArr, engArr, mathArr 각각 배열의 length가 같아야 정상작동함
	String[] getGrade(int[] korArr, int[] engArr, int[] mathArr) {
		int length = korArr.length;
		String[] result = new String[length];
		double[] avgArr = new double[length];
		int[] sumArr = new int[length];

		for (int i = 0; i < length; i++) {
			sumArr[i] = korArr[i] + engArr[i] + mathArr[i];
			avgArr[i] = (sumArr[i] * 10 / 3) / 10.0;
		}

		for (int i = 0; i < length; i++) {
			if (avgArr[i] >= 90)
				result[i] = "A";
			else if (avgArr[i] >= 80)
				result[i] = "B";
			else if (avgArr[i] >= 70)
				result[i] = "C";
			else
				result[i] = "F";
		}

		return result;
	}

	String[] getGrade(int[] sumArr) {
		int length = sumArr.length;
		String[] result = new String[length];
		double[] avgArr = new double[length];

		for (int i = 0; i < length; i++) {
			avgArr[i] = (sumArr[i] * 10 / 3) / 10.0;
		}

		for (int i = 0; i < length; i++) {
			if (avgArr[i] >= 90)
				result[i] = "A";
			else if (avgArr[i] >= 80)
				result[i] = "B";
			else if (avgArr[i] >= 70)
				result[i] = "C";
			else
				result[i] = "F";
		}

		return result;
	}

	String[] getGrade(double[] avgArr) {
		int length = avgArr.length;
		String[] result = new String[length];

		for (int i = 0; i < length; i++) {
			if (avgArr[i] >= 90)
				result[i] = "A";
			else if (avgArr[i] >= 80)
				result[i] = "B";
			else if (avgArr[i] >= 70)
				result[i] = "C";
			else
				result[i] = "F";
		}

		return result;
	}
}
