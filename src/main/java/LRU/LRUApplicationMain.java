package LRU;

public class LRUApplicationMain {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);

        System.out.println(cache.get(2));
        cache.put(3, 3);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        cache.put(3, 33);
        System.out.println(cache.get(3));
    }
}
