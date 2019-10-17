#### Stream API 笔记

* Stream 到底式什么？

是数据渠道，用于操作数据源（集合、数组等）所生成的元素序列。

“集合讲的是数据，Stream讲的是计算”

* 注意：
  
    * Stream自己不会存储元素
    
    * Stream不会改变源对象。相反，他们会返回一个持有结果的新Stream
    
    * Stream操作是延迟执行的。这意味着他们会等到需要结果的时候才执行。
* Stream的三个操作

    * 1-创建Stream
    
       * 一个数据源(如:集合、数组)，获取一个流
       
    * 2-创建中间操作
    
       * 一个中间操作，对源数据进行处理
    
    * 3-终止操作（终端操作）
       
       * 一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用
       
* 创建Stream的方式
     
    * 一 、通过集合
       
       * Java8中的Collection接口被扩展，提供了两个获取流的方法
       
            * default Stream&lt;E&gt; stream():返回以一个顺序流
            
            * default Stream&lt;E&gt; parallelStream():返回一个并行流
    
    * 二 、通过数组
         
       * Java8中的Arrays的静态方法stream()可以获取数组流
            
            * static&lt;T&gt; Stream&lt;T&gt; stream(T[] array):返回一个流
            
            * 重载形式，能处理对应基本类型数组：
            
               * public static IntStream stream(Int[] arr)
               
               * public static LongStream stream(long[] arr)
               
               * public static DoubleStream stream(double[] arr)
    
    * 三 、通过Stream 的of
       
       * 可以调用Stream类静态方法 of(),通过显示值创建一个流。它可以接收任意数量的参数。
           
           * public static&lt;T&gt; Stream&lt;T&gt; of(T ... values): 返回一个流
    
    * 四 、创建无限流
    
       * 可以使用静态方法 Stream.iterate()和Stream.generate(),创建无限流
              
           * 迭代
                 
               * public static&lt;T&gt; Stream&lt;T&gt; iterate(final T seed,final UnaryOperator&lt;T&gt; f)
                 
           * 生成
                 
               * public static&lt;T&gt; Stream&lt;T&gt; generate(Supplier&lt;T&gt; s)
               
               
* Stream 中间操作

    * 筛选与切片
    
      * filter(Predicate p)接收Lambda,从流中排除某些元素
      
      * distinct() 筛选，通过流所生成元素的hashCode和equals()去除重复元素
      
      * limit(long maxSize) 截断流，使元素不超过给定数量
      
      * skip(long n) 跳过元素，返回一个扔掉了前n个元素的流、若元素中元素不足n个，则返回一个空流，与limit(n)互补
    
    * 映射
    
      * map(Function f)接收一个函数作为参数，该函数会被应用到每个元素上，并将器映射成一个新元素
      
      * flatMap(Function f) 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有的流连接成一个流
    
    * 排序
    
      * sorted() 产生一个新流，其中按自然顺序排序
       
      * sorted(Comparator com) 产生一个新流，其中按比较器顺序排序。（定制排序）
    
    
* Stream 终止操作  

    * 匹配与查找
    
       * allMatch(Predicate p)  检查是否匹配所有元素
       * anyMatch(Predicate p)  检查是否至少匹配一个元素
       * noneMatch(Predicate p) 检查是否没有匹配的元素
       * findFirst()  返回第一个元素
       * findAny() 返回当前流中任意元素
       * count() 返回流中元素总数
       * max(Comparator c) 返回流中最大值
       * min(Comparator c) 返回流中最小值
       * forEach(Consumer c)内部迭代(使用Collection接口需要用户去做迭代，称为外部迭代。相反，Stream API使用内部迭代-它帮你做了迭代)

    * 规约
    
       *  T reduce(T  t,BinaryOperator b) 可以将流中的元素反复结合起来，得到一个值。 返回T
       *  Optional&lt;T&gt; reduce(BinaryOperator b) 可以将流中的元素反复结合起来，得到一个值。返回Optional&lt;T&gt;
       *  备注：中间操作的map和reduce的连接通常称为map-reduce模式，因为Google用它来进行网络搜索而出名
   
    * 收集
    
       * collect(Collector c) 将流转换为其他形式，接收一个Collector接口的实现方法，用于给Stream中元素做汇总的方法
       * Collector接口中的方法实现决定了如何对流执行收集的操作(如收集到List、Set、Map)
       * 另外，Collector实用类提供了很多静态方法，可以方便地创建常见收集器实例
       * Collector的方法：
           * List&lt;T&gt; toList() 把流中元素收集到List
           * Set&lt;T&gt; toSet() 把流中元素收集到Set
           * Collection&lt;T&gt; toCollection() 把流中元素收集到集合
