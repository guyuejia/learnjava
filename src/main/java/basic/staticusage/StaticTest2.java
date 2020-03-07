package basic.staticusage;

/**
 * @author hushishuai
 * @date 2020/3/7
 */

/**
 * 本段代码揭示了，static代码块、父类、子类构造函数、成员变量的先后执行顺序
 * 加载主类的父类（如果有的话）——加载主类——执行父类的构造函数——执行子类的构造函数，加载类的过程中如果有static块，要先执行static块。
 * 我们来分析下这段代码的执行过程：
 *
 * 找到main方法入口，main方法是程序入口，但在执行main方法之前，要先加载Test类
 * 加载Test类的时候，发现Test类有static块，而是先执行static块，输出test static结果
 * 然后执行new MyClass(),执行此代码之前，先加载MyClass类，发现MyClass类继承Test类，而是要先加载Test类，Test类之前已加载
 * 加载MyClass类，发现MyClass类有static块，而是先执行static块，输出myclass static结果
 * 然后调用MyClass类的构造器生成对象，在生成对象前，需要先初始化父类Test的成员变量，而是执行Person person = new Person("Test")代码，发现Person类没有加载
 * 加载Person类，发现Person类有static块，而是先执行static块，输出person static结果
 * 接着执行Person构造器，输出person Test结果
 * 然后调用父类Test构造器，输出test constructor结果，这样就完成了父类Test的初始化了
 * 再初始化MyClass类成员变量，执行Person构造器，输出person MyClass结果
 * 最后调用MyClass类构造器，输出myclass constructor结果，这样就完成了MyClass类的初始化了
 * ————————————————
 * 版权声明：本文为CSDN博主「Cappuccinooo」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/kuangay/article/details/81485324
 */
public class StaticTest2 {
    Person person = new Person("Test");
    static{
        System.out.println("test static");
    }

    public StaticTest2() {
        System.out.println("test constructor");
    }

    public static void main(String[] args) {
        new MyClass();
    }
}

class Person{
    static{
        System.out.println("person static");
    }
    public Person(String str) {
        System.out.println("person "+str);
    }
}


class MyClass extends StaticTest2 {
    Person person = new Person("MyClass");
    static{
        System.out.println("myclass static");
    }

    public MyClass() {
        System.out.println("myclass constructor");
    }
}

