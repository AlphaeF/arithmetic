package duotai;

import org.junit.Test;

public class App {

	public static void main(String args[]) {
		Father f = new SonA();
		// �˴����� ����д�� �ӷ���
		f.method();
		f = new SonB();
		f.method();
		f.methodFather();
		f = (Father) f;
		// �˴��ײ㻹�ǵ��õ��� sonB;
		f.method();
	}

	@Test
	public void testSizeof() {
		boolean a;
		byte b;
		char c;
		short d;
		int e;
		float f;
		long g;
		double h;
		System.out.println(Byte.SIZE / 8);
		System.out.println(Short.SIZE / 8);
		System.out.println(Character.SIZE / 8);
		System.out.println(Integer.SIZE / 8);
		System.out.println(Float.SIZE / 8);
		System.out.println(Long.SIZE / 8);
		System.out.println(Double.SIZE / 8);
	}
}
