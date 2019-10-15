package code.d.stream;

import code.c.methodreferences.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

/**
 * Stream中间操作测试
 * @author Jerry
 * @create 2019-10-15 22:44
 */
public class StreamApi1Test {
    /**
     * 筛选与切片
     *
     * filter(Predicate p)接收Lambda,从流中排除某些元素
     *
     * distinct() 筛选，通过流所生成元素的hashCode和equals()去除重复元素
     *
     * limit(long maxSize) 截断流，使元素不超过给定数量
     *
     * skip(long n) 跳过元素，返回一个扔掉了前n个元素的流、若元素中元素不足n个，则返回一个空流，与limit(n)互补
     */
    @Test
    public void test01(){
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> stream = employees.stream();
        stream.filter(e->e.getSalary()>7000).forEach(System.out::println);
        System.out.println("从这里区分");
        Stream<Employee> stream1 = employees.stream();
        stream1.limit(5).forEach(System.out::println);
    }

}
