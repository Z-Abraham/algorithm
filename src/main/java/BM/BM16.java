package BM;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Abraham
 * @Date 2023/5/18 21:42
 * @Version 1.0
 */

public class BM16 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        head.next = node2;
        node2.next = node3;

        deleteDuplicates(head);
    }
    public static ListNode deleteDuplicates (ListNode head) {
        // write code here
        if(head == null) return null;
        // hashmap 抛异常java.util.ConcurrentModificationException
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        while(head != null) {
            map.put(head.val, map.getOrDefault(head.val, 0) + 1);
            head = head.next;
        }
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        for(Integer num : map.keySet()) {
            if(map.get(num) > 1) map.remove(num);
        }
        Set<Integer> set = map.keySet();
        List<Integer> list = new ArrayList(set);
        Collections.sort(list);

        for(int i = 0; i < list.size(); i++) {
            ListNode newNode = new ListNode(list.get(i));
            cur.next = newNode;
            cur = cur.next;
        }

        return res.next;
    }
}
