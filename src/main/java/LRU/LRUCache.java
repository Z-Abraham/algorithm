package LRU;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    // 定义数据存储的结构
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    // 维护当前队列的大小
    private int size;
    // 当前队列初始化的容量
    private int capacity;
    // 维护双向链表头尾
    private DLinkedNode head, tail;

    // 构造函数初始化
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null) return -1;
        // 将最近调用的节点移到头部
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node == null) {
            // 不存在 新建 加入到cache里面和双向链表里面 维护size
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);

            addToHead(newNode);
            ++size;

            // 如果size 大于了初始化的 capacity 移除最后一个
            if(size > capacity) {
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        }else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);

        return res;
    }
}
