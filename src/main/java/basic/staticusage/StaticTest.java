package basic.staticusage;

/**
 * @author hushishuai
 * @date 2020/3/7
 */
public class StaticTest {
    public static String name = "zhangsan";
    public static int age = 20;
    private String address = "China";

    public static void printAge() {
        System.out.println(age);
    }
    public void printAddress(){
        System.out.println(address);
    }

    /**
     * static代码块，会在类加载时自动执行，代码块内能调用static变量和static函数
     * 调用实例变量和成员函数会失败。
     */
    static {
        System.out.println(name);
        printAge();
        //System.out.println(address);
        //printAddress();
    }

    public static void main(String[] args) {
        //静态代码块，在类被加载的时候就会自动执行，因此即便main函数中什么都没有，但是运行该程序，也会打印出“zhangsan”和20；
        //即便没有main函数，static代码块同样会被调用。
    }
}
