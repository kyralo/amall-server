package online.kyralo.amall.common;

import online.kyralo.amall.common.utils.CommonUtil;
import online.kyralo.amall.common.utils.CopyUtil;
import online.kyralo.amall.web.vo.TbUserVO;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        TbUserVO build = TbUserVO.builder().avatarUrl("-----").build();
        TbUserVO build1 = TbUserVO.builder().avatarUrl("--22--").build();

        CopyUtil.copyBean(build, build1);
        System.out.println(build.getAvatarUrl());
        System.out.println(build1.getAvatarUrl());

        List<TbUserVO> userVOList = Lists.newArrayList();
        List<TbUserVO> objects = CopyUtil.copyList(userVOList, TbUserVO.class);


        System.out.println(objects);
    }
}
