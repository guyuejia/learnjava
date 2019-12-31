package getclasspath;

import java.io.*;

/**
 * @Author: gujiayue
 * @Description: 读取项目内的文件的集中方法
 * @Date: Created in 10:37 2019/12/31
 * @Modified By:
 */
public class GetClassPath {
    public static void main(String[] args) {
        System.out.println("系统的classpath路径：" + System.getProperty("java.class.path"));
        System.out.println("项目的classpath路径："  + Thread.currentThread().getContextClassLoader ().getResource("").getPath());
        System.out.println(System.getProperty("user.dir"));//用户的当前路径
        getfileByAbs();
        getfileByRel();
        getfileByClassLoader();

    }
    //通过绝对路径获取项目src/resource/hello.txt
    public static void getfileByAbs(){
        //绝对路径
        File file = new File("C:\\Users\\hushishuai\\IdeaProjects\\learnjava\\src\\resource\\hello.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bufferedReader.readLine())!= null)
                System.out.println(line);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //通过相对路径获取项目src/resource/hello.txt
    public static void getfileByRel(){
        //相对路径
        //注意相对路径的写法：learnjava为项目目录，不用写，从一级目录写路径即可。src/resource/hello.txt
        File file = new File("src\\resource\\hello.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bufferedReader.readLine())!= null)
                System.out.println(line);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getfileByClassLoader(){
        //相对路径
        //注意相对路径的写法：learnjava为项目目录，不用写，从一级目录写路径即可。src/resource/hello.txt
        int len = 0;
        byte b[] = new byte[4096];
        try {
            InputStream inputStream = GetClassPath.class.getClassLoader().getResourceAsStream("hello.txt");
            while ((len = inputStream.read(b))!=-1){
                System.out.println(new String(b,0,len));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
