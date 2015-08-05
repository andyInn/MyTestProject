package niuKe_exam;

/**
 * [�����] �������Ұ����ķ�ʽ������ϵ�����
����һ���������ͷ���ڵ�head��������ΪN�� 
���NΪż������ôǰN/2���ڵ��������������N/2���ڵ������Ұ�����
 ���NΪ��������ôǰN/2���ڵ��������������N/2+1���ڵ������Ұ�����
  ��������������μ�ΪL1->L2->...���Ұ������������μ�ΪR1->R2->...��
  �뽫�����������L1->R1->L2->R2->...�����ӡ�
   ���磺 1->2->3->4 ������1->3->2->4 
   1->2->3->4->5 ������1->3->2->4->5 
   Ҫ�����������ΪN��ʱ�临�Ӷ���ﵽO(N)������ռ临�Ӷ���ﵽO(1)
 * @author Andy
 *
 */
public class Solution2 {

	public void relocateList(ListNode head) {// ͷ���
		ListNode p1 = new ListNode(0);
		ListNode p2 = new ListNode(0);
		ListNode pre = null;
		ListNode pTemp = null;

		p1.next = head.next;
		p2.next = head.next;
		// ������Ϊ�ջ���3��Ԫ�����ڣ�����4������ֱ�ӷ��ش˵�������
		if (head.next == null || head.next.next == null || head.next.next.next == null|| head.next.next.next.next==null)
			return;

		int length = 0, start2 = 0;
		// ȡ�õ�������
		while (p2.next != null) {
			length++;
			p2.next = p2.next.next;
		}// while(p2.next!=null)
		start2 = length / 2;
		p2.next = head.next;
		while (start2 > 0 && p2.next != null) {
			pre = p2.next;
			p2.next = p2.next.next;
			start2--;
		}// while(start2>0)

		// �ϲ����Ұ���
		pre.next = null;// �õ������
		start2 = length / 2;
		while (start2 > 0) {
			// ����������������ǣ��Ұ����Ľ������������
			pre = p1.next;// ������ʱҪ�õ�pre
			p1.next = p1.next.next;

			// �����Ұ�����㣬ͷ�巨
			pTemp = p2.next;
			p2.next = p2.next.next;
			pTemp.next = p1.next;
			pre.next = pTemp;
			// p1.next = p1.next.next;

			start2--;
		}// while(start2>0)
		if (p2.next != null) {
			pTemp.next=p2.next;
		}// if(p2.next!=null)
	}

	public void print(ListNode head) {
		while (head.next != null) {
			System.out.print(head.next.val + "->");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
//		ListNode listNode1 = new ListNode(10);
//		ListNode listNode2 = new ListNode(9);
//		ListNode listNode3 = new ListNode(7);
//		ListNode listNode4 = new ListNode(8);
//		ListNode listNode5 = new ListNode(13);
		
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);
		ListNode listNode6 = new ListNode(6);
		head.next = listNode1;
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;
//		listNode5.next = listNode6;

		Solution2 solution2 = new Solution2();
		solution2.relocateList(head);
		solution2.print(head);
	}
}
