import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Abraham
 * @Date 2023/4/29 10:53
 * @Version 1.0
 */
/*
时间限制： 3000MS
内存限制： 589824KB
题目描述：
小美和她的朋友们共n人决定挑战超辣火锅，以决出最能吃辣的人。他们顺时针围成一圈，假设标号为1到n。从1号开始，每一次从当前的人顺时针数k个，然后这个人吃一口超辣火锅。第i个人对辣椒的耐受值为ai, 意味着当他吃了ai口火锅后将因无法忍受而离席（每次数k个人时，离席的人不算入其中，详见样例解释）。请你依次输出离席的人的编号。



输入描述
第一行读入用空格隔开的两个正整数n,k 。

第二行读入用空格隔开的n个正整数ai 。

对于所有的数据：

输出描述
一行输出用空格隔开的n个正整数，表示按时间从早到晚离席的人的编号。


样例输入
5 2
1 4 2 9 4
样例输出
1 3 5 4 2

提示
第1轮，1号吃火锅，剩余0耐受；1号离席，剩余2，3，4，5号。

第2轮，3号吃火锅，剩余1耐受。

第3轮，5号吃火锅，剩余3耐受。

第4轮，3号吃火锅，剩余0耐受；3号离席，剩余2，4，5号。

第5轮，5号吃火锅，剩余2耐受。

第6轮，4号吃火锅，剩余8耐受。

第7轮，2号吃火锅，剩余3耐受。

第8轮，5号吃火锅，剩余1耐受。

第9轮，4号吃火锅，剩余7耐受。

第10轮，2号吃火锅，剩余2耐受。

第11轮，5号吃火锅，剩余0耐受；5号离席，剩余2，4号。

接下来7轮，4号连续吃7口火锅并离席，剩余2号。

接下来2轮，2号连续吃2口火锅并离席，比赛结束。

因此答案为 1 3 5 4 2。
* */
public class test3 {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int n, k;
        n = input.nextInt();
        k = input.nextInt();
        for(int i = 0; i < n; i++) {
            arr.add(input.nextInt());
        }
        int index = 0;
        int out = 1;
        while(out < 5) {
            arr.set(index, arr.get(index) - 1);
            if(arr.get(index) == 0) {
                System.out.print((index + 1) + " ");
                out++;
            }
            int times = 1;
            while(times <= k) {
                if(arr.get((index + 1) % (n - 1)) == 0) {
                    index = (index + 1) % (n - 1);
                }else {
                    times++;
                    index = (index + 1) % (n - 1);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(arr.get(i) != 0) {
                System.out.print(" " + (i + 1));
            }
        }
    }
}
