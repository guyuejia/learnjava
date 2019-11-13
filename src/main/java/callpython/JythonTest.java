package callpython;

import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

/**
 * @author hushishuai
 * @date 2019/11/13
 *
 * 利用Jython来实现在java程序中调用python程序
 * Jython是一种完整的语言，而不是一个Java翻译器或仅仅是一个Python编译器，它是一个Python语言在Java中的完全实现。
 * Jython也有很多从CPython中继承的模块库，但是并不全。如果python程序中调用了第三方库，就会报错：java ImportError: No module named xxx。
 * 因此利用Jython只能调用一些比较简单的python程序，当python利用了大量第三方库时，这种就不合适了。
 * 使用说明参考：https://blog.csdn.net/qq_26591517/article/details/80441540
 * maven依赖如下
 * <dependency>
 *  <groupId>org.python</groupId>
 *  <artifactId>jython-standalone</artifactId>
 *  <version>2.7.0</version>
 * </dependency>
 */
public class JythonTest {
    public static void main(String[] args) {
        PythonInterpreter pythonInterpreter = new PythonInterpreter();
        //直接把python语句作为参数写进来
        pythonInterpreter.exec("a=[1,2,3,4,5]");
        pythonInterpreter.exec("print(a)");

        PyObject pyObject = addBasePython(5, 60);
        System.out.println(pyObject);
    }

    public static PyObject addBasePython(int a, int b){
        PythonInterpreter pythonInterpreter = new PythonInterpreter();
        pythonInterpreter.execfile("resource/pythonshell/add.py");
        // 第一个参数为期望获得的函数（变量）的名字，第二个参数为期望返回的对象类型
        PyFunction pyFunction = pythonInterpreter.get("add", PyFunction.class);
        //调用函数，如果函数需要参数，在Java中必须先将参数转化为对应的“Python类型”
        PyObject pyObject = pyFunction.__call__(new PyInteger(a), new PyInteger(b));
        return pyObject;
    }
}
