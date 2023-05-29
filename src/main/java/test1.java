import java.util.Scanner;

/**
 * @Author Abraham
 * @Date 2023/4/29 9:52
 * @Version 1.0
 */

/*
时间限制： 3000MS
内存限制： 589824KB
题目描述：
       某大学最近正在进行选课。对于学校开设的部分课程，只允许大一至大四中部分年级和部分学院的学生在选课系统中自行选课，年级或学院不符合要求的学生只能通过教务科代为选课。但是不幸的是，各个学院教务科只能帮自己学院的学生选择自己学院开设的课程。

       此时出现的一个问题是，A学院的小美想请教务处代选B学院开设的课程时，A学院的教务科没有权限将学生添加到B学院开设的课程，因此让小美去找B学院的教务科，B学院的教务科没有权限调取就读A学院学生的个人信息，因此让小美去找A学院的教务科。此时我们说小美被踢皮球了。

       为了方便处理，可以认为一共有n门课程，编号为1~n；m个学院，编号为1~m  。给出n门可选课程及其开课学院、允许在系统选课的年级和专业，进行q次查询，每次查询给出学生所属学院和待选课程。若可以自行在选课，输出"Help yourself"（不包括引号，下同）；否则若可以由教务处成功代选，输出"Ask for help"；否则说明该学生会被踢皮球，输出"Impossible"。

       注意：只有年级和学院都不被限制的学生可以自行选课。



输入描述
第一行输入3个正整数n,m,q

第二行输入n个正整数si，表示编号为i的课程的开课学院为si；

接下来4行输入一个4×n的01矩阵f，fij=0表示不允许i年级的学生自行选j课程，fij=1则表示允许；

接下来m行输入一个m×n的01矩阵g，gij=0表示不允许i学院的学生自行选j课程，gij=1则表示允许；

接下来q行，每行输入3个正整数a,b,c ，表示学生所属学院、年级、待选课程。



输出描述
输出共q行，每行一个字符串表示对应查询的结果。


样例输入
5 2 4
1 2 2 1 1
1 0 0 0 0
0 0 1 1 1
0 0 0 0 1
0 0 1 0 1
1 0 0 1 1
0 1 0 0 0
2 2 3
2 3 2
2 3 1
1 2 4
样例输出
Ask for help
Ask for help
Impossible
Help yourself

提示
对第一个查询，3号课程不限制2年级学生自行选课，但限制2号学院的学生选课，因此该学生不能自行选课。幸运的是，3号课程是2号学院开设的课程，因此该学生可以找2号学院教务处帮忙代选。

对第二个查询，2号课程不限制2号学院的学生自行选课，但限制3年级学生选课，因此该学生不能自行选课。同样的，2号课程由2号学院开设，可以找2号学院教务处代选。

对第三个查询，1号课程限制2号学院和3年级学生自行选课，因此该学生不能自行选课。由于开课学院是1学院，2学院教务科没有添加权限；由于学生学院是2学院，1学院没有查看学生信息的权限，因此该学生被踢皮球。

对第四给查询，4号课程不限制1号学院和2年级学生自行选课。
* */
public class test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n, m, q;
        n = input.nextInt();
        m = input.nextInt();
        q = input.nextInt();
        int[] s = new int[n + 1];
        for(int i = 1; i < n + 1; i ++) {
            s[i] = input.nextInt();
        }

        // 接下来4行输入一个4×n的01矩阵f，fij=0表示不允许i年级的学生自行选j课程，fij=1则表示允许；
        int[][] f = new int[5][n + 1];
        for(int i = 1; i < 5; i++) {
            for(int j = 1; j < n + 1; j++) {
                f[i][j] = input.nextInt();
            }
        }

        //接下来m行输入一个m×n的01矩阵g，gij=0表示不允许i学院的学生自行选j课程，gij=1则表示允许；
        int[][] g = new int[m + 1][n + 1];
        for(int i = 1; i < m + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                g[i][j] = input.nextInt();
            }
        }

        // 接下来q行，每行输入3个正整数a,b,c ，表示学生所属学院、年级、待选课程。
        int[][] stu = new int[q + 1][4];
        for(int i = 1; i < q + 1; i++) {
            for(int j = 1; j < 4; j++) {
                stu[i][j] = input.nextInt();
            }
        }

        for(int i = 1; i <= q; i++) {
            int yuan = stu[i][1];
            int grade = stu[i][2];
            int clazz = stu[i][3];
            if(f[grade][clazz] == 0 || g[yuan][clazz] == 0) {
                if(s[clazz] == yuan) {
                    System.out.println("Ask for help");
                }else {
                    System.out.println("Impossible");
                }
            }
            if(f[grade][clazz] == 1 && g[yuan][clazz] == 1) {
                System.out.println("Help yourself");
            }
        }
    }
}
