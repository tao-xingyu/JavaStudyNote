package code.a.lambda;

import org.junit.jupiter.api.Test;
import java.util.Comparator;

/**
 * Lambada表达式使用入门
 * @author Jerry
 * @create 2019-10-11 17:10
 */
public class Lambda01Test {
    /***
     * 原生方式调Runnable接口run方法
     */
    @Test
    public void test01(){
        Runnable r1=new Runnable() {
            @Override
            public void run() {
                System.out.println("不使用lambda表达式");
            }
        };
        r1.run();
    }

    /**
     * 使用lambda方式调Runnable接口run方法
     */
    @Test
    public void test02(){
        Runnable r2=() -> System.out.println("使用lambda表达式");
        r2.run();
    }

    /**
     * 使用原生方式调用Comparator接口compare方法
     */
    @Test
    public void test03(){
        Comparator<Integer> comparator=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        System.out.println(comparator.compare(11, 12));
    }

    /**
     * 使用lambda方式调用Comparator接口compare方法
     */
    @Test
    public void test04(){
        Comparator<Integer> comparator=(o1,o2)->Integer.compare(o1,o2);
        System.out.println(comparator.compare(11, 12));
    }
}
