package BM;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Abraham
 * @Date 2023/5/4 16:59
 * @Version 1.0
 */
public class BM13 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(-401261);
        list.add(-449050);
        list.add(-456674);
        list.add(-456674);
        list.add(-449050);
        list.add(-401261);

        int left = 0, right = list.size() - 1;
        while(left <= right) {
            System.out.println(list.get(left) == list.get(right));
            left++;
            right--;
        }
    }
}
