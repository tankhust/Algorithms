//package 秋招公司笔试20190727_20190921.VIVO20190911;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
///**
// * @author tankInternshipInterview
// * @create 2019/09/11 17:37
// */
//public class Main3 {
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String inputStr = br.readLine();
//        int input[] = parseInts(inputStr.split(" "));
//        int output = solution(input);
//        System.out.println(output);
//    }
//
//    private static int[] parseInts(String[] strArr) {
//        if (strArr == null || strArr.length == 0) {
//            return new int[0];
//        }
//        int[] intArr = new int[strArr.length];
//        for (int i = 0; i < intArr.length; i++) {
//            intArr[i] = Integer.parseInt(strArr[i]);
//        }
//        return intArr;
//    }
//
//    private static int solution(int[] input) {
//
//        // TODO Write your code here
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < input.length; i++) {
//            sb.append(input[i]);
//        }
//        String s = sb.toString();
//        for (int i = 0; i < input.length - 1; i++) {
//            if (input[i] == input[i + 1]) {
//                delete(s, i);
//            }
//        }
//    }
//
//
//    private static void delete(String str, int idx) {
//        int i = idx, j =idx;
//        while (j < str.length()) {
//            if (str.charAt(j) == str.charAt(i)) {
//                j++;
//            }else{
//                break;
//            }
//        }
//        str.
//    }
//}
