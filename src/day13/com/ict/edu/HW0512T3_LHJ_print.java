package day13.com.ict.edu;

//숫자 야구 게임의 모습을 콘솔창에 출력하는 기능
public class HW0512T3_LHJ_print {
	public static void printScreen(int count) {
		String num = "① ② ③ ④ ⑤ ⑥ ⑦ ⑧ ⑨ ⑩ ⑪ ⑫ ⑬ ⑭ ⑮ ⑯ ⑰ ⑱ ⑲ ⑳ ❶ ❷ ❸ ❹ ❺ ❻ ❼ ❽ ❾ ❿ ⓫ ⓬ ⓭ ⓮ ⓯ ⓰ ⓱ ⓲ ⓳ ⓴";
		String[] numArr = num.split(" ");
		int length = numArr.length;

		System.out.print(" ※9회말※");
		System.out.printf("%15s", "※2OUT※");
		System.out.printf("\n%12s", "플레이어 6 : ");
		if (count < 5)
			System.out.print(0);
		else
			System.out.print(count - 4);
		System.out.print(" 컴퓨터");
		System.out.println();

		switch (count) {
		case 1:
			System.out.println(" ◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼");
			System.out.println(" ◼◼◼◼◼◼◼◼◿◇◺◼◼◼◼◼◼◼◼");
			System.out.println(" ◼◼◼◼◼◼◿◸■■■◹◺◼◼◼◼◼◼");
			System.out.println(" ◼◼◼◼◿◸■■■■■■■◹◺◼◼◼◼");
			System.out.println(" ◼◼◿◸■■■■■■■■■■■◹◺◼◼");
			System.out.println(" ◼◇■■■■■■■◉■■■■■■■◇◼");
			System.out.println(" ◼◼◹◺■■■■■■■■■■■◿◸◼◼");
			System.out.println(" ◼◼◼◼◹◺■■■■■■■◿◸◼◼◼◼");
			System.out.println(" ◼◼◼◼◼◼◹◺■■■◿◸◼◼◼◼◼◼");
			System.out.println(" ◼◼◼◼◼◼◼◼◹▣◸◼◼◼◼◼◼◼◼");
			System.out.println(" ◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼");
			break;

		case 2:
			System.out.println(" ◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼");
			System.out.println(" ◼◼◼◼◼◼◼◼◿◇◺◼◼◼◼◼◼◼◼");
			System.out.println(" ◼◼◼◼◼◼◿◸■■■◹◺◼◼◼◼◼◼");
			System.out.println(" ◼◼◼◼◿◸■■■■■■■◹◺◼◼◼◼");
			System.out.println(" ◼◼◿◸■■■■■■■■■■■◹◺◼◼");
			System.out.println(" ◼◇■■■■■■■◉■■■■■■■①◼");
			System.out.println(" ◼◼◹◺■■■■■■■■■■■◿◸◼◼");
			System.out.println(" ◼◼◼◼◹◺■■■■■■■◿◸◼◼◼◼");
			System.out.println(" ◼◼◼◼◼◼◹◺■■■◿◸◼◼◼◼◼◼");
			System.out.println(" ◼◼◼◼◼◼◼◼◹▣◸◼◼◼◼◼◼◼◼");
			System.out.println(" ◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼");
			break;

		case 3:
			System.out.println(" ◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼");
			System.out.println(" ◼◼◼◼◼◼◼◼◿①◺◼◼◼◼◼◼◼◼");
			System.out.println(" ◼◼◼◼◼◼◿◸■■■◹◺◼◼◼◼◼◼");
			System.out.println(" ◼◼◼◼◿◸■■■■■■■◹◺◼◼◼◼");
			System.out.println(" ◼◼◿◸■■■■■■■■■■■◹◺◼◼");
			System.out.println(" ◼◇■■■■■■■◉■■■■■■■②◼");
			System.out.println(" ◼◼◹◺■■■■■■■■■■■◿◸◼◼");
			System.out.println(" ◼◼◼◼◹◺■■■■■■■◿◸◼◼◼◼");
			System.out.println(" ◼◼◼◼◼◼◹◺■■■◿◸◼◼◼◼◼◼");
			System.out.println(" ◼◼◼◼◼◼◼◼◹▣◸◼◼◼◼◼◼◼◼");
			System.out.println(" ◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼");
			break;

		case 4:
			System.out.println(" ◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼");
			System.out.println(" ◼◼◼◼◼◼◼◼◿②◺◼◼◼◼◼◼◼◼");
			System.out.println(" ◼◼◼◼◼◼◿◸■■■◹◺◼◼◼◼◼◼");
			System.out.println(" ◼◼◼◼◿◸■■■■■■■◹◺◼◼◼◼");
			System.out.println(" ◼◼◿◸■■■■■■■■■■■◹◺◼◼");
			System.out.println(" ◼①■■■■■■■◉■■■■■■■③◼");
			System.out.println(" ◼◼◹◺■■■■■■■■■■■◿◸◼◼");
			System.out.println(" ◼◼◼◼◹◺■■■■■■■◿◸◼◼◼◼");
			System.out.println(" ◼◼◼◼◼◼◹◺■■■◿◸◼◼◼◼◼◼");
			System.out.println(" ◼◼◼◼◼◼◼◼◹▣◸◼◼◼◼◼◼◼◼");
			System.out.println(" ◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼");
			break;

		default:
			count = Math.abs(count - 5);
			System.out.println(" ◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼");
			System.out.println(" ◼◼◼◼◼◼◼◼◿" + numArr[(count + 2) % length] + "◺◼◼◼◼◼◼◼◼");
			System.out.println(" ◼◼◼◼◼◼◿◸■■■◹◺◼◼◼◼◼◼");
			System.out.println(" ◼◼◼◼◿◸■■■■■■■◹◺◼◼◼◼");
			System.out.println(" ◼◼◿◸■■■■■■■■■■■◹◺◼◼");
			System.out.println(
					" ◼" + numArr[(count + 1) % length] + "■■■■■■■◉■■■■■■■" + numArr[(count + 3) % length] + "◼");
			System.out.println(" ◼◼◹◺■■■■■■■■■■■◿◸◼◼");
			System.out.println(" ◼◼◼◼◹◺■■■■■■■◿◸◼◼◼◼");
			System.out.println(" ◼◼◼◼◼◼◹◺■■■◿◸◼◼◼◼◼◼");
			System.out.println(" ◼◼◼◼◼◼◼◼◹" + numArr[count % length] + "◸◼◼◼◼◼◼◼◼");
			System.out.println(" ◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼");
		}
	}
}
