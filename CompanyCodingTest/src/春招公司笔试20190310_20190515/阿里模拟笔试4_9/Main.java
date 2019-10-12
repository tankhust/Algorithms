package 春招公司笔试20190310_20190515.阿里模拟笔试4_9;

/**
 * @author tankInternshipInterview
 * @create 2019/04/09 19:36
 */
import java.util.*;
import java.util.List;
public class Main {
/** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来
     **/
    public static String measureDistance(List<Double> xList, List<Double> yList, double x, double y) {
        double xAver = 0.0;
        double yAver = 0.0;
        for(double xx : xList){
            xAver += xx;
        }
        xAver = xAver/xList.size();
        for(double yy : xList){
            yAver += yy;
        }
        yAver = yAver/yList.size();
        double xNearest = 0.0;
        double yNearest = 0.0;
        double curInstance = 0.0;
        double minInstance = Math.sqrt((x - xList.get(0)) * (x - xList.get(0)) + (y - yList.get(0)) * (y - yList.get(0)));
        for(int i = 1; i < xList.size(); i++){
            curInstance = Math.sqrt((x - xList.get(i)) * (x - xList.get(i)) + (y - yList.get(i)) * (y - yList.get(i)));
            if(curInstance < minInstance){
                minInstance = curInstance;
                xNearest = xList.get(i);
                yNearest = yList.get(i);
            }
        }
        return "";
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        //(x,y)为小广所在的位置
        double x = Double.parseDouble(line.split(",")[0]);
        double y = Double.parseDouble(line.split(",")[1]);

        line = in.nextLine();
        //xList记录了多边形n个点的x坐标,yList记录了多边形n个点的y坐标
        List<Double> xList = new ArrayList<>();
        List<Double> yList = new ArrayList<>();
        String[] array = line.split(",");
        for(int i = 0; i < array.length; i++) {
            xList.add(Double.parseDouble(array[i]));
            yList.add(Double.parseDouble(array[i+1]));
            i++;
        }
        in.close();
        System.out.println(measureDistance(xList, yList, x, y));
    }
}
