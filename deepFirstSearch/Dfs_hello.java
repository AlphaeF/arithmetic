package deepFirstSearch;

import org.junit.Test;

/**
 * @author Administrator
 *
 *         ����������� �������������
 *
 *         ^^^+^^^=^^^����ѧ�� �����ǣ�
 * ˼�룺
 *void dfs(int step){
 *      �жϱ߽�
 *      
 *      ����ÿһ�ֿ���for(){
 *        ������һ��dfs(step+1)
 *      }
 *      
 *      return
 *}
 *
 *
 */
public class Dfs_hello {
	// �½�һ���պ��ӣ� 10���ռ�
	int[] a = new int[10];
	// 10���� �������i�������Ƿ����Ѿ� ���� �� 0��ʾδ��1��ʾ��
	int[] book = new int[10];
	int count = 0;

	@Test
	public void test() {
		dfs(1);
		System.out.println(count);
	}

	/**
	 * @param step
	 * 
	 */
	public void dfs(int step) {
		// �߽����������������һ����˵��ǰ�������Ѿ����
		if (step == 10) {
			// ��ӡ��������
			if ((a[1] * 100 + a[2] * 10 + a[3] + a[4] * 100 + a[5] * 10 + a[6]) == (a[7]
					* 100 + a[8] * 10 + a[9])) {
				for (int i = 0; i < a.length; i++) {
					// ��һλ����ӡ
					if (i == 0) {
						continue;
					}
					// �ڵ�4Ϊ��һ��+��
					if (i == 4) {
						System.out.print("+");
					}
					if(i==7){
						System.out.print("=");
					}
					System.out.print(a[i]);

				}
				count++;
				System.out.println();
				return;
			}
		}

		// ��ɵ�step����ȫ������
		for (int i = 1; i < a.length; i++) {
			// book[i]��ʾ��step��ʱ��i�����Ƿ����Ѿ�����
			if (book[i] == 0) {

				// ��ɵ�step���Ķ���
				a[step] = i;
				// ����i���Ʊ��
				book[i] = 1;
				// ��һ����ɣ��ݹ鵽��һ��
				dfs(step + 1);
				book[i] = 0;// �Ѹոճ��Ե��˿����ջ�
			}
		}
	}

}
