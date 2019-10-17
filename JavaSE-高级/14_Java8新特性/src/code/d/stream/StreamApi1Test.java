package code.d.stream;

import code.c.methodreferences.Employee;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream Api 实例化测试
 * <p>
 * 1.Stream关注的是对数据的运算，与cpu打交道
 * 集合关注的是数据的存储，与内存打交道
 * <p>
 * 2.  ① Stream自己不会存储元素
 * ② Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream
 * ③ Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行
 * <p>
 * 3. Stream 执行流程
 * ① Stream的实例化
 * ② 一系列的中间操作（过滤、映射、...）
 * ③ 终止操作
 * 4. 说明：
 * ①一个中间操作链，对于源数据进行处理
 * ②一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用
 *
 * @author Jerry
 * @create 2019-10-15 14:57
 */
public class StreamApi1Test {
    /**
     * 创建Stream 方式一 通过集合
     */
    @Test
    public void test01() {
        List<Employee> employees = EmployeeData.getEmployees();
        //顺序流
        Stream<Employee> stream = employees.stream();
        //并行流
        Stream<Employee> parallelStream = employees.parallelStream();
    }

    /**
     * 方式二 通过数组
     */
    @Test
    public void test02() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(10086, "Tom");
        Employee e2 = new Employee(10087, "Jerry");
        Employee[] arr1 = new Employee[]{e1, e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);
    }

    /**
     * 方式三 通过Stream 的of
     */
    @Test
    public void test03() {

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
    }

    /**
     * 方式四 创建无限流
     */
    @Test
    public void test04(){
        //迭代
        //public static<T> Stream<T> iterate(final T seed,final UnaryOperator<T> f)
        //遍历前十个偶数
        Stream.iterate(0,t->t+2).limit(10).forEach(System.out::println);
        //生成
        //public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
