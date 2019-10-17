package code.d.stream;

import code.c.methodreferences.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream中间操作测试
 *
 * @author Jerry
 * @create 2019-10-15 22:44
 */
public class StreamApi2Test {
    /**
     * 一、筛选与切片
     * <p>
     * filter(Predicate p)接收Lambda,从流中排除某些元素
     * <p>
     * distinct() 筛选，通过流所生成元素的hashCode和equals()去除重复元素
     * <p>
     * limit(long maxSize) 截断流，使元素不超过给定数量
     * <p>
     * skip(long n) 跳过元素，返回一个扔掉了前n个元素的流、若元素中元素不足n个，则返回一个空流，与limit(n)互补
     */
    @Test
    public void test01() {
        List<Employee> employees = EmployeeData.getEmployees();
        System.out.println("以下是排除流:");
        Stream<Employee> stream = employees.stream();
        //排除 filter(Predicate p)
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);
        System.out.println("以下是截断流:");
        Stream<Employee> stream1 = employees.stream();
        //截断  limit(n)
        stream1.limit(5).forEach(System.out::println);
        System.out.println("以下是筛选流:");
        //筛选 distinct() 通过流所生成元素的hashCode和equals()去除重复元素
        employees.add(new Employee(10010, "拿破仑", 200, 3000000));
        employees.add(new Employee(10010, "拿破仑", 201, 3000000));
        employees.add(new Employee(10010, "拿破仑", 200, 3000000));
        employees.add(new Employee(10010, "拿破仑", 200, 3000000));
        employees.add(new Employee(10010, "拿破仑", 200, 3000000));
        Stream<Employee> stream2 = employees.stream();
        stream2.distinct().forEach(System.out::println);
        System.out.println("以下是跳过流:");
        //跳过 skip(n)
        Stream<Employee> stream3 = employees.stream();
        stream3.skip(3).forEach(System.out::println);
    }

    /**
     * 二、映射
     */
    @Test
    public void test02() {
        //map(Function f)接收一个函数作为参数，该函数会被应用到每个元素上，并将器映射成一个新元素
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        System.out.println("map中间操作将流中的小写变成大写：");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
        System.out.println("map中间操作获取员工姓名长度大于3的员工姓名：");
        //获取员工姓名长度大于3的员工姓名
        //1.获取员工姓名流
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> namesStream = employees.stream().map(Employee::getName);
        //2.从姓名流中排除姓名长度小于3的员工姓名
        namesStream.filter(str -> str.length() > 3).forEach(System.out::println);
        System.out.println("flatMap中间操作：");
        //flatMap(Function f) 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有的流连接成一个流
        list.stream().flatMap(StreamApi2Test::fromStringToStream).forEach(System.out::println);

    }

    /**
     * 将字符串中多个字符构成的集合转换成Stream实例
     *
     * @param str 字符串
     * @return 转换后的字符流
     */
    public static Stream<Character> fromStringToStream(String str) {
        List<Character> list = new ArrayList<>();
        for (Character character : str.toCharArray()) {
            list.add(character);
        }
        return list.stream();
    }

    /**
     * 三、排序
     */
    @Test
    public void test03() {
        //sorted() 产生一个新流，其中按自然顺序排序
        List<Integer> list=Arrays.asList(12,23,45,34,66,99,0,-100,2);
        list.stream().sorted().forEach(System.out::println);
        //Employee没有实现Comparable接口不能用自然排序
        //sorted(Comparator com) 产生一个新流，其中按比较器顺序排序。（定制排序）
        List<Employee> employees=EmployeeData.getEmployees();
        employees.stream().sorted((e1,e2)->{
            int ageValue=Integer.compare(e1.getAge(),e2.getAge());
            if(ageValue!=0){
                return ageValue;
            }else {
                return -Double.compare(e1.getSalary(),e2.getSalary());
            }
        }).forEach(System.out::println);

    }
}
