/*
package tankInternshipInterview.practice.拼多多提前批笔试3_10;

import java.util.Scanner;

*/
/**
 * @author tankInternshipInterview
 * @create 2019/03/10 16:27
 *//*

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    }
}
#include <iostream>
#include <algorithm>
#include <stdlib.h>
        #define max_length 3000
        using namespace std;


        int l1[max_length],l2[max_length];
        int f[max_length][max_length]={0};
        int main() {
        string s1,s2;

        cin >>s1>>s2;
        long L1 = s1.size(), L2 = s2.size();
        int tmp=0;
        for (int i=1;i<=L1;++i){
        tmp += s1[i-1]=='(';
        l1[i] = tmp;
        }
        tmp=0;
        for (int i=1;i<=L2;++i){
        tmp += s2[i-1]=='(';
        l2[i] = tmp;
        }
        f[0][0]=1;
        for (int i=0;i<=L1;i++)
        for (int j=0; j<=L2; j++){
        if (2*(l1[i]+l2[j])>=(i+j)){
        if (i>0) f[i][j]+=f[i-1][j];
        if (j>0) f[i][j]+=f[i][j-1];
        f[i][j]%=1000000007;
        }
        }
        cout << f[L1][L2] << endl;
        return 0;
        }

*/
