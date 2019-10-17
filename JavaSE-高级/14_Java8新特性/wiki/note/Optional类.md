####Optional笔记

* 到目前为止，臭名昭著的空指针异常是导致Java应用程序失败的最常见原因。
以前，为了解决空指针异常，Google公司著名的Guava项目引入了Optional类，
Guava通过使用检查空值的方式来防止代码污染，它鼓励程序员写更干净的代码。
受到了Google Guava的启发，Optional类已经是Java8的一部分。

* Optional&lt;T&gt; 类（java.util.Optional）是一个容器类，它可以保存类型T
的值，代表这个值存在。或者仅仅保存null,表示这个值不存在。原来用null表示
一个值不存在，现在Optional可以更好的表达这个概念

* Optional类的Javadoc描述如下：这是一个可以为null的容器对象。如果值存在则
isPresent()方法会返回true,调用get()方法返回该对象

* Optional提供了很多有用的方法，这样我们就不用显式进行空值检测

* 创建Optional类对象的方法：
   
     * Optional.of(T t)：创建一个Optional实例，t必须非空
     
     * Optional.empty(): 创建一个空的Optional实例
     
     * Optional.ofNullable(T t): t可以为null
     
* 判断Optional容器中是否包含对象
    
     * boolean isPresent(): 判断是否包含对象
     
     * void ifPresent(Consumer<? super T> consumer):如果有值，就执行Consumer接口
     的实现代码，并且该值会作为参数传递给它
     
* 获取Optional容器的对象
   
     * T get():如果调用对象包含值，返回该值，否则抛异常
     
     * T orElse(T other):如果有值则将其返回，否则返回由Supplier接口实现提供的对象
     
     * T orElseGet(Supplier<? extends other>):如果有值则将其返回，否则返回由Supplier
      接口实现提供的对象
      
     * T orElseThrow(Supplier<? extend X> exceptionSupplier):如果有值则将其返回，否则抛出由Supplier接口实现
       提供的异常