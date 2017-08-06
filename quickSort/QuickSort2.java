package quickSort;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class QuickSort2 {
	int count;

	/**
	 * @param a
	 * @param start
	 *            ����ʼλ����0��ʼ����
	 * @param end
	 *            û��ʵ�֣� ��Ϊ �ɵ����λ������� ����
	 */
	public void random_partition(int[] a, int start, int end) {
		if (start < end) {
			count++;
			Random r = new Random();
			int poirt_index = r.nextInt(end - start) + start;
			// int poirt_index = start;
			System.out.println("start:" + start + " end��" + end
					+ " poirt_index��" + poirt_index);
			// �ѻ��������
			swap(a, poirt_index, end);
			// iָ��ָ�򽻻���λ��
			int i = start;
			// �����бȻ���С���������
			// �ӵ�start+1λ��ʼ�Ƚϣ��������ڶ�λ���� �����i����ӵ�һ����ʼ�����������ͷ����С�ľ�û�б�˳��iָ��������ȷ��ÿ����ߵ�ֵ���Ȼ���С
			for (int j = start; j < end; j++) {
				if (a[end] > a[j]) {
					// ��strat�ĵڶ�λ��ʼ����
					swap(a, i++, j);
				}
			}
			// ����λ��ȷ������λ�����Ļ���������
			swap(a, i, end);
			random_partition(a, start, i - 1);
			random_partition(a, i + 1, end);
		}
	}

	public void swap(int[] a, int i, int j) {
		int temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		System.out.println(Arrays.toString(a));
	};

	@Test
	public void testQuicksort() {
		// i++ �����ж� �ڼ�1
		// int[] a = { 24, 5, 1, 2, 5, 7, 8, 5, 3, 7, 63, 9, 0, 42, 3, 8, 24, 1
		// };
		int[] a = { 5, 4, 3, 2, 1 };
		long start = System.currentTimeMillis();
		random_partition(a, 0, a.length - 1);
		long end = System.currentTimeMillis();
		System.out.println(Arrays.toString(a));
		System.out.println("Ƕ�״�����" + count + "��ʱ" + (end - start));
	}

	@Test
	public void test_random() {
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			// nextInt(2)��ʾ������ķ�Χ Ĭ�ϴ�0��ʼ��������������
			System.out.println(r.nextInt(2));
		}

	}

}
