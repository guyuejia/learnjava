package datatype;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hushishuai
 * @date 2020/3/2
 */
public class ListType {
    public static void main(String[] args) {
        List<String> lstring = new ArrayList<String>();
        lstring.add("Hello");
        lstring.add("world");
        lstring.add("china");
        System.out.println(lstring.get(0));
        lstring.set(0,"hello");
        System.out.println(lstring);
    }
}
