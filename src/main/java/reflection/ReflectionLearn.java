package reflection;

/**
 * @author hushishuai
 * @date 2020/3/4
 */

class Person{}

public class ReflectionLearn {
    public static void main(String[] args) {
        Person person = new Person();
        Class<? extends Person> aClass = person.getClass();
        String name = aClass.getName();
        System.out.println(person);
        System.out.println(person.getClass());
        System.out.println(person.getClass().getName());
    }
}
