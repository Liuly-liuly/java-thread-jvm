package cn.designer.chapter5;

public class StringTest {
    public static void main(String[] args) {
        String s = "Hello";
        String s2 = s.replace("l", "k");
        System.out.println(s2.getClass() + " " + s2.hashCode());
        System.out.println(s.getClass() + " " + s.hashCode());
    }
}
