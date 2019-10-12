package 春招公司笔试20190310_20190515.拼多多正式批第二批笔试5_6;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/05/06 18:47
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//A国人口数量
        int k = sc.nextInt();//方言数量
        int res = sc.nextInt();//会说全部方言的人，先记录会说第一种方言的人，迭代最终结果
        //会说全部方言（k种）的人 = 会说k - 1种方言的人的人数 + 会说另一种方言的人 - 总人口 n
        //（res小于0时，代表没人会所有方言）
        for(int i = 1; i < k; i++){
            int x = sc.nextInt();
            res = x + res - n;
            if(res <= 0){
                res = 0;
                break;
            }
        }
        System.out.println(res);

    }
}
//#include <iostream>
//#include <stdlib.h>
//        #include <string>
//#include<vector>
//using namespace std;
//        int main() {
//        int N, K;
//        cin >> N>>K;
//        int x, ans;
//        cin>> ans;
//        for(int i=1;i<K;++i){
//        cin>>x;
//        ans = x+ans-N;
//        if (ans<=0) {
//        cout<<0<<endl;
//        return 0;
//        }
//        }
//        cout << ans <<endl;
//        return 0;
//        }
