package day02.com.ict.edu;
class Ex01 {
	public static void main(String[] args) {
// �ּ� : ���������� �ʴ� ��, ������ ������ ������ �� ���
// ���� : ���α׷��� ���� ������ �������� ���� �� �ִ� ����
// ���� : �ڷ��� �����̸� ;
// �����̸� = �� ������ ;		

	// �� �ڷ����� ����
	boolean b1;
	b1 = true;

	//b1�� ȣ���غ���
	// **�̸��� ȣ���ϸ� �����Ͱ� ���´�.
	System.out.println(b1);

	//b1�� ���¸� true���� false�� ��������
	//boolean b1; // b1�̶�� �̸����� ������ �ѹ��� ����
	b1 = false;
	System.out.println(b1);

	//����� ������ �� ����
	boolean b2 = true;
	System.out.println(b2);

	//������ ���� �� �Ǿ������� ������ �� ��
	b2 = false;
	System.out.println(b2);

	boolean b3;

	//error: incompatible types: int cannot be converted to boolean
	//b3 = 10;

	//error: incompatible types: double cannot be converted to boolean
	//b3 = 10.0;

	b3 = false;
	System.out.println(b3);
	}
}