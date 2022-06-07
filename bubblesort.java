import java.util.Arrays;
import java.util.Scanner;

public class bubblesort {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.println("请输入字符串:");
        char[] chars = in.next().toCharArray();
        int length =chars.length;
        int[] ascii =new int[length];
        for (int i = length-1; i >=0; i--) {
            for (int j = length-1-i; j >=1 ; j--) {
                int a=Integer.valueOf(chars[j]);
                int b=Integer.valueOf(chars[j-1]);
                if(a>b){
                    char tmp = chars[j];
                    chars[j]=chars[j-1];
                    chars[j-1]=tmp;
                }
            }
        }
        for (int i = 0; i <length ; i++) {
            ascii[i]=Integer.valueOf(chars[i]);
        }
        String res=String.valueOf(chars);
        System.out.println("有序字符串:"+res);
        System.out.println("ASCII码："+Arrays.toString(ascii));
    }
}
