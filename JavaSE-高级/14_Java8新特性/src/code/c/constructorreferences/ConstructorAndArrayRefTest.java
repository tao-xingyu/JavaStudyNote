package code.c.constructorreferences;

import code.c.methodreferences.Employee;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 *      和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致
 *      抽象方法的返回类型即为构造器所属的类的类型
 *
 * 二、数组引用
 *     可以把数组看成一个特殊的类 ，写法与构造器引用一致
 * @author Jerry
 * @create 2019-10-15 9:29
 */
public class ConstructorAndArrayRefTest {
    /**
     * 构造器引用
     */
    /**
     * Supplier 中的 T get()
     * Employee 中的 空参构造器 Employee()
     */
    @Test
    public void test01(){
        Supplier<Employee> sup1=()->new Employee();
        sup1.get();

        Supplier<Employee> sup2=Employee::new;
        sup2.get();
    }

    /**
     * Function 中的 R apply(T t)
     * Employee 中的 有参构造器 Employee(id)
     */
    @Test
    public void test02(){
        Function<Integer,Employee> fun1=id->new Employee(id);
        System.out.println(fun1.apply(10));

        Function<Integer,Employee> fun2=Employee::new;
        System.out.println(fun2.apply(19));
    }

    /**
     * BiFunction 中的 R apply(T t,U u)
     * Employee 中的 有参构造器 Employee(id,name)
     */
    @Test
    public void test03(){
        BiFunction<Integer,String,Employee> fun1=(id,name)->new Employee(id,name);
        System.out.println(fun1.apply(11, "Jerry"));

        BiFunction<Integer,String,Employee> fun2=Employee::new;
        System.out.println(fun2.apply(13, "Tom"));
    }

    /**
     * 数组引用
     */
    /**
     * Function 中的 R apply(T t)
     * String数组
     */
    @Test
    public void test04(){
        Function<Integer,String[]> fun1=length->new String[length];
        String[] apply = fun1.apply(5);
        System.out.println(Arrays.toString(apply));

        Function<Integer,String[]> fun2=String[]::new;
        System.out.println(Arrays.toString(fun2.apply(19)));
    }
}
