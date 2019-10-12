package 秋招公司笔试20190727_20190921.pdd笔试;

/**
 * 题目详情：给定一组字符串，判断这些字符串能否首尾相连，即前面一个字符串的最后一个字母和紧跟着的字符串的第一个字母相同。
 *
 * 例如，给定arr[][] = {"gj","jl","dg","ad","gg"}，可知其满足首尾相连，即ad, dg, gg, gj, jl。
 *
 * 代码如下：
 *
 * #include <cstring>
 * #include <iostream>
 * using namespace std;
 *
 * bool flag = false;
 * void swap(char **arr, int s, int i);
 * void fun(char **arr, int n, int k);
 * bool judge(char **arr, int n);
 *
 * int main() {
 *     int n;
 *     cin >> n;
 *     char **arr = new char*[n];
 *     for (int i = 0; i < n; ++i) {
 *         arr[i] = new char[100];
 *         memset(arr[i], 0, sizeof arr[i]);
 *         cin >> arr[i];
 *     }
 *     cout << judge(arr, n) << endl;
 *     return 0;
 * }
 *
 * bool judge(char **arr, int n) {
 *     fun(arr, n, 0);
 *     if (flag)
 *         return true;
 *     else
 *         return false;
 * }
 *
 * void fun(char **arr, int n, int k) {
 *     if (k == n) {
 *         //for (int i = 0; i < n; ++i)
 *         //  cout << arr[i] << '\t';
 *         //cout << endl;
 *         flag = true;
 *         return;
 *     }
 *     for (int i = k; i < n; ++i) {
 *         if (k > 0 && (arr[k-1][strlen(arr[k-1])-1] == arr[i][0])) {  //k!=0，之前的0-k-1个字符串已经排好序，则判断k-1号字符串与之后的字符串
 *             swap(arr, k, i);
 *             fun(arr, n, k+1);
 *             swap(arr, k, i);
 *         }
 *         else if ( k==0 ) {  //k=0，即第一个字符串与所有的字符串判断
 *             swap(arr, k, i);
 *             fun(arr, n, k+1);
 *             swap(arr, k, i);
 *         }
 *         else
 *             ;
 *     }
 *     return;
 * }
 *
 * void swap(char **arr, int s, int i) {
 *     char *t = new char[100];
 *     memset(t, 0, 100);
 *     strcpy(t, arr[s]);
 *     strcpy(arr[s], arr[i]);
 *     strcpy(arr[i], t);
 *     delete[] t;
 * }
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 8
 * 9
 * 10
 * 11
 * 12
 * 13
 * 14
 * 15
 * 16
 * 17
 * 18
 * 19
 * 20
 * 21
 * 22
 * 23
 * 24
 * 25
 * 26
 * 27
 * 28
 * 29
 * 30
 * 31
 * 32
 * 33
 * 34
 * 35
 * 36
 * 37
 * 38
 * 39
 * 40
 * 41
 * 42
 * 43
 * 44
 * 45
 * 46
 * 47
 * 48
 * 49
 * 50
 * 51
 * 52
 * 53
 * 54
 * 55
 * 56
 * 57
 * 58
 * 59
 * 60
 * 61
 * 62
 * 63
 * 输入参数：
 * 5
 * gj jl dg ad gg
 *
 * 输出结果：
 * //ad dg gg gj jl
 * 1
 *
 * 回溯法：以深度优先遍历，一一试探。
 * ---------------------
 * 作者：lmq_begood
 * 来源：CSDN
 * 原文：https://blog.csdn.net/lmq_begood/article/details/52275570
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 * @author tankInternshipInterview
 * @create 2019/07/28 15:11
 */
public class 判断字符串数组能否首尾相连 {

}
