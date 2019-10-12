package code.b.functional;

import org.junit.jupiter.api.Test;

/**
 * 测试自定义函数式接口
 * @author Jerry
 * @create 2019-10-12 11:41
 */
public class MyFunctionalInterfaceTest {
    @Test
    public void test01(){
        MyFunctionalInterface myFunctionalInterface=(value)->System.out.println(value);
        myFunctionalInterface.getValue("测试自定义函数式接口");
    }

}
