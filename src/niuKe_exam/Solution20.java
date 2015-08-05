package niuKe_exam;

/**
 * [�����] �������Ұ����ķ�ʽ������ϵ����� ����һ���������ͷ���ڵ�head��������ΪN��
 * ���NΪż������ôǰN/2���ڵ��������������N/2���ڵ������Ұ����� ���NΪ��������ôǰN/2���ڵ��������������N/2+1���ڵ������Ұ�����
 * ��������������μ�ΪL1->L2->...���Ұ������������μ�ΪR1->R2->...��
 * �뽫�����������L1->R1->L2->R2->...�����ӡ� ���磺 1->2->3->4 ������1->3->2->4 1->2->3->4->5
 * ������1->3->2->4->5 Ҫ�����������ΪN��ʱ�临�Ӷ���ﵽO(N)������ռ临�Ӷ���ﵽO(1)
 * 
 * @author Andy
 * 
 */
public class Solution20 {

	public void relocateList(ListNode head) {// û��ͷ���,������վԤ��
		ListNode p1= head;
		ListNode p2= head;
		ListNode pre = null;
		ListNode pTemp = null;

		// ������Ϊ�ջ���3��Ԫ�����ڣ�����4������ֱ�ӷ��ش˵�������
		if (head == null || head.next == null || head.next.next == null || head.next.next.next == null)
			return;

		int length = 0, start2 = 0;
		// ȡ�õ�������
		while (p2 != null) {
			length++;
			p2 = p2.next;
		}// while(p2!=null)
		start2 = length / 2;
		p2 = head;
		while (start2 > 0) {
			pre = p2;// ������������һ�����
			p2 = p2.next;
			start2--;
		}// while(start2>0)

		pre.next = null;
		// �ϲ����Ұ���
		start2 = length / 2;
		while (start2 > 0) {
			// ����������������ǣ��Ұ����Ľ������������
			pre = p1;// ������ʱҪ�õ�pre
			p1 = p1.next;

			// �����Ұ�����㣬ͷ�巨
			pTemp = p2;
			p2 = p2.next;
			pTemp.next = p1;
			pre.next = pTemp;

			start2--;
		}// while(start2>0)
		if (p2 != null) {
			pTemp.next = p2;
		}// if(p2!=null)
	}

	public void print(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(0);

		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);
		ListNode listNode6 = new ListNode(6);
		// head.next = listNode1;
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;
//		listNode5.next = listNode6;

		Solution20 solution20 = new Solution20();
		solution20.relocateList(listNode1);
		solution20.print(listNode1);
	}
}
