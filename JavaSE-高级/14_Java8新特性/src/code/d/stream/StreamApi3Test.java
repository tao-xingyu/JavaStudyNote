package code.d.stream;

import code.c.methodreferences.Employee;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Stream API 终止操作
 *
 * @author Jerry
 * @create 2019-10-17 9:38
 */
public class StreamApi3Test {
    /**
     * 一、匹配与查找
     * allMatch(Predicate p)  检查是否匹配所有元素
     * anyMatch(Predicate p)  检查是否至少匹配一个元素
     * noneMatch(Predicate p) 检查是否没有匹配的元素
     * findFirst()  返回第一个元素
     * findAny() 返回当前流中任意元素
     * count() 返回流中元素总数
     * max(Comparator c) 返回流中最大值
     * min(Comparator c) 返回流中最小值
     * forEach(Consumer c)内部迭代(使用Collection接口需要用户去做迭代，称为外部迭代。相反，Stream API使用内部迭代-它帮你做了迭代)
     */
    @Test
    public void test01() {
        List<Employee> employees = EmployeeData.getEmployees();
        //allMatch(Predicate p)  检查是否匹配所有元素
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(allMatch);
        //anyMatch(Predicate p)  检查是否至少匹配一个元素
        boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(anyMatch);
        //noneMatch(Predicate p) 检查是否没有匹配的元素
        boolean noneMatch = employees.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(noneMatch);
        //findFirst()  返回第一个元素
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);
        //findAny() 返回当前流中任意元素
        Optional<Employee> optionalEmployee = employees.stream().findAny();
        System.out.println(optionalEmployee);
        //count() 返回流中元素总数
        long count = employees.stream().count();
        System.out.println(count);
        //max(Comparator c) 返回流中最大值
        Optional<Double> maxStream = employees.stream().map(e -> e.getSalary()).max(Double::compare);
        System.out.println(maxStream);
        //min(Comparator c) 返回流中最小值
        Optional<Double> minStream = employees.stream().map(e -> e.getSalary()).min(Double::compare);
        System.out.println(minStream);
        //forEach(Consumer c)内部迭代(使用Collection接口需要用户去做迭代，称为外部迭代。相反，Stream API使用内部迭代-它帮你做了迭代)
        employees.stream().forEach(System.out::println);
    }

    /**
     * 二、规约
     *  T reduce(T  t,BinaryOperator b) 可以将流中的元素反复结合起来，得到一个值。 返回T
     *  Optional<T> reduce(BinaryOperator b) 可以将流中的元素反复结合起来，得到一个值。返回Optional<T>
     *
     *  备注：中间操作的map和reduce的连接通常称为map-reduce模式，因为Google用它来进行网络搜索而出名
     */
    @Test
    public void test02(){
        //T reduce(T  t,BinaryOperator b) 可以将流中的元素反复结合起来，得到一个值。 返回T
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //1-10的自然数和
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        //Optional<T> reduce(BinaryOperator b) 可以将流中的元素反复结合起来，得到一个值。返回Optional<T>
        //计算公司所有员工的工资之和
        List<Employee> employees = EmployeeData.getEmployees();
        Optional<Double> sumSalary = employees.stream().map(e -> e.getSalary()).reduce(Double::sum);
        System.out.println(sumSalary);
    }

    /**
     * 三、收集
     * collect(Collector c) 将流转换为其他形式，接收一个Collector接口的实现方法，用于给Stream中元素做汇总的方法
     * Collector接口中的方法实现决定了如何对流执行收集的操作(如收集到List、Set、Map)
     * 另外，Collector实用类提供了很多静态方法，可以方便地创建常见收集器实例
     *
     * Collector的方法：
     * List<T> toList() 把流中元素收集到List
     * Set<T> toSet() 把流中元素收集到Set
     * Collection<T> toCollection() 把流中元素收集到集合
     *
     */
    @Test
    public void test03(){
        List<Employee> employees = EmployeeData.getEmployees();
        //查询工资大于6000的员工，结果返回一个list
        List<Employee> list = employees.stream().filter(e -> e.getSalary() > 9000).collect(Collectors.toList());
        list.forEach(System.out::println);
    }
}
