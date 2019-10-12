package code.b.functional;

/**
 * 自定义函数式接口
 * @author Jerry
 * @create 2019-10-12 10:46
 */
@FunctionalInterface
public interface MyFunctionalInterface {
    /**
     *  获取键盘传入的值
     * @param value  键盘传入的值
     */
  void getValue(String value);
}
