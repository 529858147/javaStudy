package com.how2j.java.foundation.baseType;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description: Java语言提供了八种基本类型。六种数字类型（四个整数型，两个浮点型），一种字符类型，还有一种布尔型。
 * @date 2021/10/8 22:19
 */
public class BaseType {
    public static void main(String[] args) {
        /**
         * byte 数据类型是8位、有符号的，以二进制补码表示的整数；
         * 最小值是 -128（-2^7）；
         * 最大值是 127（2^7-1）；
         * 默认值是 0；
         * byte 类型用在大型数组中节约空间，主要代替整数，因为 byte 变量占用的空间只有 int 类型的四分之一；
         * 例子：byte a = 100，byte b = -50。
         * 对应的包装类 Byte
         */
        byte a = 0;
        Byte b = new Byte(a);
        System.out.println("Byte:" + b.doubleValue());

        /**
         * short 数据类型是 16 位、有符号的以二进制补码表示的整数
         * 最小值是 -32768（-2^15）；
         * 最大值是 32767（2^15 - 1）；
         * Short 数据类型也可以像 byte 那样节省空间。一个short变量是int型变量所占空间的二分之一；
         * 默认值是 0；
         * 例子：short s = 1000，short r = -20000。
         * 包装类型为 Short
         */
        short s = 1000;
        Short aShort = new Short(s);
        System.out.println("Short:" + aShort.shortValue());

        /**
         * int 数据类型是32位、有符号的以二进制补码表示的整数；
         * 最小值是 -2,147,483,648（-2^31）；
         * 最大值是 2,147,483,647（2^31 - 1）；
         * 一般地整型变量默认为 int 类型；
         * 默认值是 0 ；
         * 例子：int a = 100000, int b = -200000。
         * 包装类为 Integer
         * Byte、Short、Integer、Long、Char这几个装箱类的valueOf()方法是以128位分界线做了缓存的，
         * 假如是128以下且-128以上的值是会取缓存里面的引用的：
         */
        int i = 0;
        Integer integer = new Integer(i);
        System.out.println("Integer: " + integer.intValue());

        /**
         * long 数据类型是 64 位、有符号的以二进制补码表示的整数；
         * 最小值是 -9,223,372,036,854,775,808（-2^63）；
         * 最大值是 9,223,372,036,854,775,807（2^63 -1）；
         * 这种类型主要使用在需要比较大整数的系统上；
         * 默认值是 0L；
         * 例子： long a = 100000L，Long b = -200000L。
         * "L"理论上不分大小写，但是若写成"l"容易与数字"1"混淆，不容易分辩。所以最好大写。
         * 包装类为 Long
         */
        long l = 100000L;
        Long aLong = Long.valueOf(1);
        /**
         * float 数据类型是单精度、32位、符合IEEE 754标准的浮点数；
         * float 在储存大型浮点数组的时候可节省内存空间；
         * 默认值是 0.0f；
         * 浮点数不能用来表示精确的值，如货币；
         * 例子：float f1 = 234.5f。
         * 包装类为 Float
         */
        float f = 234.5f;

        /**
         * double 数据类型是双精度、64 位、符合 IEEE 754 标准的浮点数；
         * 浮点数的默认类型为 double 类型；
         * double类型同样不能表示精确的值，如货币；
         * 默认值是 0.0d；
         * 包装类为 Double
         */
        double d = 0.1d;

        /**
         * boolean数据类型表示一位的信息；
         * 只有两个取值：true 和 false；
         * 这种类型只作为一种标志来记录 true/false 情况；
         * 默认值是 false；
         * 例子：boolean one = true。
         * 包装类为 Boolean
         */
        boolean flag = true;

        /**
         * char 类型是一个单一的 16 位 Unicode 字符；
         * 最小值是 \u0000（十进制等效值为 0）；
         * 最大值是 \uffff（即为 65535）；
         * char 数据类型可以储存任何字符；
         * 例子：char letter = 'A';
         * 包装类为 Character
         */
        char c = 'a';

    }
}
