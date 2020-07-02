package online.kyralo.amall.common;

import online.kyralo.amall.common.utils.CommonUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * \* Created with Intellij IDEA.
 * \* @author: wangchen
 * \* Date: 2020/6/30
 * \* Time: 22:07
 * \* Description: 通用测试
 * \
 */
public class CommonTest {

    @Test
    public void test01() throws Exception {
        double i = 89899.006;
        int[] ints = CommonUtil.priceParse(i);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void exception() {


    }
}
