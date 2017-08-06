package quickSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class QuickSort {
	static int count;

	/**
	 * ���Զ�����Ϳ��ŵ���ʱ ���Խ���� 80000��int�����������16ms����ʱ����31ms�����������31ms
	 * 800000��int�����������188ms������93ms�� 8000000��int�����������4102ms������951ms��
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 1���������������
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Random r = new Random(1);
		for (int i = 0; i < 10000; i++) {
			arr.add(r.nextInt());
//		    arr.add(0);
		}
		Object[] a = arr.toArray();
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			b[i] = (int) a[i];
		}
		long start = System.currentTimeMillis();
		// heapSort(b);
		quicksort(b, 0, b.length - 1);// ���鳤��:100000��ʱ:16
		// selectSort(b); //�����鳤��:100000��ʱ:8346
		long end = System.currentTimeMillis();
		long time = end - start;
		// ���� bug������Ϊ �ѳ�������� ��� a.length-1 ��
		System.out.println("��������鳤��:" + b.length + "��ʱ:" + time);
		// for (int i : b) {
		// System.out.print(i+",");
		// }
	}

	@Test
	public void testQuicksort() {
		// i++ �����ж� �ڼ�1
		// int[] a = { 24, 5, 1, 2, 5, 7, 8, 5, 3, 7, 63, 9, 0, 42, 3, 8, 24, 1
		// };
		int[] a = { 0, 0, 0, 0, 0, 0, 0, 0 };
		List<Integer> l = new ArrayList<Integer>();

		for (int i = 0; i < 10000; i++) {
			l.add(0);
		}
		long start = System.currentTimeMillis();
		quicksort(a, 0, a.length - 1);
		long end = System.currentTimeMillis();
		System.out.println(Arrays.toString(a));
		System.out.println("Ƕ�״�����" + count + "��ʱ" + (end - start));
	}

	/**
	 * ����ʵ�ּ���
	 * 
	 * @param n
	 * @param left
	 * @param right
	 */
	static void quicksort(int[] n, int left, int right) {
		// System.out.println("QuickSort.quicksort()" + (++count));
		count++;
		if (left < right) {
			// ��һ���±�������ʱ�洢 i��ʾ��ָ�룬j��ʾ��ָ��
			int i = left, j = right;
			/* ȷ��һ����׼��������������С���ڻ�׼������ ** */
			// 1��pivot����׼���� ����ߵ�һ����Ϊ��׼��
			int pivot = n[left];// ����25�� ˵�����м俪ʼ�� ���ٿռ临�Ӷ�
			// int pivot = n[(right-left)>>1];// ���м�λΪ��׼��
			// QuickSort.quicksort()21 ����21��
			while (i < j) {
				// 2�����ҿ�ʼ����������С������
				while (i < j && n[j] >= pivot)
					j--;
				if (i < j)
					// ������ڻ�׼λ
					n[i++] = n[j];
				// 3���ٴ���������������������
				while (i < j && n[i] <= pivot)
					i++;
				if (i < j)
					// �����ұߵĿ�λ
					n[j--] = n[i];
			}
			// 4�������� ����ָ����ȣ�����׼�����ڸ�λ�á�
			n[i] = pivot;
			/* �������һ�Σ��������ڻ�׼�����ԡ� ���½��з��Σ��Ի�׼λΪ�ֽ�㣬���ߵ��� �ݹ�������� */
			quicksort(n, left, i - 1);
			quicksort(n, i + 1, right);
		}
	}

	/**
	 * @param a
	 *            ��Ҫ����Ķ�
	 * 
	 */
	private static void heapSort(int[] a) {
		// ����� b�������õ� a ������Ҫ newһ��
		int[] b = new int[a.length];
		// 1.������,�����һ����ʼ����
		for (int i = (a.length >> 1); i >= 1; i--) {
			siftDown(a, i, a.length);
		}
		// 2.��ʼȡ�����ҵ���
		for (int i = a.length - 1; i >= 0; i--) {
			// ��һ����������,ȡ����һ����
			b[i] = a[0];
			// �����һ�����ŵ� ���ڵ㣬�������µ���
			a[0] = a[i];
			siftDown(a, 1, i);
		}
		// �ٰ�b�����ֵ���� a
		for (int i = 0; i < a.length; i++) {
			a[i] = b[i];
		}
	}

	/**
	 * ���µ���
	 * 
	 * @param a
	 *            ��Ҫ����������
	 * @param i
	 *            �ӵ�i����ʼ����
	 * @param n
	 *            ����ѵĳ��� ����һ����Ҫ���µ����ı�� ����i���ڵ㣬����Ϊ�� ���� ���ӽڵ�Ϊ2��i�� ���ӽڵ�Ϊ 2*i+1 �� ��
	 *            �� n/2 ��ʼ���
	 */
	private static void siftDown(int[] a, int i, int n) {
		int t = i;// �洢���ֵ�� ���
		// ��i�ڵ����ӽڵ�ʱ����ִ�У�
		while (i * 2 <= n) { // ע�⣬�˴�Ӧ���еȺţ����������©�����һ��
			// �ж����ӽڵ㣬tȡ��Ľڵ� ��������
			if (a[i - 1] < a[i * 2 - 1]) {
				t = i * 2;
			}
			// ��������ӽڵ�,tȡ��Ľڵ�
			if ((i * 2 + 1) <= n) {
				t = (a[t - 1] > a[i * 2]) ? t : (i * 2 + 1);
			}
			// ���t�����䱾����˵���Ѿ��������
			if (t == i) {
				break;
			} else {
				// ���򽻻������� ��t��i �������µ���
				a[i - 1] = a[t - 1] + a[i - 1];
				a[t - 1] = a[i - 1] - a[t - 1]; // ��ʱ a[t]����a[i]
				a[i - 1] = a[i - 1] - a[t - 1];
				i = t;
			}
		}
	};

	/**
	 * @param values
	 * @param left
	 * @param right
	 */
	public static void quicksort2(int[] values, int left, int right) {
		// ��׼��
		count++;
		if (left < right) {
			// ��׼��
			int dp = partition2(values, left, right);
			quicksort2(values, left, dp - 1);
			quicksort2(values, dp + 1, right);
		}

	}

	/**
	 * ȷ����׼��
	 * 
	 * @param values
	 * @param left
	 * @param right
	 * @return
	 */
	private static int partition2(int[] values, int left, int right) {

		int pivot = values[left]; // ����λ�൱�ڳ���
		System.out.println("��׼��=" + pivot);
		int db = left; // ��׼λ
		while (left < right) {
			// �ȴ��ұ߿�ʼ ��ֱ�������Ȼ�׼��С��
			while (left < right && values[right] >= pivot) {
				right--;
			}
			// �ٴ���߿�ʼ �������Ȼ�׼�����
			while (left < right && values[left] <= pivot) {
				left++;
			}
			if (left < right) {
				// ��������
				System.out.println("left:" + left + "right:" + right);
				int temp = values[right];
				values[right] = values[left];
				values[left] = temp;
			}
		}
		// ��ʱleft=right
		System.out.println("��ʱ������ȣ�left:" + left + "right:" + right);
		// ����׼λ�� left����
		int temp2 = values[left];
		values[left] = values[db];
		values[db] = temp2;

		return left;
	}

	static int partition(int n[], int left, int right) {
		int pivot = n[left];
		while (left < right) {
			while (left < right && n[right] >= pivot)
				right--;
			if (left < right)
				n[left++] = n[right];
			while (left < right && n[left] <= pivot)
				left++;
			if (left < right)
				n[right--] = n[left];
		}
		n[left] = pivot;
		return left;
	}

	static int AdjustArray(int s[], int l, int r) // ���ص������׼����λ��
	{
		int i = l, j = r;
		int x = s[l]; // s[l]��s[i]���ǵ�һ����
		while (i < j) {
			// ����������С��x��������s[i]
			while (i < j && s[j] >= x)
				j--;
			if (i < j) {
				s[i] = s[j]; // ��s[j]�s[i]�У�s[j]���γ���һ���µĿ�
				i++;
			}

			// ���������Ҵ��ڻ����x��������s[j]
			while (i < j && s[i] < x)
				i++;
			if (i < j) {
				s[j] = s[i]; // ��s[i]�s[j]�У�s[i]���γ���һ���µĿ�
				j--;
			}
		}
		// �˳�ʱ��i����j����x�������С�
		s[i] = x;

		return i;
	}

	/**
	 * ð������
	 * 
	 * @param values
	 */
	public static void paosort(int[] values) {
		for (int i = 0; i < values.length; i++) {
			for (int j = i + 1; j < values.length; j++) {
				if (values[i] > values[j]) {
					int temp = values[j];
					values[j] = values[i];
					values[i] = temp;
				}

			}
		}

	}

	public static void selectSort(int[] values) {

		int min_pos;
		for (int i = 0; i < values.length; i++) {
			min_pos = i;
			// �����ҳ� ��Сֵ������Сֵ��ֵ�� tempMin
			for (int j = i + 1; j < values.length; j++) {
				if (values[j] < values[min_pos]) {
					min_pos = j;
				}
			}
			// ��ʱ temp_posΪ��Сֵ����λ�ã�������i����
			// ���˳����ˣ��򽻻�
			if (i != min_pos) {
				values[i] = values[i] + values[min_pos];
				values[min_pos] = values[i] - values[min_pos];// (values[i])
				values[i] = values[i] - values[min_pos];
			}
		}

	}

}
