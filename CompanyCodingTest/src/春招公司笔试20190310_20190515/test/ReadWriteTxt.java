package 春招公司笔试20190310_20190515.test;

import java.io.*;

/**
 * @author tankInternshipInterview
 * @create 2019/02/18 15:12
 */
public class ReadWriteTxt {
    public static void readTxt(String readFrom) {
        try {
            String pathname = readFrom;
            File filename = new File(pathname);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));//建立一个输入流对象
            BufferedReader br = new BufferedReader(reader);//转成计算机能够读懂的语言
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);//一次读入一行数据
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeTxt(String writeTo) {
        try {
            String pathname = writeTo;
            File filename = new File(pathname);
            filename.createNewFile();
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(filename));//建立一个输出流对象
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write("写入文件111111ccccccc\r\n");//\r\n为换行
            bw.write("写入文件2222aaaccccccc\r\n");//\r\n为换行
            bw.flush();//把缓存区内容写入文件
            bw.close();//关闭文件
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        readTxt("inputTxt.txt");
        writeTxt("outputTxt.txt");
    }
}
