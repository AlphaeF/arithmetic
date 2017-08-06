package quickSort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import org.junit.Test;

public class QuickSort1 {
	int count = 0;

	@Test
	public void testQuicksort() {
		// i++ �����ж� �ڼ�1
		int[] a = { 24, 5, 1, 2, 5, 7, 8, 5, 3, 7, 63, 9, 0, 42, 3, 8, 24, 1 };
		long start = System.currentTimeMillis();
		quicksort2(a, 0, a.length - 1);
		long end = System.currentTimeMillis();
		System.out.println(Arrays.toString(a));
		System.out.println("Ƕ�״�����" + count + "��ʱ" + (end - start));
	}

	/**
	 * @param a
	 *            Ŀ������
	 * @param left
	 *            ��߽�
	 * @param right
	 *            �ұ߽�
	 */
	public void quicksort(int[] a, int left, int right) {
		count++;
		// ���������ж�
		if (left < right) {
			// �����ұ߽�ֱ𽻸��±������������
			int i = left, j = right;
			// ����Ϊ��׼λΪ��ߵ�һ��,����׼ֵ��������
			int piot = a[i];
			// ����һ������¿�ʼ�ң�ֱ��i=j
			while (i < j) {
				// �ȴ��ұ߿�ʼ���ұȻ�׼��С������ע�ⲻ����ȣ���Ȼ��Ļ��ͻ��������Ƚ�
				// ����ѭ��ֻ�����������Ҫôi=j Ҫô�ҵ��Ȼ���С����
				while (piot >= a[j] && i < j) {
					j--;
				}
				// �ҵ��ˣ�������������׼λ,��ֵǰ���жϣ��ų� i=j�����
				if (i < j) {
					a[i++] = a[j]; // ��i++ ����һ��ѭ������һ���Ƚϣ��Ż���
				}
				// �ٴ���߿�ʼ�ұȻ�׼�������
				// ����ѭ��ֻ�����������Ҫôi=j Ҫô�ҵ��Ȼ��������
				while (piot <= a[i] && i < j) {
					i++;
				}
				// �ҵ��ˣ�������������׼λ,��ֵǰ���жϣ��ų� i=j�����
				if (i < j) {
					a[j--] = a[i];
				}
			}
			// ����ѭ���� ˵��i=j �ˣ��Ѿ��ҵ���׼����λ���� ��������
			a[i] = piot;// or a[j]=poit
			quicksort(a, left, i - 1);
			quicksort(a, i + 1, right);
		}
	}

	public int findPivot(int[] a, int left, int right) {
		// ����Ϊ��׼λΪ��ߵ�һ��,����׼ֵ��������
		// int index = (left + right) / 2;
		int index = left;
		// int index=(new Random().nextInt(right-left))+left;
		// Ҫ����Ļ���ֻ��ѵ�һ��Ԫ�أ��� left��right�����һ��Ԫ�� ��λ��;
		int piot = a[index];
		// ����һ������¿�ʼ�ң�ֱ��i=j
		while (left < right) {
			// �ȴ��ұ߿�ʼ���ұȻ�׼��С������ע�ⲻ����ȣ�
			// ����ѭ��ֻ�����������Ҫôi=j Ҫô�ҵ��Ȼ���С����
			while (a[right] >= piot && left < right) {
				right--;
			}
			// �ٴ���߿�ʼ�ұȻ�׼�������
			// ����ѭ��ֻ�����������Ҫôi=j Ҫô�ҵ��Ȼ��������
			while (a[left] <= piot && left < right) {
				left++;
			}
			// �ҵ��ˣ����������λ�õ���,��ֵǰ���жϣ��ų� i=j�����
			if (left < right) {
				swap(a, left, right);
				System.out.println(count + ":index" + index + " left:" + left
						+ " right:" + right + Arrays.toString(a));
			}
		}
		// ����ѭ��˵������ָ����ȣ�����׼λ�����λ��
		// a[index] = piot;
		// a[left]=piot;
		swap(a, index, left);
		System.out.println(count + "�� left:" + left + "index:" + index
				+ Arrays.toString(a));
		return left;
	}

	public void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private void quicksort2(int[] a, int left, int right) {
		count++;
		// ���������ж�
		if (left < right) {
			int pivot = findPivot(a, left, right);
			quicksort2(a, left, pivot - 1);
			quicksort2(a, pivot + 1, right);
		}
	}
}