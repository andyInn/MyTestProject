package niuKe_exam;

public class Solution1 {
	/**
	 * [�����] ����LeftMax��rightMax֮�����ֵ ����һ������ΪN����������arr�����Ի��ֳ������������֣�
	 * �󲿷�arr[0..K]���Ҳ���arr[K+1..arr.length-1]��K����ȡֵ�ķ�Χ��[0,arr.length-2]
	 * ����ô�໮�ַ����У��󲿷��е����ֵ��ȥ�Ҳ������ֵ�ľ���ֵ������Ƕ��٣� ���磺 [2,7,3,1,1]
	 * ���󲿷�Ϊ[2,7]���Ҳ���Ϊ[3,1,1]ʱ���󲿷��е����ֵ��ȥ�Ҳ������ֵ�ľ���ֵΪ4;
	 * ���󲿷�Ϊ[2,7,3]���Ҳ���Ϊ[1,1]ʱ���󲿷��е����ֵ��ȥ�Ҳ������ֵ�ľ���ֵΪ6; ��󷵻صĽ��Ϊ6��
	 * ע�⣺�������ĳ���ΪN���뾡������ʱ�临�Ӷ�O(N)������ռ临�Ӷ�O(1)
	 */
	public int getMaxABSLeftAndRight(int[] arr) {
		/**
		 * ˼·��
		 * ����ѡ�������������ֵ�������������������һ���϶���������������������
		 * �����ܱ�������߻��ұߣ�����������ߵĻ�����ôֻ��Ҫʹ�ұ��ǲ��ֵ���������С���У� �������ܵó��𰸡�
		 * ���ұ��ǲ���һ�������������ұ��Ǹ�����k�ı߽��������� ����ղ����ҳ��������������������±�Ϊk�����ұ��Ǹ������±�Ϊlen-1��
		 * ������len-1ǰ��k��������е�������vec[len-1]С����ô�𰸾���vec[k]-vec[len-1]��
		 * ��������������б�vec[len-1]��ģ���ô�Ͱ���������߲��֣�
		 * ��������߲������ֵ����vec[k]�����ұ߲������ֵ����vec[len-1]���������������մ𰸾���vec[k]-vec[len-1]��
		 * ͬ����vec[k]���ұ߲���ʱ���Եó���Ϊvec[k]-vec[0]���������մ𰸾��� max( Max-vec[0],
		 * Max-vec[len-1] ) �ˡ�
		 */
		int reL = 0, reR = 0, max = 0, i = 0;
		while (i < arr.length) {
			if (max < arr[i])
				max = arr[i];
			i++;
		}
		reL = Math.abs(arr[0] - max);
		reR = Math.abs(arr[arr.length - 1] - max);
		if (reL < reR)
			return reR;

		return reL;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 7, 3, 1, 1 };
		Solution1 s = new Solution1();
		System.out.println("s.getMaxABSLeftAndRight(arr)=" + s.getMaxABSLeftAndRight(arr));
	}
}
