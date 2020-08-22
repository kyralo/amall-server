package online.kyralo.amall.common;

import online.kyralo.amall.common.utils.CommonUtil;
import online.kyralo.amall.common.utils.CopyUtil;
import online.kyralo.amall.web.vo.TbUserVO;
import org.junit.jupiter.api.Test;

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
    }

    @Test
    public void queryTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("avatarUrl", "2312313");

        TbUserVO tbUserVO = CopyUtil.copyMapToObject(map, TbUserVO.class);
        System.out.println(tbUserVO);

    }
}
