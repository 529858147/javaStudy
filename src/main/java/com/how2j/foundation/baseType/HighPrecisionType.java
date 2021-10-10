package com.how2j.foundation.baseType;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description: BigInteger, BigDecimal高精度类
 * @date 2021/10/10 17:55
 */
public class HighPrecisionType {
    public static void main(String[] args) {
        /**
         * 一、BigInteger
         * BigInteger相比Integer的确可以用big来形容。它是用于科学计算，Integer只能容纳一个int，所以，最大值也就是2的31次访减去1，十进制为2147483647。
         * 但是，如果需要计算更大的数，31位显然是不够用的，那么，此时BigInteger就能满足我们的需求了。
         * BigInteger能够容纳的位数那可就大了，我简单试了一下，上千位没有任何问题。
         * 除了容量大之外，BigInteger还封装了一些常见的操作，比如加减乘除的基本操作，还有绝对值，相反数，最大公约数，是否是质数等等的运算。
         */
        BigInteger bigInteger = new BigInteger("100");
        BigInteger mod = bigInteger.mod(new BigInteger("200"));
        System.out.println("BigInteger: " + mod);

        /**
         * BigDecimal的实现利用到了BigInteger， 所不同的是，BigDecimal加入了小数位的概念
         * BigDecimal可以用来做超大的浮点数的运算，比如加减乘除的运算，其中除法运算是最复杂的。因为，在商的位数还有除不断的情况下，末位小数点的处理都是需要考虑的。
         * BigDecimal.ROUND_UP：最后一位如果大于0，则向前进一位，正负数都如此。 　　
         * BigDecimal.ROUND_DOWN：最后一位不管是什么都会被舍弃。 　　
         * BigDecimal.ROUND_CEILING：如果是正数，按ROUND_UP处理；如果是负数，按照ROUND_DOWN处理。例如，7.1->8；-7.1->-7。所以，这种近似的结果都会>=实际值。 　　
         * BigDecimal.ROUND_FLOOR：跟BigDecimal_ROUND_CEILING相反。例如，7.1->7；-7.1->-8。这种处理的结果<=实际值。 　　
         * BigDecimal.ROUND_HALF_DOWN：如果最后一位<=5则舍弃，如果>5， 向前进一位。如，7.5->7；7.6->8；-7.5->-7 。　　
         * BigDecimal.ROUND_HALF_UP：如果最后一位<5则舍弃，如果>=5， 向前进一位。反之舍弃。如，7.5->8；7.4->7；-7.5->-8 。　　
         * BigDecimal.ROUND_HALF_EVEN：如果倒数第二位是奇数，按照BigDecimal.ROUND_HALF_UP处理；如果是偶数，按照BigDecimal.ROUND_HALF_DOWN来处理。如，7.5->8；8.5->8；7.4->7；-7.5->-8。
         */
        BigDecimal bigDecimal = new BigDecimal(new BigInteger("100"), 5);//5表示的是5个小数位。
        System.out.println("BigDecimal: " + bigDecimal.toString());
        BigDecimal divide = new BigDecimal(100).divide(new BigDecimal(6), 2, BigDecimal.ROUND_UP);
        System.out.println("BigDecimal divide: " + divide);
    }
}
