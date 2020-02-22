package bitwise;

/**
 * @author hushishuai
 * @date 2019/11/21
 *
 * 利用移位将十进制转为二进制输出。
 */
public class DecimalToBinary {
    public static void main(String[] args) {
        int i = 1000;
        binaryToDecimal(i);
    }

    public static void binaryToDecimal(int n){
        for(int i = 31;i >= 0; i--)
            System.out.print(n >>> i & 1);
    }
}
