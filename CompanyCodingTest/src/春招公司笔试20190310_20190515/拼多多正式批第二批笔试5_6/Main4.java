package 春招公司笔试20190310_20190515.拼多多正式批第二批笔试5_6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/05/06 18:47
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();//高楼数量
        int n = sc.nextInt();//活动需要的楼栋数量
        int[] height = new int[m];
        for(int i = 0; i < m; i++){
            height[i] = sc.nextInt();
        }
        //从低到高将楼层排序
        Arrays.sort(height);
        int temp = 0;
        int res = 0;
        int i;
        //整体思路：从低到高计算需要增加的楼层数，迭代更新出最小答案
        //初始值：计算出若使用前n层需要增加的楼层数，1~3
        for (i = 0; i < n; i++) {
            temp += height[n - 1] - height[i];
        }
        res = temp;
        //接下来，我把中间值改成2~4层时需要增加的楼层数（总成本增加（n - 1）* h[i] - h[i - 1]（即加入下一栋楼增加的成本）,减去第一栋楼花掉的成本），并更新答案（越小越好）
        for (; i < m; i++) {
            temp += (n - 1) * (height[i] - height[i - 1]) - (height[i - 1] - height[i - n]);
            res = Math.min(res, temp);
        }
        System.out.println(res);
    }
}
//#include<iostream>
//#include<vector>
//#include<algorithm>
//using namespace std;
//        int main(){
//        int N,M;
//        cin>>M>>N;
//        vector<int>lou(M,0);
//        for(int i=0;i<M;++i)
//        cin>>lou[i];
//        sort(lou.begin(),lou.end());
//        int ans=0,tmp=0,i;
//        for(i=0;i<N;++i){
//        tmp+=lou[N-1]-lou[i];
//        }
//        ans=tmp;
//        for(;i<M; i++){
//        tmp+=(N-1)*(lou[i]-lou[i-1])-(lou[i-1]-lou[i-N]);
//        if(tmp<ans)ans=tmp;
//        }
//        cout<<ans<<endl;
//        return 0;
//        }
