package duotai;

import org.junit.Test;

public class TestIndexFunction {
	@Test
	public void testIndex() throws Exception {
		// Ŀ�� �� 2�� ���ٴη���һ�γ���һ��
		int count = 1;
		/*
		 * while((index(2,count)<10000)){ count++; } System.out.println(count);
		 * System.out.println(index(2,14));
		 */

		if (index(2, count) < 10000) {
			count++;
		}
		System.out.println(count);
	}

	/**
	 * ָ������
	 * 
	 * @param di
	 *            ����
	 * @param zhi
	 *            ָ��
	 * @return
	 */
	private static long index(int di, int zhi) {
		long result = 1;
		for (int i = 0; i < zhi; i++) {
			result = result * di;
		}
		return result;
	}

}
