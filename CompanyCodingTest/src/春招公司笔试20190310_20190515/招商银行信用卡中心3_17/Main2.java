package 春招公司笔试20190310_20190515.招商银行信用卡中心3_17;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/03/17 19:57
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];//第i个桌腿的长度
        int[] arr2 = new int[n];//第i个桌腿的能量
        int maxL = 1;//最大桌腿长度
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
            maxL = maxL < arr1[i] ? arr1[i] : maxL;
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }
        int[] count = new int[n];//长度为arr[i]的个数
        int[] energy = new int[n];//长度为arr[i]的能量

        for (int i = 0; i < n; i++) {
            count[arr1[i]]++;
            energy[arr1[i]] += arr2[i];
        }
        int maxEnergy = 1;//同一长度最大能量和
        int maxEnergyLen = 1;//最大能量和对应的长度
        int sum = 0;//总能量

        for (int i = 0; i < n; i++) {
            maxEnergy = Math.max(maxEnergy, energy[arr1[i]]);
            if(maxEnergy == energy[arr1[i]]){
                maxEnergyLen = arr1[i];
            }
            sum += energy[arr1[i]];
        }

        if(maxL == maxEnergyLen){
            System.out.println(0);
        }else {
            System.out.println(sum - maxEnergy);
        }
    }
}
