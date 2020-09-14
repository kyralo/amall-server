package online.kyralo.amall.common.utils;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/9/11
 * \* Time: 22:43
 * \* Description: 字符串工具类 [项目中使用到的关于字符串操作]
 * \
 */

@Component
public class StringUtil {

    private static final String COMMA = ",";

    public static List<String> commaSpilt(String str){

        if (str == null || !str.contains(COMMA)) {
            return Lists.newArrayList(str);
        }

        String[] strList = str.split(",");
        return Arrays.asList(strList);
    }

}
