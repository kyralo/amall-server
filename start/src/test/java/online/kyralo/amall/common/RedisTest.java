package online.kyralo.amall.common;

import online.kyralo.amall.common.constants.SortEnum;
import online.kyralo.amall.common.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/9/7
 * \* Time: 10:08
 * \* Description: redis
 * \
 */

@SpringBootTest
public class RedisTest {

    /**
     * redis 分页测试
     */
    @Test
    public void zSetPageTest() {

        for (int i = 0; i < 20; i++) {
            RedisUtil.addZset("demo_zset", "h_" + i, (double) System.currentTimeMillis());
        }

        System.out.println(RedisUtil.getPage("demo_zset", 0, 5));
        System.out.println(RedisUtil.getPage("demo_zset", 3, 6));


        System.out.println(RedisUtil.getPage("demo_zset", 0, 5, SortEnum.ASC));
        System.out.println(RedisUtil.getPage("demo_zset", 3, 6, SortEnum.DESC));
    }

}
