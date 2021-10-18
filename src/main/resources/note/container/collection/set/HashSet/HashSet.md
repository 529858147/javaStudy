## HashSet详解

### 1. 数据结构

#### 1.1 构造器详解

* HashSet()：创建一个默认capacity (16) and the default load factor (0.75)的HashMap实例
* HashSet(Collection<? extends E> c): 构造一个包含指定集合中的元素的新集合。
* HashSet(int initialCapacity): 构造一个新的空集合, 背景HashMap实例具有指定的初始容量和默认负载因子（0.75）。
* HashSet(int initialCapacity, float loadFactor): 构造一个新的空集合; 背景HashMap实例具有指定的初始容量和指定的负载因子。

#### 1.2 key不重复的算法

* 依赖两个方法： hashCode()和equals()方法
* 执行顺序：
    * 首先比较哈希值是否相同
        * 相同：继续执行equals()方法 返回true：元素重复了，不添加。 返回false：直接把元素添加到集合
        * 不同：就直接把元素添加到集合
* 将自定义类对象存入HashSet进行去重
    * 类中必须重写hashCode()方法和equals()方法
    * equals()方法中比较所有属性
    * hashCode()方法要保证属性相同的对象返回值相同, 属性不同的对象尽量不同，对象的成员变量值相同即为同一个元素

#### 1.3 遍历方法

* 使用迭代器遍历：set.iterator();
* 使用增强For循环遍历：for(String str : set)
* 使用ForEach遍历：set.forEach((s) -> System.out.println(s));