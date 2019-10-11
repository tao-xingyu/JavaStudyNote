package code.a.lambda;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表达式的使用
 *
 * 1.举例 : (o1,o2) -> Integer.compare(o1,o2);
 * 2.格式 :
 *        ->:lambda 操作符 或 箭头操作符
 *        -> 左边 : lambda 形参列表 （其实就是接口中抽象方法的形参列表）
 *        -> 右边 : lambda 体 （其实就是重写的抽象的方法体）
 *
 * 3. Lambda表达式的使用：(分6种情况)
 *
 *      总结 ：
 *           -> 左边 lambda形参列表的参数类型可以省略
 *           -> 右边 lambda体应该使用一对{}包裹
 *           如果lambda体只有一条执行语句（可能是return语句），{}可以省略，return关建字也可以省略
 *
 * 4.Lambda表达式的本质：作为函数式的接口
 *
 * 5.一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口，我们可以在接口上使用@FunctionalInterface注解
 *
 * 6.所以以前用匿名实现类表示的现在都可以用Lambda表达式来实现
 * @author Jerry
 * @create 2019-10-11 19:58
 */
public class Lambda02Test {

    //语法格式一：无参，无返回值

    @Test
    public void test01(){

        Runnable r1=new Runnable(){
            @Override
            public void run() {
                System.out.println("lambda表达式");
            }
        };
        r1.run();

        System.out.println("******************************");
        //lambda写法
        Runnable r2=() -> System.out.println("lambda表达式");
        r2.run();
    }

    //语法格式二：Lambda 需要一个参数，但是没有返回值

    @Test
    public void test02(){

        Consumer<String> con=new Consumer<String>() {
            @Override
            public void accept(String str) {
                System.out.println(str);
            }
        };
        con.accept("为什么Comparator也可以使用lambda表达式?");
        //lambda写法
        Consumer<String> con1=(String str) -> System.out.println(str) ;

        con1.accept("因为Comparator虽然有多个抽象方法，但是 equals是Object类的重写,default关键字修饰的方法是具体方法，不是抽象方法");
    }

    //语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型推断”

    @Test
    public void test03(){
        Consumer<String> con=new Consumer<String>() {
            @Override
            public void accept(String str) {
                System.out.println(str);
            }
        };
        con.accept("类型推断");
        //lambda写法
        Consumer<String> con1=(str) -> System.out.println(str) ;

        con1.accept("类型推断，参数类型可以省略");
    }

    //语法格式四：Lambda 若只需要一个参数时，参数的小括号可以省略

    @Test
    public void test04(){
        //lambda写法
        Consumer<String> con=str -> System.out.println(str) ;
        con.accept("一个参数，小括号可以省略");
    }

    //语法格式五：Lambda 可以两个或以上的参数，多条执行语句，并且可以有返回值

    @Test
    public void test05(){
        //lambda写法
        Comparator<Integer> com=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        com.compare(11,12);

        //lambda写法
        Comparator<Integer> com1=(o1,o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return Integer.compare(o1,o2);
        };

    }

    //语法格式六：当 Lambda 体只有一条语句时，return 与大括号若有，都可以省略

    @Test
    public void test06(){
        //lambda写法
        Comparator<Integer> com1=(o1,o2) ->Integer.compare(o1,o2);
        System.out.println(com1.compare(11, 21));
    }
}
