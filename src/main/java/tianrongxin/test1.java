package tianrongxin;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Abraham
 * @Date 2023/5/10 19:30
 * @Version 1.0
 */

/*
时间限制： 3000MS
内存限制： 589824KB
题目描述：
编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：

如果这个数字可以被 3 整除，输出 "fizz"。

如果这个数字可以被 5 整除，输出 "buzz"。

如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。

例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。

假设有这么一个类：

class FizzBuzz {

  public FizzBuzz(int n) { ... }               // constructor

  public void fizz(printFizz) { ... }          // only output "fizz"

  public void buzz(printBuzz) { ... }          // only output "buzz"

  public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"

  public void number(printNumber) { ... }      // only output the numbers

}

请你实现一个有四个线程的多线程版  FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用：

线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。

线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。

线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。

线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。





输入描述
输入一个正整数n

输出描述
当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。


样例输入
15
样例输出
1
2
fizz
4
buzz
fizz
7
8
fizz
buzz
11
fizz
13
14
fizzbuzz
 */
public class test1 {
    private static final AtomicInteger count = new AtomicInteger(1);
    public static void main(String[] args) {
        while(count.get() < 15) {
            Runnable runnableA = new Runnable() {
                @Override
                public void run() {
                    if (count.get() % 3 == 0) System.out.println("fizz");
                }
            };
            Runnable runnableB = new Runnable() {
                @Override
                public void run() {
                    if (count.get() % 5 == 0) {
                        System.out.println("buzz");
                        count.set(count.get() + 1);
                    }
                }
            };
            Runnable runnableC = new Runnable() {
                @Override
                public void run() {
                    if (count.get() % 5 == 0 && count.get() % 3 == 0) {
                        System.out.println("fizzbuzz");
                        count.set(count.get() + 1);
                    }
                }
            };
            Runnable runnableD = new Runnable() {
                @Override
                public void run() {
                    if (count.get() % 5 != 0 && count.get() % 3 != 0) {
                        System.out.println(count.get());
                        count.set(count.get() + 1);
                    }
                }
            };
            runnableA.run();
            runnableB.run();
            runnableC.run();
            runnableD.run();
        }
    }
}

//class FizzBuzz {
//    private int n;
//
//    public FizzBuzz(int n) {
//        this.n = n;
//    }               // constructor
//
//    public void fizz(printFizz) {
//
//    }          // only output "fizz"
//
//    public void buzz(printBuzz) {
//
//    }          // only output "buzz"
//
//    public void fizzbuzz(printFizzBuzz) {
//
//    }  // only output "fizzbuzz"
//
//    public void number(printNumber) {
//
//    }      // only output the numbers
//
//}