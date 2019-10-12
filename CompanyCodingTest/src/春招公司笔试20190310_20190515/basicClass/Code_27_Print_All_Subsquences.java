package 春招公司笔试20190310_20190515.basicClass;

public class Code_27_Print_All_Subsquences {//打印一个字符串的全部子序列
    public  void printAllSubsquences(char[] str,int i,String res ) {
        if (i == str.length) {
            System.out.println(res);
            return;
        }
        printAllSubsquences(str,i+1,res);
        printAllSubsquences(str,i+1,res+String.valueOf(str[i]));
    }

    public static void main(String[] args) {
        Code_27_Print_All_Subsquences a=new Code_27_Print_All_Subsquences();
        String temp = "abab";
        a.printAllSubsquences(temp.toCharArray(),0,"");
    }
}
