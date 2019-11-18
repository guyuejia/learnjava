package callpython;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author hushishuai
 * @date 2019/11/15
 * 本demo展示了如何给python脚本传递参数
 */
public class RuntimeDemo2 {
    public static void main(String[] args) {
        int a = 18;
        int b = 23;
        try {
            String[] args1 = new String[]{"python", "resource/pythonshell/runtimeDemo2.py", String.valueOf(a), String.valueOf(b)};
            Process proc = Runtime.getRuntime().exec(args1);// 执行py文件

            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

