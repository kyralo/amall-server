package online.kyralo.amall.common;

import lombok.ToString;
import lombok.var;
import online.kyralo.amall.common.utils.CommonUtil;
import online.kyralo.amall.common.utils.CopyUtil;
import online.kyralo.amall.dao.dataobject.TbCommoditySpuDO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.FactoryBean;

import java.util.*;

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
    public void start() {
        TbCommoditySpuDO tbCommoditySpuDO1 = TbCommoditySpuDO.builder()
                .bannerUrl("1")
                .categoryId(1)
                .build();
        TbCommoditySpuDO tbCommoditySpuDO2 = TbCommoditySpuDO.builder()
                .bannerUrl("2")
                .unit("2")
                .sellingPoint("324")
                .build();

        CopyUtil.copyBean(tbCommoditySpuDO1, tbCommoditySpuDO2);
        System.out.println(tbCommoditySpuDO2);
    }

    @ToString
    public static class Demo {
        public String name;
    }

    public void demo(Demo demo) {
        demo.name = "w";
    }

    @Test
    public void queryTest() {

//        Demo v = new Demo();
//        v.name = "a";
//        demo(v);
//
//        System.out.println(v);

        Object a = -4 >>> 1;

        Object b = -2 >> 1;

        System.out.println(a);
        System.out.println(b);


    }
}
