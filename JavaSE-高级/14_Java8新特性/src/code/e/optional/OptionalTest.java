package code.e.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * Optional类 测试
 * 防止空指针异常
 * @author Jerry
 * @create 2019-10-16 16:13
 */
public class OptionalTest {
    /**
     * 创建 Optional类对象的方法
     *     Optional.of(T t):创建一个Optional实例 ，t 必须非空
     *     Optional.empty():创建一个空的Optional实例
     *     Optional.ofNullable(T t) : t可以为null
     *
     * 判断Optional容器中是否包含对象
     *     boolean isPresent()：判断是否包含对象
     *     void ifPresent(Consumer<? super T> consumer) :如果有值，就执行Consumer接口实现的代码，
     *     并且该值会作为参数传给它
     *
     * 获取Optional容器的对象
     *     T get():如果调用对象包含值，返回该值，否则抛异常
     *     T orElse(T other):如果有值则将其返回，否则返回由Supplier接口实现提供的对象
     *     T orElseThrow(Supplier<? extend X> exceptionSupplier):如果有值则将其返回，否则抛出由Supplier接口实现
     *     提供的异常
     */
    @Test
    public void test01(){
        Girl girl=new Girl();
        Optional<Girl> optionalGirl = Optional.of(girl);
    }
}
