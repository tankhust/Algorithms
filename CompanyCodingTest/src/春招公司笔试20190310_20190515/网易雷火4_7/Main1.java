package 春招公司笔试20190310_20190515.网易雷火4_7;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/04/07 14:05
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        BitMap bitMap = new BitMap();
        for(int i = 0; i < N; i++){
            bitMap.setBits(sc.nextInt());
        }
        System.out.println(bitMap.bitCount(bitMap.dataBytes));
//        int count = 0;
//        for(int i = 0; i <= bitMap.dataBytes.length - 1; i++){
//            count += bitMap.bitCount(i);
//        }
//        System.out.println(count);
    }
}
class BitMap{
    public byte[] dataBytes = new byte[1<<24];//1^27 = 1亿个bit = 1^24个byte
    public void setBits(int num){
        int bitIndex = num;
        int index = (int)(bitIndex / 8);
        int innerIndex = (int)(bitIndex % 8);
        dataBytes[index] = (byte)(dataBytes[index] | (1 << innerIndex));
    }
    public int bitCount(byte[] bytes){
        int count = 0;
        for(int i = 0; i < bytes.length; i++){
            for(int j = 0; j < 8; j++){
                if(((bytes[i]) & (1 << j)) != 0){
                    count++;
                }
            }
        }
        return count;
//        int count = 0;
//        int temp = (int)dataBytes[byteIndex];
//        while(temp != 0){
//            if( (temp & 1) != 0){
//                count++;
//            }
//            temp = temp >> 1;
//        }
//        return count;
    }
}
