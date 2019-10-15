package code.d.stream;

import code.c.methodreferences.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * 流测试数据
 * @author Jerry
 * @create 2019-10-15 11:38
 */
public class EmployeeData {

    public static List<Employee> getEmployees(){
        List<Employee> list=new ArrayList<>();
        list.add(new Employee(10001,"马化腾",44,6000));
        list.add(new Employee(10002,"马云",45,7000));
        list.add(new Employee(10003,"刘强东",46,8000));
        list.add(new Employee(10004,"雷军",47,9000));
        list.add(new Employee(10005,"李彦宏",48,10000));
        list.add(new Employee(10006,"比尔盖茨",49,11000));
        list.add(new Employee(10007,"任正非",50,12000));
        list.add(new Employee(10008,"扎克伯格",51,13000));
        return list;
    }
}
