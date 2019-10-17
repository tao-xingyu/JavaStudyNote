package code.e.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * Optional类 测试
 * 防止空指针异常
 *
 * @author Jerry
 * @create 2019-10-16 16:13
 */
public class OptionalTest {
    /**
     * 创建 Optional类对象的方法
     * Optional.of(T t):创建一个Optional实例 ，t 必须非空
     * Optional.empty():创建一个空的Optional实例
     * Optional.ofNullable(T t) : t可以为null
     * <p>
     * 判断Optional容器中是否包含对象
     * boolean isPresent()：判断是否包含对象
     * void ifPresent(Consumer<? super T> consumer) :如果有值，就执行Consumer接口实现的代码，
     * 并且该值会作为参数传给它
     * <p>
     * 获取Optional容器的对象
     * T get():如果调用对象包含值，返回该值，否则抛异常
     * T orElse(T other):如果有值则将其返回，否则返回由Supplier接口实现提供的对象
     * T orElseThrow(Supplier<? extend X> exceptionSupplier):如果有值则将其返回，否则抛出由Supplier接口实现
     * 提供的异常
     */
    @Test
    public void test01() {
        Girl girl = new Girl();
        //girl=null;
        Optional<Girl> optionalGirl = Optional.of(girl);
    }

    @Test
    public void test02() {
        Girl girl = new Girl();
        girl = null;
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl);
        Girl girl1 = optionalGirl.orElse(new Girl("赵丽颖"));
        System.out.println(girl1);
    }

    @Test
    public void test03() {
        Boy boy = null;
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }

    @Test
    public void test04() {
        Boy boy = null;
        String girlName1 = getGirlName1(boy);
        System.out.println(girlName1);
    }

    @Test
    public void test05() {
        Boy boy=null;
        String girlName2 = getGirlName2(boy);
        System.out.println(girlName2);
    }

    /**
     * 查询女生姓名（存在空指针异常）
     *
     * @param boy 男生信息
     * @return 女生姓名
     */
    public String getGirlName(Boy boy) {
        return boy.getGirl().getName();
    }

    /**
     * 查询女生姓名（优化后的）
     *
     * @param boy
     * @return 女生姓名
     */
    public String getGirlName1(Boy boy) {
        if (boy != null) {
            Girl girl = boy.getGirl();
            if (girl != null) {
                return girl.getName();
            }
        }
        return null;
    }

    /**
     * 使用Optional优化
     *
     * @param boy
     * @return
     */
    public String getGirlName2(Boy boy) {
        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("迪丽热巴")));
        Girl girl = boy1.getGirl();
        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        Girl girl1 = girlOptional.orElse(new Girl("古力娜扎"));
        return girl1.getName();
    }
}
