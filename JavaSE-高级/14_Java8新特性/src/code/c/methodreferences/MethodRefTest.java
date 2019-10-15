package code.c.methodreferences;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 测试方法引用
 *
 *   1.使用情景 ： 当要传递给Lambda体的操作，已经有了实现的的方法了，可以使用方法引用
 *
 *   2.方法引用，本质上就是Lambda表达式，而Lambda表达式作为函数式接口的实例。所以方法引用，也是函数式接口的实例
 *
 *   3.使用格式 ： 类（或对象）::方法名
 *
 *   4.具体分为如下的三种情况：
 *      情况1：  对象::非静态方法
 *      情况2:   类::静态方法
 *      情况3:   类::非静态方法
 *
 *   5.方法引用使用的要求：要求接口中的抽象方法的形参列表和返回值与方法引用的方法形参列表和返回值类型相同
 *   （针对于情况1和情况2）
 * @author Jerry
 * @create 2019-10-14 16:47
 */
public class MethodRefTest {

    /**
     *情况1： 对象::非静态方法
     */
    /**
     * Consumer 中的 void accept(T t)
     * PrintStream中的 void println(T t)
     */
    @Test
    public void test01(){
        Consumer<String> con1=str-> System.out.println(str);
        con1.accept("非静态方法测试");
        PrintStream ps =System.out;

        Consumer<String> con2=ps::println;
        con2.accept("方法引用非静态方法测试");
    }

    /**
     * Supplier 中的 T get()
     * Employee 中的 String getName()
     */
    @Test
    public void test02(){
        Employee emp=new Employee(10086,"Jerry",23,9900.0);
        Supplier<String> sup1=()->emp.getName();
        System.out.println(sup1.get());

        Supplier<String> sup2=emp::getName;
        System.out.println("方法引用"+sup2.get());
    }

    /**
     * 情况2 类::静态方法
     */
    /**
     * Comparator 中的 int compare(T t1,T t2)
     * Integer 中的 int compare(T t1,T t2)
     */
    @Test
    public void test03(){
        Comparator<Integer> com1=(t1,t2)->Integer.compare(t1,t2);
        System.out.println(com1.compare(12, 22));

        Comparator<Integer> com2=Integer::compare;
        System.out.println(com2.compare(22, 11));
    }

    /**
     * Function 中的 R apply(T t)
     * Math 中的 Long round(Double d) 四舍五入方法
     */
    @Test
    public void test04(){
        Function<Double,Long> fun1=d->Math.round(d);
        System.out.println(fun1.apply(12.3));

        Function<Double,Long> fun2=Math::round;
        System.out.println(fun2.apply(12.6));
    }

    /**
     * 情况3 类::非静态方法
     */
    /**
     * Comparator 中的 int compare(T t1,T t2)
     * String 中的 int t1.compareTo(t2)
     */
    @Test
    public void test05(){
        Comparator<String> com1=(t1,t2)->t1.compareTo(t2);
        System.out.println(com1.compare("abcd", "acdf"));

        Comparator<String> com2=String::compareTo;
        System.out.println(com2.compare("abcdef", "abcdee"));
    }

    /**
     * BiPredicate 中的 boolean test(T t1,T t2)
     * String 中的 boolean t1.equals(t2)
     */
    @Test
    public void test06(){
        BiPredicate<String,String> bip1=(t1,t2)->t1.equals(t2);
        System.out.println(bip1.test("ABC","ABC"));
        BiPredicate<String,String> bip2=String::equals;
        System.out.println(bip2.test("ABC","AB"));
    }

    /**
     * Function 中的 R apply(T t)
     * Employee 中的 String getName()
     */
    @Test
    public void test07(){
        Employee emp=new Employee(10086,"Jerry",23,9900.0);
        Function<Employee,String> fun1=e->e.getName();
        System.out.println(fun1.apply(emp));
        Function<Employee,String> fun2=Employee::getName;
        System.out.println("方法引用"+fun2.apply(emp));

    }
}
