package tianrongxin;

import java.util.Scanner;

/**
 * @Author Abraham
 * @Date 2023/5/10 19:52
 * @Version 1.0
 */
public class test11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i = 1; i <= n; i++) {
            if (i % 5 == 0) {
                System.out.println("buzz");
            }
            if (i % 3 == 0) {
                System.out.println("fizz");
            }
            if(i % 3 == 0 && i % 5 == 0) {
                System.out.println("fizzbuzz");
            }
            if(i % 3 != 0 && i % 5 != 0) {
                System.out.println(i);
            }
        }
    }
}
