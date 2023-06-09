/**
 * @Author Abraham
 * @Date 2023/4/29 11:54
 * @Version 1.0
 */
/*
时间限制： 3000MS
内存限制： 589824KB
题目描述：
       小美有一棵以1为根节点，一共n个节点的树。现在每次给出两条存在至少一个公共点的边，她希望知道，这棵树上有多少条简单路径同时覆盖这两条边。

       注：简单路径指的是，从树上某个点u通过不重复的树边到达另一个点v形成的路径，可以用（u,v）表示。我们将（u,v）和（v,u）视为同一条路径，不重复统计。



输入描述
第一行两个正整数n,m ，表示树的节点数和询问次数。

第二行n-1个正整数，第i个数表示这棵树编号为i+1的节点的父节点编号fi+1，保证每个点的父节点编号小于自身编号。

第三行m个正整数，第i个数分别表示第i次查询的第一条边对应子节点的编号ai，即这条边的两个端点分别为ai和fai 。

第四行m个正整数，第i个数分别表示第i次查询的第二条边对应子节点的编号bi，即这条边的两个端点分别为bi和fbi 。

对于所有的数据，1≤n,m≤50000。

输出描述
输出一行空格分隔的m个整数表示答案。


样例输入
5 4
1 2 1 4
5 4 3 2
4 2 2 2
样例输出
3 4 3 6

提示
对第一个询问，满足条件的简单路径集为{(1,5),(2,5),(3,5)}；

对第二个询问，满足条件的简单路径集为{(2,4),(2,5),(3,4),(3,5)}；

对第三个询问，满足条件的简单路径集为{(1,3),(4,3),(5,3)}。

对第四个询问，满足条件的简单路径集为{(2,1),(2,4),(2,5),(3,1),(3,4),(3,5)}。
 */
public class test5 {
}
