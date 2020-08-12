package online.kyralo.amall.common;

import online.kyralo.amall.common.utils.CommonUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/6/30
 * \* Time: 22:07
 * \* Description: 通用测试
 * \
 */
public class CommonTest {

    @Test
    public void demo01Test() throws Exception {
        double i = 89899.006;
        int[] ints = CommonUtil.priceParse(i);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void excTest() {
    }

    @Test
    public void queryTest() {
        /*
         * 1: 0000 0001
         * 2: 0000 0010
         *    0000 0011
         *    0000 0000
         *    0000 0011
         *
         *   b ^ c = a ^ (b ^ c) ^ a = x ^ a
         *   x = 255
         *   e.g
         *   a = 1 -> 255 ^ 1 = 254 -> b ^ c =254 -> c = 254 ^ b
         */
        System.out.println(1|2);
        System.out.println(1&2);
        System.out.println(1^2);
        System.out.println(1^255);

        int min = 255;

        for (int i = 0; i < 254; i++) {
            int c = 254 ^ i;
            if (i - c < 0){
                continue;
            }
            if (i - c == 2){
                System.out.println(i);
                System.out.println(c);
            }
            min = Math.min(min, (i - c));

        }

        System.out.println(min);
    }
}
