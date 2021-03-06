package callpython;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author hushishuai
 * @date 2019/11/13
 * 利用runtime机制，调用python脚本。只要python脚本本身可以在当前环境正确执行，那java就能调用
 * 本demo展示了无需给脚本传参数的用法
 */
public class RuntimeDemo1 {
    public static void main(String[] args) {
        Process proc;
        try {
            //参数命令要加上python，表示告知系统使用python来执行脚本。
            proc = Runtime.getRuntime().exec("python resource/pythonshell/numpyTest.py");
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
