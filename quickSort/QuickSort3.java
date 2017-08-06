package quickSort;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class QuickSort3 {
	int count;

	/**
	 * ����棬�����Ƽ�
	 * 
	 * @param a
	 * @param left
	 * @param right
	 */
	public void quickSort1(int[] a, int left, int right) {
		if (left >= right) {
			return;
		}
		int i = left;
		int pivot = a[right];
		for (int j = left; j < right; j++) {
			if (pivot > a[j]) {
				swap(a, i++, j);
			}
		}
		swap(a, i, right);
		quickSort1(a, left, i - 1);
		quickSort1(a, i + 1, right);
	}

	private void swap(int[] a, int i, int j) {
		int temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	/**
	 * �����������
	 * 
	 * @param a
	 * @param left
	 * @param right
	 */
	public void quickSort2(int[] a, int left, int right) {
		if (left >= right) { // ���жϱ߽磬Ҫ��������鳤������Ϊ2
			return;
		}
		count++;
		// ������ǰ���������һ�»�׼ֵ����׼ֵλ��Ĭ��Ϊ���ұ�
		Random r = new Random();
		int index = (r.nextInt(right - left)) + left;
		swap(a, index, right);

		int i = left; // ��ָ�룬��ָԪ�� �����Ѿ�ȷ���ñȻ�׼ֵС�����������׼ֵѡ�˸���Сֵ��Ҳ�����һ��ֵ����
		int pivot = a[right];// �����ұߵ�ֵΪ��׼ֵ
		// ���������Ȼ�׼ֵС������һ�η������
		for (int j = left; j < right; j++) {
			if (pivot > a[j]) {
				swap(a, i++, j); // i++ �ƶ�ָ��
			}
		}
		swap(a, i, right); // ������ɺ���ȷ�Ϻ��˻�׼ֵ��λ��Ϊi���û�׼ֵ��λ
		quickSort1(a, left, i - 1); // �ݹ飬����
		quickSort1(a, i + 1, right);
	}

	/**
	 * �����ڰ� ����ָ�뽻��
	 * 
	 * @param a
	 *            ��Ҫ�����Ŀ������
	 * @param left
	 *            ��߽�
	 * @param right
	 *            �ұ߽�
	 */
	public void quickSort3(int[] a, int left, int right) {
		// ���жϱ߽磬Ҫ��������鳤������Ϊ2
		if (left >= right) {
			return;
		}
		// ����ߵ�һ����Ϊ��׼ֵ
		int pivot = a[left];
		// ������������ָ��
		int i = left, j = right;
		// ����ѭ��ʱi=j��˵���ҵ���׼����λ��
		while (i < j) {
			// ��Ϊ��׼ֵȷ��Ϊ��ߵ�һ��λ�ã�����Ҫ�ȴ��ұ�������ұȻ�׼ֵС����������ѭ�������������1 ���ҵ����������2�� i=j
			while (a[j] >= pivot && i < j) {
				j--;
			}
			// �ٴ������
			while (a[i] <= pivot && i < j) {
				i++;
			}
			if (i < j) {
				// ����λ��
				swap(a, i, j);
			}
		}
		// ����ѭ��˵��i=j,ָ������һ��Ҳ��ȷ�����˻�׼ֵ��λ�ã��û�׼ֵ��λ
		swap(a, i, left);
		// �ݹ���ã�����
		quickSort3(a, left, i - 1);
		quickSort3(a, i + 1, right);
	}
	
	/**
	 * ���Ÿ���Ч��
	 * @param a
	 * @param left
	 * @param right
	 */
	public void quickSort4(int[] a,int left,int right){
		if(left>=right){
			return;
		}
		int i=left,j=right;
		int pivot=a[left];
		while(i<j){
			while(a[j]>=pivot&&i<j){
				j--;
			}
			if(i<j){
				a[i++]=a[j];
			}
			while(a[i]<=pivot&&i<j){
				i++;
			}
			if(i<j){
				a[j--]=a[i];
			}
		}
		a[i]=pivot;
		quickSort4(a,left,i-1);
		quickSort4(a,i+1,right);
	}

	@Test
	public void testQuicksort() {
		// i++ �����ж� �ڼ�1
		int[] a = { 24, 5, 1, 2, 24, 5, 1, 2, 5, 7, 8, 5, 3, 7, 63, 9, 0, 42, 3, 8, 24, 1 };
		// int[] a = { 5, 4, 3, 2, 1 };
		long start = System.currentTimeMillis();
		quickSort4(a, 0, a.length - 1);
		long end = System.currentTimeMillis();
		System.out.println(Arrays.toString(a));
		System.out.println("Ƕ�״�����" + count + "��ʱ" + (end - start));
	}
}
