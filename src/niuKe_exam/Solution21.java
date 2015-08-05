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
public class Solution21 {

	public void relocateList(ListNode head) {
		//�˴���ȷ��head��ͷԪ�أ��˴���Ϊû��ͷ���
		int Listlength = 0;
		ListNode pListNode = head;
		while (pListNode != null) {
			Listlength++;
			pListNode = pListNode.next;
		}
		int half = Listlength / 2;
		ListNode rightnode = head;
		ListNode leftnode = head;
		int i = 0;
		while (i < half - 1) {//�����5����㣬��ôhalf=2������ֻѭ��һ��
			rightnode = rightnode.next;
			i++;
		}
		i = 0;
		// System.out.println(rightnode.val);
		while (i < half - 1) {//����ֱ�ӽ��Ұ�����ǰhalf-1��'ֵ'���뵽�������Ӧλ����
			ListNode tmp = new ListNode(rightnode.next.val);
			rightnode.next = rightnode.next.next;//���ϵ������������������������5����㣬��ô����2->4
			tmp.next = leftnode.next;
			leftnode.next = tmp;
			leftnode = tmp.next;
			i++;
		}

	}
	
	public void print(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
	}

	public static void main(String[] args) {

		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);
		ListNode listNode6 = new ListNode(6);

		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;
		//listNode5.next = listNode6;

		Solution21 solution2 = new Solution21();
		solution2.relocateList(listNode1);
		solution2.print(listNode1);
	}
}
