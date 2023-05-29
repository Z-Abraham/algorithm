package BM;

/**
 * @Author Abraham
 * @Date 2023/5/9 20:56
 * @Version 1.0
 */

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

public class BM14 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(7);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        oddEvenList(head);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public static ListNode oddEvenList(ListNode head) {
        // write code here
        if (head == null) return null;
        ListNode list1 = new ListNode(-1);
        ListNode cur1 = list1;
        ListNode list2 = new ListNode(-1);
        ListNode cur2 = list2;
        int index = 1;
        while (head != null) {
            if (index % 2 == 0) {
                cur1.next = head;
                cur1 = cur1.next;
            } else {
                cur2.next = head;
                cur2 = cur2.next;
            }
            index++;
            head = head.next;
        }
        cur2.next = list1.next;
        return list2.next;
    }

}
