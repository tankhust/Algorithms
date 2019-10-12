package 春招公司笔试20190310_20190515.拼多多正式批第二批笔试5_6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/05/06 18:47
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
            end[i] = sc.nextInt();
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int[] l = new int[n];
        int[] r = new int[n];
        int curL = -1, curR = -1, count = 0, resCount = 0;
        //细节：将线段的start和end数组升序排列，使用curL和curR两个指针用来指引符合标准的线段（线段中的点属于至少k个线段）的左右两端
        //进入循环，curR右指针在线段范围内时持续这个循环。
        //当end数组的的第一个大于start数组的第一个时，count++,其中count表示当前curL~curR之间的点属于count条线段，更新curL 加一
        //当count == k时，说明这个从curL起的某个线段符合标准
        //但curR也需要更新，和curL同理,更新curR加一，当count == k时，说明这个到curR为止的某个线段符合标准
        //但是此时count可能大于k，说明curR还可以往后移一位，从curL起的区间是可以更大的
        //用l，r数组记录结果后，最后输出结果即可

        //思路：至少属于k条线段，可以在纸上画出线段的各个为止，第一个用例中，k=2时，发现第一条线段的end刚好比前两条线段的start都大时，有一条符合标准的以此end为端的线段
        //k = 2时，第一条线段的end之前的"["的数量与"]"的数量的差用count标识，
        // 1. start[curL + 1] <= end[curR + 1]时  count++
        // 2. 否则 count--
        // 3. 只要碰到count == k 就把当前的段点给记录下来

        //类似于括号匹配的题
        //1.(()())
        //2.((()))
        //左括号个数比右括号个数多（k - 1)个时，满足条件
        //左括号个数为k时，记录左括号位置，出现右括号时，记录右括号位置
        while (curR < n - 1) {
            if (curL < n - 1 && start[curL + 1] <= end[curR + 1]) {
                curL++;
                count++;
                if (count == k)
                    l[resCount] = start[curL];
            } else {
                curR++;
                if (count == k) r[resCount++] = end[curR];
                count--;
            }
        }
        System.out.println(resCount);
        for (int i = 0; i < resCount; i++) {
            System.out.println(l[i] + " " + r[i]);
        }
    }
}
//#include <iostream>
//#include <stdlib.h>
//        #include <string>
//#include<vector>
//#include<algorithm>
//using namespace std;
//        int main() {
//        int N, K;
//        cin >> N>>K;
//        vector<int> l(N),r(N),left(N),right(N);
//        for(int i=0;i<N;++i){
//        cin>>l[i]>>r[i];//样例数据与输入描述不符，但是不影响
//        }
//        sort(l.begin(), l.end());
//        sort(r.begin(), r.end());
//        int pl=-1,pr=-1, count=0, result_count=0;
//        while (pr<N-1){
//            if (pl<N-1 and l[pl+1]<=r[pr+1]) {
//                pl++;
//                count++;
//            if (count==K)
//                left[result_count] = l[pl];
//            }else {
//                pr++;
//                if (count==K) right[result_count++] = r[pr];
//                    count--;
//            }
//        }
//        cout << result_count <<endl;
//        for (int i=0; i<result_count;i++)
//        cout<<left[i]<<' '<<right[i]<<endl;
//        return 0;
//        }#include <iostream>
//#include <stdlib.h>
//        #include <string>
//#include<vector>
//#include<algorithm>
//using namespace std;
//        int main() {
//        int N, K;
//        cin >> N>>K;
//        vector<int> l(N),r(N),left(N),right(N);
//        for(int i=0;i<N;++i){
//        cin>>l[i]>>r[i];//样例数据与输入描述不符，但是不影响
//        }
//        sort(l.begin(), l.end());
//        sort(r.begin(), r.end());
//        int pl=-1,pr=-1, count=0, result_count=0;
//        while (pr<N-1){
//        if (pl<N-1 and l[pl+1]<=r[pr+1]) {
//        pl++;
//        count++;
//        if (count==K) left[result_count] = l[pl];
//        }else {
//        pr++;
//        if (count==K) right[result_count++] = r[pr];
//        count--;
//        }
//        }
//        cout << result_count <<endl;
//        for (int i=0; i<result_count;i++)
//        cout<<left[i]<<' '<<right[i]<<endl;
//        return 0;
//        }