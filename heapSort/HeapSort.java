package heapSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @author Administrator
 *
 *         ������
 */
public class HeapSort {
	/****************************************************/
	public int[] heapSort(int[] a) {
		int n = a.length;//����ѵĳ���Ϊ���鳤��
		int[] b = new int[n];// ����һ�����������������õ�Ԫ��
		// ������
		for (int i = (n / 2); i > 0; i--) {
			sortDown(a, a.length, i);
		}
		// ɾ����Ԫ��,������������
		for (int i = 0; i < a.length; i++) {
			b[i] = a[0];
			if (n > 0) {
				a[0] = a[--n];// ����ĩ�����ŵ�����λ, ��--n ����Ϊ������±�ͶѲ�һ����Ҫ����1
				sortDown(a, n, 1);
			}
		}
		return b;
	}

	/**
	 * @param a
	 *            �����ڵ�����
	 * @param n
	 *            �ѵĳ���
	 * @param i
	 *            ��Ҫ���������
	 */
	private void sortDown(int[] a, int n, int i) {
		// t������¼��ǰ�����Ľڵ���
		int t = i;
		// ���i�������ӽڵ�
		while ((i * 2) <= n) {
			t = a[i - 1] < a[2 * i - 1] ? i : (2 * i);
			// ����������ӽڵ�
			if ((2 * i + 1) <= n) {
				t = a[t - 1] < a[2 * i] ? t : (2 * i + 1);
			}
			if (t != i) {
				int temp = a[i - 1];
				a[i - 1] = a[t - 1];
				a[t - 1] = temp;
				// �������µ���
				i = t;
			} else {
				return;
			}
		}
	}
	/****************************************************/

	/**
	 * Ҫ���������
	 */
	private int[] a;
	/**
	 * Ĭ�϶ѵĳ��ȣ���0 ��n
	 */
	private int n;
	/**
	 * �洢����õ�����
	 */
	private List<Integer> b = new ArrayList<Integer>();

	/**
	 * ������
	 */
	public List<Integer> heapsort(int[] a) {
		this.a = a;
		n = a.length;
		creatHeap();
		for (int i = 0; i < a.length; i++) {
			deleteFirst();
		}
		for (int i = 0; i < a.length; i++) {
			a[i] = b.get(i);
		}
		return b;
	}

	/**
	 * ɾ����СԪ��
	 * 
	 * @param a
	 * @param n
	 * 
	 */
	private void deleteFirst() {
		b.add(a[0]);
		// ����ĩ�����ŵ�����λ
		// ��--n ����Ϊ������±�ͶѲ�һ����Ĭ�ϳ���-1
		if (n > 0) {
			a[0] = a[--n];
			sortDown(1);
		}
	}

	/**
	 * @param i
	 *            ������ʼ���µ�������� ���µ��� Ϊ��С��
	 * 
	 *            ������ i�� ���ӽڵ� 2i ���ӽڵ� 2i+1
	 */
	private void sortDown(int i) {
		// t������¼��ǰ�����Ľڵ���
		int t = i;
		// ���i�������ӽڵ�
		while ((i * 2) <= n) {
			t = a[i - 1] < a[2 * i - 1] ? i : (2 * i);
			// ����������ӽڵ�
			if ((2 * i + 1) <= n) {
				t = a[t - 1] < a[2 * i] ? t : (2 * i + 1);
			}
			if (t != i) {
				swap(a, i - 1, t - 1);
				// �������µ���
				i = t;
			} else {
				return;
			}
		}
	}

	/**
	 * nΪ�ѵı߽�
	 *  ������
	 */
	private void creatHeap() {
		for (int i = (n / 2); i > 0; i--) {
			sortDown(i);
		}
	}

	private void swap(int[] a, int i, int j) {
		int temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	@Test
	public void test() {
		// i++ �����ж� �ڼ�1
		int[] a = { 24, 5, 1, 2, 24, 5, 1, 2, 5, 7, 8, 5, 3, 7, 63, 9, 0, 42,
				3, 8, 24, 1 };
		// int[] a = { 5, 4, 3, 2, 1 };
		long start = System.currentTimeMillis();
		System.out.println(Arrays.toString(heapSort(a)));
		long end = System.currentTimeMillis();
		System.out.println("��ʱ:" + (end - start));
	}
}
