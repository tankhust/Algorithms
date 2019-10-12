//package tankInternshipInterview.practice.test;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
///**
// * @author tankInternshipInterview
// * @create 2019/03/07 20:15
// */
//
//import java.util.*;
//
//public class Main1 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int M = sc.nextInt();
//        int K = sc.nextInt();
//        int[][] arr = new int[N][M];
//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < M; j++){
//                arr[i][j] = sc.nextInt();
//            }
//        }
//        int[][] isStarCore = new int[N][M];
//        int[] isStarCoreRow = new int[N];
//        int[] isStarCoreCol = new int[M];
//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < M; j++){
//                if(isStar(arr,i,j)){
//                    isStarCore[i][j] = 1;
//                    isStarCoreRow[i] = 1;
//                    isStarCoreCol[j] =1;
//                }
//            }
//        }
//        int count1 =0;
//        int countStar = 0;
//        for(int j = 0;j < N ;j++){
//            for(int i =j ; i< N;i++){
//                if(isStarCoreRow[i] == 1){
//                    count1++;
//                }
//                if(count1 == 3){
//                    countStar++;
//                    count1 = 0;
//                    break;
//                }
//            }
//        }
//        for(int j = 0;j < M ;j++){
//            for(int i =j ; i< M;i++){
//                if(isStarCoreCol[i] == 1){
//                    count1++;
//                }
//                if(count1 == 3){
//                    countStar++;
//                    count1 = 0;
//                    break;
//                }
//            }
//        }
//        System.out.println(countStar/2);
////        int r1 = Integer.MAX_VALUE, c1 = Integer.MAX_VALUE;
////        int r2 =  Integer.MIN_VALUE, c2 =Integer.MIN_VALUE;
////        for(int i = 0; i < N; i++){
////            for(int j = 0; j < M; j++){
////                if(isStar(arr,i,j)){
////                    r1 = Math.min(r1,i);
////                    c1 =Math.
////                }
////            }
////        }
//        int count1 =0;
//
//        for(int j = 1; j < M-1;j++){
//            for(int i = 1; i < N - 1;i++){
//                if(isStarCore == 1){
//                    count1++;
//                }
//            }
//
//        }
//    }
//    private boolean isStar(int[] arr, int i, int j,int N, int M){
//        if(i - 1 <= 0 || j -1<=0||i+1>=N||j+1>=M){
//            return false;
//        }
//        if(arr[i][j]==1
//                &&isStar(arr,i+1,j,N,M)
//                &&isStar(arr,i-1,j,N,M)
//                &&isStar(arr,i,j+1,N,M)
//                &&isStar(arr,i,j-1,N,M))
//            return true;
//        return false;
//
//    }
//}