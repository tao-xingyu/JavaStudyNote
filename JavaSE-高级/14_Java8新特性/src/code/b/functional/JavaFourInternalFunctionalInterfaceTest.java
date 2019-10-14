package code.b.functional;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Java内置四大核心函数式接口
 *
 * 消费型接口 Consumer<T> void accept(T t)
 *
 * 供给型接口 Supplier<T> T get()
 *
 * 函数型接口 Function<T,R> R apply(T t)
 *
 * 断定型接口 Predicate<T> boolean test(T t)
 * @author Jerry
 * @create 2019-10-12 14:32
 */
public class JavaFourInternalFunctionalInterfaceTest {
    @Test
    public void test01(){
        /**
         * 普通调用
         */
        playtime(5000.0, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("普通方式消费型接口调用了,消费了"+aDouble);
            }
        });
        /**
         * lambda方式调用
         */
        playtime(4000.0,money->System.out.println("lambda方式消费型接口调用了,消费了"+money));

    }

    /**
     *  娱乐时间
     * @param money 钱
     * @param con 消费型接口实例对象
     */
    public void playtime(Double money, Consumer<Double> con){
        con.accept(money);
    }
    @Test
    public void test02(){
        List<String> list = Arrays.asList("北京", "南京", "东京", "西京", "天津", "上海");
        /**
         * 普通方法调用包含断定型接口为参数的方法
         */
        List<String> filterString = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(filterString);
        /**
         * lambda方式调用调用包含断定型接口为参数的方法
         */
        List<String> filterString1 = filterString(list, str -> str.contains("津"));
        System.out.println(filterString1);
    }
    /**
     * 根据指定规则，过滤集合中的字符串。 此规则由断定型接口Predicate的方法决定
     *
     * @param list 需要过滤的字符串集合
     * @param pre 过滤规则
     * @return 过滤后的字符串集合
     */
    public List<String> filterString(List<String> list, Predicate<String> pre){
        //接收按指定规则过滤后的集合
        ArrayList<String> filterList=new ArrayList<>();
        for(String str:list){
            if(pre.test(str)){
                filterList.add(str);
            }
        }
        return filterList;
    }
}
