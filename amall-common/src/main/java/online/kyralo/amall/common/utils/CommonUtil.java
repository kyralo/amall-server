package online.kyralo.amall.common.utils;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/6/30
 * \* Time: 22:25
 * \* Description: Amall 项目中使用到的一些通用方法
 * \
 */

@Component
public class CommonUtil {

    private static final String COMMA = ",";
    private static final String DECIMAL_POINT = ".";

    /**
     * id串 拆分
     *
     * @param idStr id串
     * @return id集合
     */
    public static ArrayList<String> idsParse(String idStr) {
        if ("".equals(idStr)) {
            return null;
        }

        if (!idStr.contains(COMMA)) {
            return Lists.newArrayList(idStr);
        }

        String[] split = idStr.split(COMMA);
        return Lists.newArrayList(Arrays.asList(split));
    }

    /**
     * 价格解析
     *
     * @param price 价格
     * @return 整数价格 + 小数位数
     * @throws Exception 价格为负,不合法
     */
    public static int[] priceParse(double price) throws Exception {

        if (price < 0) {
            throw new Exception("价格为负,不合法");
        }

        String priceStr = String.valueOf(price);
        int length = priceStr.length();

        if (!priceStr.contains(DECIMAL_POINT)) {
            return new int[]{(int) price, 0};
        }

        int index = priceStr.indexOf(DECIMAL_POINT);
        int decimalDigitst = length - (index + 1);
        double priceValue = price * Math.pow(10, decimalDigitst);

        return new int[]{(int) priceValue, decimalDigitst};
    }
}
